<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="weathericons" value="http://openweathermap.org/img/wn/" scope="page"/>
<c:set var="cdn" value="https://farmassistantassets.fra1.digitaloceanspaces.com/" scope="page"/> 
<nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                    <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                        <form id="submitSearch" class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group"><input id="searchValue" class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                <div id="searchButton" onclick="search()" class="input-group-append"><button class="btn btn-primary py-0" type="button" style="background-color: rgb(57,163,81);"><i class="fas fa-search"></i></button></div>
                            </div>
                        </form>
                        <ul class="nav navbar-nav flex-nowrap ml-auto">
                        
             <!-- Weather : Today -->
             
                            <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                                <div class="nav-item dropdown no-arrow">
                                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                                <i class="temperature-value" class="badge badge-warning " style="color:green;">
											<p style="margin-top: 15px;">${sessionScope.weatherToday.temperature} °<span>C</span></p>
								</i>
								</a>
                                   
                                    <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                        role="menu">
                                        <h6 class="dropdown-header">Today's weather</h6>
                                        <a class="d-flex align-items-center dropdown-item" href="#">
                                        
                                           <div class="weather-container" style="margin: 0 auto;color: #293251;font-size: 1.2em;">
											<div class="weather-icon">
											<img src="http://openweathermap.org/img/wn/${sessionScope.weatherToday.iconId}.png" alt="JsDoesntWork"/>
											
											</div>
											<div class="temperature-value" >
											<p >${sessionScope.weatherToday.temperature} °<span>C</span></p>
											</div>
											<div class="temperature-description" >
											<p >${sessionScope.weatherToday.description}</p>
											</div>
											<div class="location" >
											<p>${sessionScope.weatherToday.city}, ${sessionScope.weatherToday.country}</p>
											</div>
											</div>
                                            
                                        
                                        </a>
                                      
                                </div>
                            </li>

            <!-- notification -->
                            <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                                <div class="nav-item dropdown no-arrow" id="Alerts"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#" id="bell"><span class="badge badge-danger badge-counter" id="total" id="badgeCounter"></span><i class="fas fa-bell fa-fw"></i></a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                        role="menu">
                                        <h6 class="dropdown-header">alerts center</h6>
											<div id="notifications">
											
											
											</div>
  
                                        
                                        <a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                                </div>
                            </li>
                            
                  <!-- Message -->
                            <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-envelope fa-fw"></i><span class="badge badge-danger badge-counter">7</span></a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                        role="menu">
                                        <h6 class="dropdown-header">alerts center</h6>
                                        <a class="d-flex align-items-center dropdown-item" href="#">
                                            <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="${cdn}assets/inside/img/avatars/avatar4.jpeg">
                                                <div class="bg-success status-indicator"></div>
                                            </div>
                                            <div class="font-weight-bold">
                                                <div class="text-truncate"><span>Hi there! I am wondering if you can help me with a problem I've been having.</span></div>
                                                <p class="small text-gray-500 mb-0">Emily Fowler - 58m</p>
                                            </div>
                                        </a>
                                        <a class="d-flex align-items-center dropdown-item" href="#">
                                            <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="${cdn}assets/inside/img/avatars/avatar2.jpeg">
                                                <div class="status-indicator"></div>
                                            </div>
                                            <div class="font-weight-bold">
                                                <div class="text-truncate"><span>I have the photos that you ordered last month!</span></div>
                                                <p class="small text-gray-500 mb-0">Jae Chun - 1d</p>
                                            </div>
                                        </a>
                                        <a class="d-flex align-items-center dropdown-item" href="#">
                                            <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="${cdn}assets/inside/img/avatars/avatar3.jpeg">
                                                <div class="bg-warning status-indicator"></div>
                                            </div>
                                            <div class="font-weight-bold">
                                                <div class="text-truncate"><span>Last month's report looks great, I am very happy with the progress so far, keep up the good work!</span></div>
                                                <p class="small text-gray-500 mb-0">Morgan Alvarez - 2d</p>
                                            </div>
                                        </a>
                                        <a class="d-flex align-items-center dropdown-item" href="#">
                                            <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="${cdn}assets/inside/img/avatars/avatar5.jpeg">
                                                <div class="bg-success status-indicator"></div>
                                            </div>
                                            <div class="font-weight-bold">
                                                <div class="text-truncate"><span>Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</span></div>
                                                <p class="small text-gray-500 mb-0">Chicken the Dog · 2w</p>
                                            </div>
                                        </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                                </div>
                                <div class="shadow dropdown-list dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown"></div>
                            </li>
                            <div class="d-none d-sm-block topbar-divider"></div>
                            <li class="nav-item dropdown no-arrow" role="presentation">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><span class="d-none d-lg-inline mr-2 text-gray-600 small">${sessionScope.sessionUtilisateur.email}</span><img class="border rounded-circle img-profile" src="https://download.seaicons.com/icons/webalys/kameleon.pics/512/Farmer-icon.png"></a>
                                    <div
                                        class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu"><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a><a class="dropdown-item" role="presentation" href="#"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Settings</a>
                                        <a
                                            class="dropdown-item" role="presentation" href="#"><i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Activity log</a>
                                            <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/logOut"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Logout</a></div>
                    </div>
                    </li>
                    </ul>
            </div>
            </nav>