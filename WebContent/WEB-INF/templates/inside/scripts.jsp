<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cdn" value="https://farmassistantassets.fra1.digitaloceanspaces.com/" scope="page"/>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${cdn}assets/inside/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
    <script src="${cdn}assets/inside/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
    <script src="${cdn}assets/inside/js/theme.js"></script>
    
    
    <!-- Notifications-->
    			<script type="text/javascript">
    
    			// SELECT ELEMENTS 
    			const total = document.getElementById("total");
				let totalcpt = 0 ;
    			// APP CONSTS
    			const MaxNbre = 5;
				
    			function readNotifications(){
                // Get ID USER         
    				id_user = "${sessionScope.sessionUtilisateur.id}";
    			//Send Request to Servlet to get DATA
    				$.get(
    						"NotifServlet", { Id : id_user, job :"Read" },function(Notifs) { 
								displayNotifs(Notifs);
    							
    			    });
    				
    			//DISPLAY no-read-Notification in the UI
    			function displayNotifs(Notifs){
    				for(let i = 0; i<Notifs.length;i++){
    					if(Notifs[i].status == true){
    						totalcpt++;
    					date = Notifs[i].date;
    					content = Notifs[i].content;
    					console.log(content+"  "+date)
    					let node ;
        				node =  `<a class="d-flex align-items-center dropdown-item " href="#">
    					                        <div class="mr-3">
    					                            <div class="bg-warning icon-circle"><i class="fas fa-exclamation-triangle text-white"></i></div>
    					                        </div>
    					                        <div><span class="small text-gray-500" >`+date+`</span>
    					                            <p >`+content+`</p>
    					                        </div> 
    			                    	</a>  `; 
        				$("#notifications").append(node);
        				}
    					
    				}
    				if(totalcpt != 0){
    					total.innerHTML = totalcpt+ "+";
    					totalcpt = 0;
    				}
						
    			}
    				
    		}	
    			
    			//CHECK if there's other notifications every 10 secs
    			
    			readNotifications();
    			function doStuff() {
    				readNotifications();
    				$("#notifications").empty();
    				
    					}
    					setInterval(doStuff, 10000);
    				
    			//empty notif list if they was reas by user, change status to false
    	    			
    			    	$("#bell").click(function() { 
    			    	      $("#bell span").empty();     
    			    	}); 
    			    
    			    	$("#Alerts").focusout(function(){
    		    			//Send Request to Servlet to change status
    	    				$.get(
    	    						"NotifServlet", { Id : id_user, job :"Change" });
    			    		
    			    		$("#notifications").empty();
    			    		  });
    			
                   </script>
                   
                   
                   
  <!-- navbartop weather API -->
    			<script type="text/javascript">
    			
				let soutCity = "${sessionScope.userCity}";
				console.log(soutCity);
    			let userCity = "Rabat";

    			const coordinates = [
    				{ city : "Rabat", lat : 34.020000, lon : -6.830000 },
    				{ city : "Tanger", lat : 35.7595, lon : -5.8340 },
    				{ city : "Agadir", lat : 30.421440, lon : -9.583039 },
    				{ city : "Laayoune", lat : 27.158507, lon : -13.207878 },
    				{ city : "Casablanca", lat : 33.590000, lon : -7.610000 }
    			];
    			var coordinate = coordinates.find(elem => {elem.city == soutCity});
    			
    			//default result is Rabat
    			if(typeof coordinate === "undefined")
    					coordinate = coordinates[0];
				//get lat and lon of a city
			    let latitude = coordinate.lat;
				let longitude = coordinate.lon;
				

    			// SELECT ELEMENTS 
    			const iconElement = document.querySelector(".weather-icon");
    			const tempElement = document.querySelectorAll(".temperature-value p");
    			const descElement = document.querySelector(".temperature-description p");
    			const locationElement = document.querySelector(".location p");

    			// App data
    			const weather = {};


    			// APP CONSTS
    			const KELVIN = 273;
    			// API KEY
    			const key = "000970d0a40ad1fe1764468b9c731e76";


    			// GET WEATHER FROM API PROVIDER
    			function getWeather(latitude, longitude){
        
    			 let api = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid="+key;
    			        console.log(api);
    			    
    			    fetch(api)
    			        .then(function(response){
    			            let data = response.json();
    			            return data;
    			        })
    			        .then(function(data){
    			            weather.temperature = Math.floor(data.main.temp - KELVIN);
    			            weather.description = data.weather[0].description;
    			            weather.iconId = data.weather[0].icon;
    			            weather.city = data.name;
    			            weather.country = data.sys.country;
						console.log(weather.temperature);
    			        })
    			        .then(function(){
    			        	console.log(weather.city)
    			        	// DISPLAY WEATHER TO UI
    			        	iconElement.innerHTML = "<img src=\"http://openweathermap.org/img/wn/"+weather.iconId+".png\"/>";
    	    			    tempElement["0"].innerHTML = weather.temperature + "°C";
    	    			    tempElement[1].innerHTML = weather.temperature + "°C-";
    	    			    descElement.innerHTML = weather.description;
    	    			    locationElement.innerHTML = weather.city+", "+weather.country;
    			        });
    			}
    			getWeather(latitude, longitude);

					//Get the weather for every 10 secs
    	    			function doStuff2() {
    	    				getWeather(latitude, longitude);
    	    				console.log("******** You have the current weather")
    	    					}
    	    					setInterval(doStuff2, 10000);
    					
    			
                                
                   </script>