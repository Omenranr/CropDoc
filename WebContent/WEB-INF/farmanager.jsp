<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/>
<!DOCTYPE html>
<html>
<head>
	<c:import url="${templinside}header.jsp"></c:import>
</head>
<body>
    <div id="wrapper">
    	<c:import url="${templinside}navbarside.jsp"></c:import>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
            	<c:import url="${templinside}navbartop.jsp"></c:import>
	            <div class="container-fluid">
	                <div class="d-sm-flex justify-content-between align-items-center mb-4">
	                    <h3 class="text-dark mb-0">Farm Manager</h3>
	            	</div>
	            		<div>
	            	  <c:if test="${userType=='farmer'}" >
						<c:if test="${ferme!= null}">
						<div class="container">
							<c:import url="${templinside}/addTaskForm.jsp"></c:import>
		            	  	<c:import url="${templinside}/addElevageForm.jsp"></c:import>
		            	  	<c:import url="${templinside}/addParcelleForm.jsp"></c:import>
		            	  	<c:import url="${templinside}/addWorkerForm.jsp"></c:import>
		            	  	<c:import url="${templinside}/parcelleUpdateForm.jsp"></c:import>
		            	  	<c:import url="${templinside}/elevageUpdateForm.jsp"></c:import>
						</div>
	            	  	</br>
	            		<c:import url="${templinside}/farmLister.jsp"></c:import>
	           		  </c:if>
	           		  <c:if test="${ferme==null}">
    						<c:import url="${templinside}/addFarmForm.jsp"></c:import>
					  </c:if>
	           		  </c:if>
	           		  <c:if test="${userType=='worker'}" >
	           		  	<h4>List of tasks</h4>
	            			<table>	
	           					<c:forEach items="${taches}" var="tache">
	           						<tr>
	   	           						<td>${tache.designation}</td>
	   	           						<td>date de debut ${tache.dateDebut}</td>
	   	           						<td>date de fin ${tach.dateFin}</td>
	   	           						<td><a href="/deletetache?delete=${tache.id_task}"></a>Delete</td>	   	           		
	   	           					</tr>
	           					</c:forEach>
	           				</table>
	           		  </c:if>
	           		  
	           			</div>
	            </div>
        	</div>
        	<c:import url="${templinside}footer.jsp"></c:import>
    	</div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    <c:import url="${templinside}scripts.jsp"></c:import>
</body>
</html>