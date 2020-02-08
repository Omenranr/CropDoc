<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/> 
<!DOCTYPE html>
<html>
<head>
	<h3>Update Elevage</h3>
</head>
<body>
<div class="container-fluid">
	                <div class="d-sm-flex justify-content-between align-items-center mb-4">
	                    <h3 class="text-dark mb-0">Explore</h3>
	                    <div class="form-container">
							<form method="post">
								<div class="form-group"><input class="form-control" type="text" name="type_Elevage" value="<c:out value="${elevage.type_Elevage}"/>" placeholder="type Elevage"></div>
         							<div class="form-group"><input class="form-control" type="text" name="superficie" value="<c:out value=""/>" placeholder="superficie"></div>
         							<div class="form-group"><input class="form-control" type="text" name="headNumber" value="<c:out value=""/>" placeholder="head Number"></div>
									<div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Validate</button></div>
     						</form>
						 </div>
	                    
	                </div>
	     </div>
</body>
</html>