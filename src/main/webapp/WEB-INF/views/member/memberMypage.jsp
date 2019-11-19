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
  <h2>My page</h2>
  <p></p>
  <form>
    <div class="form-group">
    	 <label for="pw">Id:</label>
	      <input type="text" class="form-control" value="${member.id}" id="id" name="id" readonly="readonly">
	 </div>
   <!--  session scope생략 -->
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" name ="pw" value = "${member.pw}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name = "name" value = "${member.name}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="email">E-mail:</label>
      <input type="text" class="form-control" id="email" name = "email" value = "${member.email}" readonly="readonly">
    </div>
    
      <div class="form-group">
      <label for="birth">Birth:</label>
      <input type="text" class="form-control" id="birth" name = "birth" value = "${member.birth}" readonly="readonly">
    </div>
    
	 <div class="form-group">
      <label for="birth">Gender:</label>
      <input type="text" class="form-control" id="gender" name = "gender" value = "${member.gender}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="birth">Point:</label>
      <input type="text" class="form-control" id="point" name = "point" value = "${member.point}" readonly="readonly">
    </div>
    <div>
    	<img alt = "" src="../resources/upload/member/${member.fileName}">   
    </div>
  
 		<a class = "btn btn-primary" id = "up" href="./memberUpdate?id=${member.id}">정보수정</a>
 		<a class = "btn btn-danger" id = "del" href="./memberDelete?id=${member.id}">회원탈퇴</a>
		
  </form>
</div>




</body>
</html>