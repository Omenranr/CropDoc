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
	                    <c:import url="${templinside}searchResult.jsp"></c:import>
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