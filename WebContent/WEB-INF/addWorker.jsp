<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="form-container">
            <div class="image-holder" style="background:url(&quot;https://farmassistantassets.fra1.digitaloceanspaces.com/assets/outside/img/meeting.jpg&quot;)"></div>
            <form method="post" onsubmit="return validate()" >
                <h2 class="text-center"><strong>Create</strong> your Worker account.</h2>
                <div class="form-group"><input class="form-control" type="email" name="email" value="<c:out value="${worker.email}"/>" placeholder="Email"></div>
                <div class="form-group" >${workerForm.erreurs['email']}</div>
                <div class="form-group"><input class="form-control" type="text" name="prenom" value="<c:out value=""/>" placeholder="First Name"></div>
                <div class="form-group"><input class="form-control" type="text" name="nom" value="<c:out value=""/>" placeholder="Last Name"></div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
                <div class="form-group" >${workerForm.erreurs['password']}</div>
                <div class="form-group"><input class="form-control" type="password" name="password_repeat"  placeholder="Password (repeat)"></div>
                <div class="form-group" >${workerForm.erreurs['confirmation']}</div>
                <div class="form-group">
                    <input class="form-control" type="text" name="salary"  placeholder="Salary"></div>
                </div>
 				<div class="form-group" >${workerForm.resultat}</div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Sign Up</button>
                </form>
        </div>

</body>
</html>