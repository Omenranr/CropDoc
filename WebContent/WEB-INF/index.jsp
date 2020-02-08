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
        <div class="header-dark" style="background-image: url(&quot;${cdn}assets/outside/img/shutterstock_62363965-1900x1000.jpg&quot;);">
		<c:import url="${templout}navbar.jsp"></c:import>
        <div class="container hero">
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <h1 class="text-center">The Revolution is Here.</h1>
                    <div style="height: 350px;"><iframe allowfullscreen="" frameborder="0" src="https://www.youtube.com/embed/V6n_CoLOhig?autoplay=1&amp;mute=1&amp;loop=1&amp;playlist=V6n_CoLOhig&amp;controls=0" style="width: 100%;height: 100%;"></iframe></div>
                </div>
            </div>
        </div>
    	</div>
    </div>
    <div class="features-boxed">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Features </h2>
                <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet vitae.</p>
            </div>
            <div class="row justify-content-center features">
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-heart icon" style="color: rgb(255,0,0);"></i>
                        <h3 class="name">Detect plant diceases</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p>
                        <a class="learn-more" href="${pageContext.request.contextPath}/features">Learn more »</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-eye icon"></i>
                        <h3 class="name">Supervise your farm</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p>
                        <a class="learn-more" href="${pageContext.request.contextPath}/features">Learn more »</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-lightbulb-o icon" style="color: rgb(255,216,10);"></i>
                        <h3 class="name">Get Insights</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p>
                        <a class="learn-more" href="${pageContext.request.contextPath}/features">Learn more »</a></div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="${templout}footer.jsp"></c:import>
</body>

</html>