<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="templout" value="templates/outside/" scope="page"/>
<!DOCTYPE html>
<html>

<head>
	<c:import url="${templout}header.jsp"></c:import> 
</head>

<body>
    <div>
        <div class="header-dark" style="background-image: url(&quot;assets/outside/img/shutterstock_62363965-1900x1000.jpg&quot;);padding-bottom: 0px;">
		<c:import url="${templout}navbar.jsp"></c:import>
    	</div>
    </div>
    <div class="login-clean">
        <form method="post" action="login" >
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><i class="icon ion-log-in" style="color: rgb(6,4,25);"></i></div>
            <div class="form-group"><input class="form-control" type="email" name="email" value="<c:out value="${user.email}"/>" placeholder="Email"></div>
            <div class="form-group" >${LoginForm.erreurs['email']}</div>
            <div class="form-group"><input class="form-control" type="password" name="password"  placeholder="Password"></div>
            <div class="form-group" >${LoginForm.erreurs['password']}</div>
            <div class="form-group" >${LoginForm.resultat}</div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: #39a351;">Log In</button></div><a class="forgot" href="#">Forgot your password?</a>
    	</form>
    		
    </div>
	<c:import url="${templout}footer.jsp"></c:import>
</body>

</html>