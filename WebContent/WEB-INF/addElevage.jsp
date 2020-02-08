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
		<div class="form-group"><input class="form-control" type="text" name="type_Elevage" value="<c:out value=""/>" placeholder="type Elevage"></div>
         <div class="form-group"><input class="form-control" type="text" name="superficie" value="<c:out value=""/>" placeholder="superficie"></div>
         <div class="form-group"><input class="form-control" type="text" name="headNumber" value="<c:out value=""/>" placeholder="head Number"></div>
		<div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Validate</button></div>
     </form>
 </div>
</body>
</html>