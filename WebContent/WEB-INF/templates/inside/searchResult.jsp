<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/>
<script>
	$("#submitSearch").submit(function(event) {
		event.preventDefault();
		search();
	}) 
	function search() {
		let pname = $("#searchValue").val();
		$("#allResults").empty();
		console.log(pname);
		if(pname != "") {
			$.get("http://localhost:8080/projetJEE/GetSearchResult?pname=" + pname, function(data) {
				console.log(data);
				if(data.plant.name != undefined) {
					//plant card result
					let resultCard  = '<div id="resultCard" class="search-result"><div id="plantResultCard" class="card"></div></div></br>'
					let cardTitle = '<h5 id="cardTitle" class="card-header" style="background-color:#39a351;color:white">' + data.plant.name + '</h5>';
					let resultContent = '<div id="carBody" class="card-body"><h5 id="resultTitle" class="card-title">' + data.plant.scienceName + '</h5><p id="cardContent" class="card-text">' + data.plant.insights + '</p></div>'
					$("#allResults").append(resultCard);
					$("#plantResultCard").append(cardTitle);
					$("#plantResultCard").append(resultContent);
					//disease card results
					for(let i = 0; i < data.diseases.length; i++) {
						let dname = data.diseases[i].name
						let treatment = data.diseases[i].treatmentName
						let levelOfDanger = data.diseases[i].levelOfDanger
						console.log(dname, treatment, levelOfDanger);
						let diseaseCard = '<div id="resultCard" class="search-result"><div id="'+dname+'_diseaseResultCard" class="card"></div></div></br>'
						let diseaseCardTitle = '<h5 id="cardTitle" class="card-header" style="background-color:#a00f0f;color:white">' + dname + '</h5>';
						let diseaseResultContent = '<div id="carBody" class="card-body"><h5 id="resultTitle" class="card-title">Level Of danger : ' + levelOfDanger + '</h5><p id="cardContent" class="card-text">' + treatment + '</p></div>'
						$("#allResults").append(diseaseCard);
						$('#' + dname + '_diseaseResultCard').append(diseaseCardTitle);
						$('#' + dname + '_diseaseResultCard').append(diseaseResultContent);
					}
				}
			})
		}
	}

</script>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
				<h2>
					Search for Insights
                </h2>
                <div id="allResults" class="ibox-content">
                	<!-- Search Results Here ! -->

                </div>
            </div>
        </div>
    </div>
</div>