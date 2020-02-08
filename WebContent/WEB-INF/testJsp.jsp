<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="templout" value="templates/outside/" scope="page"/>   
<!DOCTYPE html>
<html>

<head>
	<c:import url="${templout}header.jsp"></c:import> 
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
</head>

<body>
    
    <div class="register-photo">
        <div class="form-container">
            <div class="image-holder" style="background:url(&quot;https://farmassistantassets.fra1.digitaloceanspaces.com/assets/outside/img/meeting.jpg&quot;)"></div>
            <form method="post" onsubmit="return validate()" >
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group"><input class="form-control" type="email" name="email" value="${sessionScope.sessionUtilisateur.email}" placeholder="Email"></div>
                <div class="form-group" >${profileForm.erreurs['email']}</div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
                <div class="form-group" >${profileForm.erreurs['password']}</div>
                <div class="form-group"><input class="form-control" type="password" name="password_repeat"  placeholder="Password (repeat)"></div>
                <div class="form-group" >${profileForm.erreurs['confirmation']}</div>
                <div class="form-group">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox">I agree to the license terms.</label></div>
                </div>
 				<div class="form-group" >${profileForm.resultat}</div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Sign Up</button></div><a class="already" href="#">You already have an account? Login here.</a>
                </form>
        </div>
    </div>
    <c:import url="${templout}footer.jsp"></c:import>
</body>

</