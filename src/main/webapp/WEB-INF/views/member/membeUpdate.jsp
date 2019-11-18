<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <c:import url="../layout/bootStrap.jsp" />
</head>
<body>
 	<c:import url="../layout/nav.jsp"/>
<div class="container">
  <h2>회원수정</h2>
  <p>The form below contains two input elements</p>
  <form action="./memberUpdate" method="post">
    <div class="form-group">
	      <input type="hidden" class="form-control" value="${member.id}" id="id" name="id">
	 </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" name ="pw" value = "${member.pw}">
    </div>
    
     <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name = "name" value = "${member.name}">
    </div>
    
     <div class="form-group">
      <label for="email">E-mail:</label>
      <input type="text" class="form-control" id="email" name = "email" value = "${member.email}">
    </div>
    
      <div class="form-group">
      <label for="birth">Birth:</label>
      <input type="text" class="form-control" id="birth" name = "birth" value = "${member.birth}">
    </div>
    
	<ul class = "list-group">
		<li class = "list-group-item">Gender: ${member.gender}</li>
	</ul>
  
 		<a class = "btn btn-primary" href="./memberUpdate?id=${member.id}">Update</a>
 		<a class = "btn btn-danger" href="./memberDelete?id=${member.id}">Delete</a>
		
  
  </form>
</div>




</body>
</html>