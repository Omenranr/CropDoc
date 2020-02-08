<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion p-0" style="background-color: #39a351;">
            <div class="container-fluid d-flex flex-column p-0">
                <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="${pageContext.request.contextPath}/home">
                    <div class="sidebar-brand-icon rotate-n-15"><i class="fa fa-leaf"></i></div>
                    <div class="sidebar-brand-text mx-3"><span>Cropdoc</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="nav navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/home"><i class="fas fa-home"></i><span>Home</span></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/farmanager"><i class="fas fa-eye"></i><span>Farm Manager</span></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/explore"><i class="fas fa-search"></i><span>Disease Search</span></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/dashboardUser"><i class="fas fa-tachometer-alt"></i><span>Dashboard</span></a></li>
                </ul>
                <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
            </div>
        </nav>