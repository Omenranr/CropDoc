<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cdn" value="https://farmassistantassets.fra1.digitaloceanspaces.com/" scope="page"/>
	<input type='file' onchange="processImage(this);" />
	<img id="plantImage" src="http://placehold.it/254" height="254" width="254"/></br>
	<h5 id="classification"></h5>
	<button class="btn btn-primary" onclick="predict()" style="background-color: #39a351;margin-left:10%">Classify</button>
	<script type="text/javascript">
	const URL = "https://teachablemachine.withgoogle.com/models/lA_Kujjk/";
	let img, model, outputPred;
	const classesTomato = {
			"tomato_healthy": {
				outPut: "Heathy Tomato",
				pname: "Solanum lycopersicum",
				dname: "tomato_healthy",
			},
			"tomato_bacterial_spot": {
				outPut: "Tomato bacterial spot",
				pname: "Solanum lycopersicum",
				dname: "tomato_bacterial_spot",
			},
			"tomato_early_blight": {
				outPut: "Tomato early blight",
				pname: "Solanum lycopersicum",
				dname: "tomato_early_blight",
			},
			"tomato_late_blight": {
				outPut: "Tomato late blight",
				pname: "Solanum lycopersicum",
				dname: "tomato_late_blight",
			},
			"tomato_leaf_mold": {
				outPut: "Tomato leaf mold",
				pname: "Solanum lycopersicum",
				dname: "tomato_leaf_mold",
			},
			"tomato_mosaic_virus": {
				outPut: "Tomato mosaic virus",
				pname: "Solanum lycopersicum",
				dname: "tomato_mosaic_virus",
			},
			"tomato_septoria_leaf_spot": {
				outPut: "Tomato septoria leaf spot",
				pname: "Solanum lycopersicum",
				dname: "tomato_septoria_leaf_spot",
			},
			"tomato_spider_mites": {
				outPut: "Tomato spider mites",
				pname: "Solanum lycopersicum",
				dname: "tomato_spider_mites",
			},
			"tomato_target_spot": {
				outPut: "Tomato target spot",
				pname: "Solanum lycopersicum",
				dname: "tomato_target_spot",
			},
			"tomato_yellow_leaf_curl_virus": {
				outPut: "Tomato yellow leaf curl virus",
				pname: "Solanum lycopersicum",
				dname: "tomato_yellow_leaf_curl_virus",
			},
			"negative": {
				outPut: "Not a tomato or disease not recognized",
				pname: "uknown",
				dname: "uknown",
			},
			"apple_black_rot": {
				outPut: "Apple Black Rot",
				pname: "Apple",
				dname: "apple_black_rot",
			},
			"apple_cedar_rust": {
				outPut: "Apple Cedar Rust",
				pname: "Apple",
				dname: "apple_cedar_rust",
			},
			"apple_healthy": {
				outPut: "Apple Healthy",
				pname: "Apple",
				dname: "apple_healthy",
			},
			"apple_scab": {
				outPut: "Apple Scab",
				pname: "Apple",
				dname: "apple_scab",
			},
			"corn_cercospora_spot_gray_leaf_spot": {
				outPut: "corn_cercospora_spot_gray_leaf_spot",
				pname: "Corn",
				dname: "corn_cercospora_spot_gray_leaf_spot",
			},
			"potato_healthy": {
				outPut: "Potato Healthy",
				pname: "Solanum tuberosum",
				dname: "potato_healthy",
			},
			"potato_early_blight": {
				outPut: "Potato Early Blight",
				pname: "Solanum tuberosum",
				dname: "potato_early_blight",
			},
			"potato_late_blight": {
				outPut: "Potato Late Blight",
				pname: "Solanum tuberosum",
				dname: "potato_late_blight",
			},
			"grape_healthy": {
				outPut: "Grape Healthy",
				pname: "Grape",
				dname: "grape_healthy",
			},
			"grape_black_rot": {
				outPut: "Grape Black Rot",
				pname: "Grape",
				dname: "grape_black_rot",
			},
			"grape_leaf_blight": {
				outPut: "Grape Leaf Blight",
				pname: "Grape",
				dname: "grape_leaf_blight",
			},
			"corn_healthy": {
				outPut: "Corn Healthy",
				pname: "Corn",
				dname: "corn_healthy",
			}
	}
	async function init() {
	    const modelURL = URL + "model.json";
	    const metadataURL = URL + "metadata.json";
	    model = await tmImage.load(modelURL, metadataURL);
	    console.log("model loaded");
	}

	function readUrlAsync(input) {
	    return new Promise((resolve, reject) => {
	        let reader = new FileReader();
	        reader.onload = (e) => {
	            resolve(e.target.result);
	        }
	        reader.onerror = reject;
	        reader.readAsDataURL(input.files[0]);
	    })
	}

	async function processImage(input) {
	    if(input.files && input.files[0]) {
	        let dataURL = await readUrlAsync(input);
	        $('#plantImage').attr('src', dataURL);
	    }
	}

	async function predict() {
	    img = document.getElementById("plantImage");
	    if(img.src != "http://placehold.it/180") {
	        let prediction = await model.predict(img);
	        console.log(prediction);
	        outputPred = maxPred(prediction).className;
	        $("#classification").text(classesTomato[outputPred].outPut);
	    }
	}

	function maxPred(prediction) {
	    let maxProb = 0;
	    let maxIndex = 0;
	    for(let i = 0; i < prediction.length; i++) {
	        if(prediction[i].probability > maxProb) {
	            maxProb = prediction[i].probability;
	            maxIndex = i;
	        }
	    }
	    return prediction[maxIndex];
	}
	
	function getAnalysis() {
		let pname = classesTomato[outputPred].pname;
		let dname = classesTomato[outputPred].dname;
		let output = classesTomato[outputPred].outPut;
		console.log("pname :", pname, "dname :", dname);
		$.get("http://localhost:8080/projetJEE/getAnalysisServlet?pname=" + pname + "&dname=" + dname + "&asignToFarom=1", function(data){
			if(data) {
				if(data.plant.scienceName != undefined) {
					$("#reportCardTitle").text("Plant : " + data.plant.name);
					if(data.disease.name != undefined) {
						$("#reportCardText").text(data.treatment.treatment);
					} else {$("#reportCardText").text("No disease detected");}
					$("#reportCardPicture").attr('src', data.plant.picture);
					if(data.disease.name != undefined) {
						$("#reportCardInfos").text('Level of Danger : ' + data.disease.levelOfDanger);
					} else {$("#reportCardInfos").text('Level of Danger : no danger');}
					$("#reportCard").show();
				} else {
					$("#reportCard").hide();
				}
			}
		});
	}
	
	</script>
  