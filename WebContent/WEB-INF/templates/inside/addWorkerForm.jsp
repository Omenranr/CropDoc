<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="templinside" value="templates/inside/" scope="page"/>
<!-- Button trigger modal -->
<!-- <button href=""><a href="${pageContext.request.contextPath}/farmanager/addFarm">Add Farm</a></button> -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Add Worker
</button>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add a Worker</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method="post" action="${pageContext.request.contextPath}/farmanager/addWorker">
        		<h2 class="text-center"><strong>Create</strong> your Worker account.</h2>
                <div class="form-group"><input class="form-control" type="email" name="email" value="<c:out value="${worker.email}"/>" placeholder="Email"></div>
                <div class="form-group" >${workerForm.erreurs['email']}</div>
                <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
                <div class="form-group" >${workerForm.erreurs['password']}</div>
                <div class="form-group"><input class="form-control" type="password" name="password_repeat"  placeholder="Password (repeat)"></div>
                <div class="form-group" >${workerForm.erreurs['confirmation']}</div>
 				<div class="form-group" >${workerForm.resultat}</div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit"  style="background-color:#39a351;">Sign Up</button></div>
     	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>