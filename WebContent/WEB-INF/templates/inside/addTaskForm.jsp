<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/>
<script>
	function showWorkers() {
		$("#workersTable").empty();
		$.get("http://localhost:8080/projetJEE/farmanager/addTask", function(data) {
			console.log(data);
			for(let i = 0; i < data.workers.length; i++) {
				let worker = data.workers[i]
				let ligne = '<tr><td>'+worker.email+'</td><td><div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox" name="'+worker.id+'" value="affectTask">affect.</label></div></td></tr>'
				$("#workersTable").append(ligne);
			}
		})
	}
</script>
<!-- Button trigger modal -->
<!-- <button href=""><a href="${pageContext.request.contextPath}/farmanager/addFarm">Add Farm</a></button> -->
<button type="button" onclick="showWorkers()" class="btn btn-primary" data-toggle="modal" data-target="#addTaskModal">
  Add Task
</button>
<!-- Modal -->
<div class="modal fade" id="addTaskModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Task</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
<div class="form-container">
	<form method="post" action="${pageContext.request.contextPath}/farmanager/addTask">
		<div class="form-group"><input class="form-control" type="text" name="designation" value="<c:out value=""/>" placeholder="designation"></div>
         <div class="form-group"><input class="form-control" type="text" name="urgency" value="<c:out value=""/>" placeholder="urgency"></div>
         <div class="form-group"><input class="form-control" type="date" name="dateDebut" value="<c:out value=""/>" placeholder="date de Debut"></div>
         <div class="form-group"><input class="form-control" type="date" name="dateFin" value="<c:out value=""/>" placeholder="date de Fin"></div>
         
         <h4>List of workers</h4>
	            			<table id="workersTable">	
	            			
	           				</table>
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