<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/>
<!-- Button trigger modal -->
<!-- <button href=""><a href="${pageContext.request.contextPath}/farmanager/addFarm">Add Farm</a></button> -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addElevageModal">
  Add Breeding
</button>
<!-- Modal -->
<div class="modal fade" id="addElevageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Breeding</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<div class="form-container">
			<form method="post" action="${pageContext.request.contextPath}/farmanager/addElevage">
				<div class="form-group"><input class="form-control" type="text" name="type_Elevage" value="<c:out value=""/>" placeholder="type Elevage"></div>
		        <div class="form-group"><input class="form-control" type="text" name="superficie" value="<c:out value=""/>" placeholder="superficie"></div>
		        <div class="form-group"><input class="form-control" type="text" name="headNumber" value="<c:out value=""/>" placeholder="head Number"></div>
				<div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Validate</button></div>
		    </form>
		 </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>