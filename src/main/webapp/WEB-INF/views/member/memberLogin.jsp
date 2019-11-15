<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
<div class="container">
  <h2>Login</h2>
  <p>The form below contains two input elements</p>
  <form action="./memberLogin" method="post">
  
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" name ="id">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" name = "pw">
    </div>
    	<button class="btn btn-info">Login</button>
  </form>
</div>


</body>
</html>