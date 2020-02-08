<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="form-container">
	<form method="post">
		<div class="form-group"><input class="form-control" type="text" name="designation" value="<c:out value=""/>" placeholder="designation"></div>
         <div class="form-group"><input class="form-control" type="text" name="urgency" value="<c:out value=""/>" placeholder="urgency"></div>
         <div class="form-group"><input class="form-control" type="date" name="datDebut" value="<c:out value=""/>" placeholder="date de Debut"></div>
         <div class="form-group"><input class="form-control" type="date" name="dateFin" value="<c:out value=""/>" placeholder="date de Fin"></div>
         
         <h4>List of workers</h4>
	            			<table>	
	           					<c:forEach items="${workers}" var="worker">
	           						<tr>
	   	           						<td>${worker.email}</td>
	   	           						<td><div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox" name="${worker.id}" value="affectTask">affect.</label></div></td>	   	           		
	   	           					</tr>
	           					</c:forEach>
	           				</table>
		<div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Validate</button></div>
     	
     </form>
 </div>
</body>
</html>