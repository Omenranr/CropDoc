<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="templout" value="templates/outside/" scope="page"/>
<c:set var="cdn" value="https://farmassistantassets.fra1.digitaloceanspaces.com/" scope="page"/>
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
    <div class="team-grid">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Team</h2>
                <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet.&nbsp; </p>
            </div>
            <div class="row people">
                <div class="col-md-4 col-lg-3 item">
                    <div class="box" style="background-image:url(${cdn}assets/outside/img/1.jpg)">
                        <div class="cover">
                            <h3 class="name">Ben Johnson</h3>
                            <p class="title">Musician</p>
                            <div class="social"><a href="#"><i class="fa fa-facebook-official"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 item">
                    <div class="box" style="background-image:url(${cdn}assets/outside/img/2.jpg)">
                        <div class="cover">
                            <h3 class="name">Emily Clark</h3>
                            <p class="title">Artist </p>
                            <div class="social"><a href="#"><i class="fa fa-facebook-official"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 item">
                    <div class="box" style="background-image:url(${cdn}assets/outside/img/3.jpg)">
                        <div class="cover">
                            <h3 class="name">Carl Kent</h3>
                            <p class="title">Stylist </p>
                            <div class="social"><a href="#"><i class="fa fa-facebook-official"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-3 item">
                    <div class="box" style="background-image:url(${cdn}assets/outside/img/4.jpg)">
                        <div class="cover">
                            <h3 class="name">Felicia Adams</h3>
                            <p class="title">Model </p>
                            <div class="social"><a href="#"><i class="fa fa-facebook-official"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="${templout}footer.jsp"></c:import>
</body>

</html>