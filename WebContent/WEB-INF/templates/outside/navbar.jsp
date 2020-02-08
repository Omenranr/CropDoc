<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

            <nav class="navbar navbar-dark navbar-expand-lg navigation-clean-search" style="background-color: #ffffff;">
                <div class="container"><a class="navbar-brand" style="color: rgb(57,163,81);" href="/projetJEE/">CropDoc</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1" style="background-color: rgb(57,163,81);"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div
                        class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav">
                            <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/" style="color: rgb(0,0,0);">Home</a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/about" style="color: rgb(0,0,0);">About Us</a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/features" style="color: rgb(0,0,0);">Features</a></li>
                        </ul>
                        <form class="form-inline mr-auto" target="_self">
                            <div class="form-group"><label for="search-field"></label></div>
                        </form><span class="navbar-text"><a class="login" href="${pageContext.request.contextPath}/login" style="color: rgb(0,0,0);">Log In</a></span><a class="btn btn-light action-button" role="button" href="${pageContext.request.contextPath}/register" style="color: rgb(255,255,255);background-color: rgb(57,163,81);">Sign Up</a></div>
        </div>
        </nav>