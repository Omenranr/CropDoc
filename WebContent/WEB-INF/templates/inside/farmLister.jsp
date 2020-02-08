<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="templinside" value="templates/inside/" scope="page"/>
<script>
	let splitedParcelle
	function updateParcelle(parcelle) {
		splitedParcelle = parcelle.split(",")
		console.log(splitedParcelle)
		let parcelId = splitedParcelle[0];
		let parcelType = splitedParcelle[1];
		let parcelSuper = splitedParcelle[2];
		let parcelScienceName = splitedParcelle[3];
		let parcelFarmId = splitedParcelle[4];
		console.log(parcelId);
		$("#id_parcelle_update").val(parcelId);
		$("#id_parcelleFarm_update").val(parcelFarmId);
		$("#type_culture_update").attr("placeholder", parcelType).focus().blur();
		$("#superficie_update").attr("placeholder", parcelSuper).focus().blur();
		$("#scienceName_update").attr("placeholder", parcelScienceName).focus().blur();
	}
	function updateElevage(elevage) {
		splitedElevage = elevage.split(",")
		console.log(splitedElevage)
		let elevageId = splitedElevage[0];
		let elevageType = splitedElevage[1];
		let elevageSuper = splitedElevage[2];
		let elevageHeadNumber = splitedElevage[3];
		console.log(elevageType);
		$("#id_elevage_update").val(elevageId);
		$("#type_elevage_update").attr("placeholder", elevageType).focus().blur();
		$("#elevage_superficie_update").attr("placeholder", elevageSuper).focus().blur();
		$("#elevage_scienceName_update").attr("placeholder", elevageHeadNumber).focus().blur();
	}
</script>

<div class="container">
  <div class="row">
    <div class="col-sm">
      <h4>List of Breedings</h4>
      <table>	
	      	<c:forEach items="${ferme.elevage}" var="e">
		      	<tr>
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">${e.type_Elevage}</h5>
							<h6 class="card-subtitle mb-2 text-muted">Head number : ${e.headNumber}</h6>
							<p class="card-text">This is a ${e.type_Elevage} Breeding, with ${e.headNumber} animal number</p>
							<button style="background-color:#39a351" class="btn btn-primary" onclick="updateElevage('${e.id_Elevage},${e.type_Elevage},${e.superficie},${e.headNumber}')" data-toggle="modal" data-target="#updateElevageModal">Update</button>
							<a class="btn btn-primary" style="background-color:#de3737" href="${pageContext.request.contextPath}/farmanager/deleteElevage?id=${e.id_Elevage}">Delete</a>
						</div>
					</div>
		      	</tr>
	      	</c:forEach>
      </table>
    </div>
    <div class="col-sm">
		<h4>List of Parcels</h4>
        <table>	
	      	<c:forEach items="${ferme.parcelle}" var="p">
		      	<tr>
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">${p.type_culture}</h5>
							<h6 class="card-subtitle mb-2 text-muted">Scientific Name : ${p.scienceName}</h6>
							<p class="card-text">This is a ${p.type_culture}, with ${p.superficie} superficy</p>
							<button style="background-color:#39a351" class="btn btn-primary" onclick="updateParcelle('${p.id_parcelle},${p.type_culture},${p.superficie},${p.scienceName},${p.id_farm}')" data-toggle="modal" data-target="#updateParcelModal">Update</button>
							<a class="btn btn-primary" style="background-color:#de3737" href="${pageContext.request.contextPath}/farmanager/deleteParcelle?id=${p.id_parcelle}">Delete</a>
						</div>
					</div>
		      	</tr>
	      	</c:forEach>
        </table>
    </div>
  </div>
</div>