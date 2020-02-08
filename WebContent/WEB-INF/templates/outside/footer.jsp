<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cdn" value="https://farmassistantassets.fra1.digitaloceanspaces.com/" scope="page"/>
    <div class="footer-basic">
        <footer>
            <div class="social"><a href="#"><i class="icon ion-social-linkedin"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-facebook"></i></a></div>
            <ul class="list-inline"
                style="color: rgb(0,0,0);">
                <li class="list-inline-item"><a href="${pageContext.request.contextPath}/" style="color: rgb(0,0,0);">Home</a></li>
                <li class="list-inline-item" style="color: rgb(57,163,81);"><a href="${pageContext.request.contextPath}/features" style="color: rgb(0,0,0);">Services</a></li>
                <li class="list-inline-item"><a href="${pageContext.request.contextPath}/about">About</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
            </ul>
            <p class="copyright">CropDoc © 2020</p>
        </footer>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${cdn}assets/inside/bootstrap/js/bootstrap.min.js"></script>
    <script src="${cdn}assets/outside/js/Sidebar-Menu.js"></script>