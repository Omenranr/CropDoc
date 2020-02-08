<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/> 
<!DOCTYPE html>
<html>
<head>
	<c:import url="${templinside}header.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@1.3.1/dist/tf.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@teachablemachine/image@0.8/dist/teachablemachine-image.min.js"></script>
</head>
<body onload="init()">
    <div id="wrapper">
		<c:import url="${templinside}navbarside.jsp"></c:import>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <c:import url="${templinside}navbartop.jsp"></c:import>
	            <div class="container-fluid">
	                <div class="d-sm-flex justify-content-between align-items-center mb-4">
	                    <h3 class="text-dark mb-0">Disease Recognition</h3>
	                    <a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" onclick="getAnalysis()" href="#" style="background-color: rgb(57,163,81);"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a>
					</div>
					
					<!-- Analysis report -->
					<div class="container">
					<div class="row">
						<div class="col-sm">
							<c:import url="${templinside}dragndrop.jsp"></c:import>
    					</div>
    					<div id="reportCard" class="col-sm" style="display:none;">
	      					<div class="card" style="width:18rem;">
								<img id="reportCardPicture" class="card-img-top" src="holder.js/100px180/?text=Image cap" alt="Card image cap">
								<div class="card-body">
									<h5 id="reportCardTitle" class="card-title"></h5>
									<p id="reportCardText" class="card-text"></p>
								</div>
								<ul class="list-group list-group-flush">
									<li id="reportCardInfos" class="list-group-item"></li>
								</ul>
							</div>
    					</div>
  					</div>
</div>
					<!-- END Analysis report -->
	            </div>
        	</div>
			<c:import url="${templinside}footer.jsp"></c:import>
    	</div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    <c:import url="${templinside}scripts.jsp"></c:import>
</body>
</html>