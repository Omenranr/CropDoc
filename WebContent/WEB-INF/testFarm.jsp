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
	                    <h3 class="text-dark mb-0">Farm Manager</h3><a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#" style="background-color: rgb(57,163,81);"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a>
	            	</div>
	            		<div>
	            	  <c:if test="${userType=='farmer'}" >	
	            		<c:if test="${ferme!= null}" >
    						<h4>List of workers</h4>
	            			<table>	
	           					<c:forEach items="${ferme.workers}" var="worker">
	           						<tr>
	   	           						<td>${worker.email}</td>
	   	           						<td><a href="${pageContext.request.contextPath}/deleteWorker?delete=${worker.id}">Delete</td>
	   	           						<td><a href="${pageContext.request.contextPath}/updateWorker?delete=${worker.id}">update</td>	   	           		
	   	           					</tr>
	           					</c:forEach>
	           				</table>
	            		
	           				<h4>List of elevage</h4>
	           				<table>	
	           					<c:forEach items="${ferme.elevage}" var="e">
	           						<tr>
	   	           						<td>${e.type_Elevage}</td>
	   	           						<td><a href="${pageContext.request.contextPath}/farmanager/deleteElevage?id=${e.id_Elevage}">Delete</td>	   	           		
	   	           						<td><a href="${pageContext.request.contextPath}/farmanager/updateElevage?id=${e.id_Elevage}">update</td>	   	           		
	   	           					</tr>
	           					</c:forEach>
	           				</table>
						</c:if>
	            		<c:if test="${ferme==null}">
    						<p>ADD Your ferme.</p>
						</c:if>
	           		  </c:if>
	           		  <c:if test="${userType=='worker'}" >
	           		  	<h4>List of tasks</h4>
	            			<table>	
	           					<c:forEach items="${taches}" var="tache">
	           						<tr>
	   	           						<td>${tache.designation}</td>
	   	           						<td><a href="/deletetache?delete=${tache.id_task}">Delete</td>	   	           		
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