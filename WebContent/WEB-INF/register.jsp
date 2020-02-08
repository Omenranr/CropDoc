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
    <div class="register-photo">
        <div class="form-container">
            <div class="image-holder" style="background: url(&quot;https://i.pinimg.com/originals/83/a4/b3/83a4b3f2217abbbbeed2da8b5ef7ed77.jpg&quot;);background-repeat: no-repeat;height: 100%;"></div>
            <form method="post" onsubmit="return validate()" >
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group"><input class="form-control" type="email" name="email" value="<c:out value="${user.email}"/>" placeholder="Email"></div>
                <div class="form-group" >${registerForm.erreurs['email']}</div>
                <div class="form-group"><input class="form-control" type="text" name="prenom" value="<c:out value=""/>" placeholder="First Name"></div>
                <div class="form-group"><input class="form-control" type="text" name="nom" value="<c:out value=""/>" placeholder="Last Name"></div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
                <div class="form-group" >${registerForm.erreurs['password']}</div>
                <div class="form-group"><input class="form-control" type="password" name="password_repeat"  placeholder="Password (repeat)"></div>
                <div class="form-group" >${registerForm.erreurs['confirmation']}</div>
                <div class="form-group">
    				<select class="form-control" name="user_type" id="exampleFormControlSelect1">
      				<option value="farmer" >farmer</option>
      				<option value="user">user</option>
      				</select>
  				</div>
                <div class="form-group">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox">I agree to the license terms.</label></div>
                </div>
 				<div class="form-group" >${registerForm.resultat}</div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Sign Up</button></div><a class="already" href="#">You already have an account? Login here.</a>
                </form>
        </div>
    </div>
    <c:import url="${templout}footer.jsp"></c:import>
</body>

</