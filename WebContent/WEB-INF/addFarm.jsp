<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-container">
	<form method="post">
		<div class="form-group"><input class="form-control" type="text" name="city" value="<c:out value=""/>" placeholder="city"></div>
         <div class="form-group"><input class="form-control" type="text" name="superficie" value="<c:out value=""/>" placeholder="superficie"></div>
		<div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Validate</button></div>
     </form>
 </div>