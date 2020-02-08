<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/> 
<!DOCTYPE html>
<html>

<head>
	<c:import url="${templinside}header.jsp"></c:import>
</head>

<body id="page-top">
    <div id="wrapper">
    	<c:import url="${templinside}navbarside.jsp"></c:import>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
            <c:import url="${templinside}navbartop.jsp"></c:import>
            <div class="container-fluid">
                <div class="d-sm-flex justify-content-between align-items-center mb-4">
                    <h3 class="text-dark mb-0">Dashboard</h3><a class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"><i class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generate Report</a></div>
                <div class="row">
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-primary py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-primary font-weight-bold text-xs mb-1"><span>Farmers (Numbre)</span></div>
                                        <div class="text-dark font-weight-bold h5 mb-0"><span>40</span></div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-success py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-success font-weight-bold text-xs mb-1"><span>Workers (Numbre)</span></div>
                                        <div class="text-dark font-weight-bold h5 mb-0"><span>215</span></div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-clipboard-list fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-info py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-info font-weight-bold text-xs mb-1"><span>Tasks</span></div>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col-auto">
                                                <div class="text-dark font-weight-bold h5 mb-0 mr-3"><span>50%</span></div>
                                            </div>
                                            <div class="col">
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-info" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;"><span class="sr-only">50%</span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-clipboard-list fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-warning py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-uppercase text-warning font-weight-bold text-xs mb-1"><span>Disease Recognition use</span></div>
                                        <div class="text-dark font-weight-bold h5 mb-0"><span>18 times</span></div>
                                    </div>
                                    <div class="col-auto"><i class="fas fa-comments fa-2x text-gray-300"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-7 col-xl-8">
                        <div class="card shadow mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h6 class="text-primary font-weight-bold m-0">Notifications Overview</h6>
                                <div class="dropdown no-arrow"><button class="btn btn-link btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><i class="fas fa-ellipsis-v text-gray-400"></i></button>
                                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                                        role="menu">
                                        <p class="text-center dropdown-header">dropdown header:</p><a class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a class="dropdown-item" role="presentation" href="#">&nbsp;Another action</a>
                                        <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="#">&nbsp;Something else here</a></div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="chart-area"><canvas data-bs-chart="{&quot;type&quot;:&quot;line&quot;,&quot;data&quot;:{&quot;labels&quot;:[&quot;Jan&quot;,&quot;Feb&quot;,&quot;Mar&quot;,&quot;Apr&quot;,&quot;May&quot;,&quot;Jun&quot;,&quot;Jul&quot;,&quot;Aug&quot;],&quot;datasets&quot;:[{&quot;label&quot;:&quot;Earnings&quot;,&quot;fill&quot;:true,&quot;data&quot;:[&quot;0&quot;,&quot;10000&quot;,&quot;5000&quot;,&quot;15000&quot;,&quot;10000&quot;,&quot;20000&quot;,&quot;15000&quot;,&quot;25000&quot;],&quot;backgroundColor&quot;:&quot;rgba(78, 115, 223, 0.05)&quot;,&quot;borderColor&quot;:&quot;rgba(78, 115, 223, 1)&quot;}]},&quot;options&quot;:{&quot;maintainAspectRatio&quot;:false,&quot;legend&quot;:{&quot;display&quot;:false},&quot;title&quot;:{},&quot;scales&quot;:{&quot;xAxes&quot;:[{&quot;gridLines&quot;:{&quot;color&quot;:&quot;rgb(234, 236, 244)&quot;,&quot;zeroLineColor&quot;:&quot;rgb(234, 236, 244)&quot;,&quot;drawBorder&quot;:false,&quot;drawTicks&quot;:false,&quot;borderDash&quot;:[&quot;2&quot;],&quot;zeroLineBorderDash&quot;:[&quot;2&quot;],&quot;drawOnChartArea&quot;:false},&quot;ticks&quot;:{&quot;fontColor&quot;:&quot;#858796&quot;,&quot;padding&quot;:20}}],&quot;yAxes&quot;:[{&quot;gridLines&quot;:{&quot;color&quot;:&quot;rgb(234, 236, 244)&quot;,&quot;zeroLineColor&quot;:&quot;rgb(234, 236, 244)&quot;,&quot;drawBorder&quot;:false,&quot;drawTicks&quot;:false,&quot;borderDash&quot;:[&quot;2&quot;],&quot;zeroLineBorderDash&quot;:[&quot;2&quot;]},&quot;ticks&quot;:{&quot;fontColor&quot;:&quot;#858796&quot;,&quot;padding&quot;:20}}]}}}"></canvas></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5 col-xl-4">
                        <div class="card shadow mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h6 class="text-primary font-weight-bold m-0">DISEASE Overview</h6>
                                <div class="dropdown no-arrow"><button class="btn btn-link btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button"><i class="fas fa-ellipsis-v text-gray-400"></i></button>
                                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                                        role="menu">
                                        <p class="text-center dropdown-header">dropdown header:</p><a class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a class="dropdown-item" role="presentation" href="#">&nbsp;Another action</a>
                                        <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="#">&nbsp;Something else here</a></div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="chart-area"><canvas data-bs-chart="{&quot;type&quot;:&quot;doughnut&quot;,&quot;data&quot;:{&quot;labels&quot;:[&quot;Direct&quot;,&quot;Social&quot;,&quot;Referral&quot;],&quot;datasets&quot;:[{&quot;label&quot;:&quot;&quot;,&quot;backgroundColor&quot;:[&quot;#4e73df&quot;,&quot;#1cc88a&quot;,&quot;#36b9cc&quot;],&quot;borderColor&quot;:[&quot;#ffffff&quot;,&quot;#ffffff&quot;,&quot;#ffffff&quot;],&quot;data&quot;:[&quot;50&quot;,&quot;30&quot;,&quot;15&quot;]}]},&quot;options&quot;:{&quot;maintainAspectRatio&quot;:false,&quot;legend&quot;:{&quot;display&quot;:false},&quot;title&quot;:{}}}"></canvas></div>
                                <div
                                    class="text-center small mt-4"><span class="mr-2"><i class="fas fa-circle text-primary"></i>&nbsp;Parcelle</span><span class="mr-2"><i class="fas fa-circle text-success"></i>&nbsp;elevage</span><span class="mr-2"><i class="fas fa-circle text-info"></i>&nbsp;others</span></div>
                        </div>
                    </div>
                </div>
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