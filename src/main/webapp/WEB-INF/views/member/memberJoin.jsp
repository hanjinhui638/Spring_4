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
  <h2>Join</h2>
  <p>The form below contains two input elements</p>
  <form action="./memberJoin" method="post">
  
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" name ="id">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" name ="pw">
    </div>
    <!--  <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control">
    </div> -->
     <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name = "name">
    </div>
     <div class="form-group">
      <label for="email">E-mail:</label>
      <input type="text" class="form-control" id="email" name = "email">
    </div>
      <div class="form-group">
      <label for="birth">Birth:</label>
      <input type="text" class="form-control" id="birth" name = "birth">
    </div>
      <div class="form-group">
      <label for="gender">gender:</label>
      <input type="text" class="form-control" id="gender" name = "gender">
    </div>
    
<!--     <div class="radio">
  	<label><input type="radio" name="optradio" checked>F</label>
	</div>
	<div class="radio">
 	 <label><input type="radio" name="optradio">M</label>
	</div>
     -->
    
     <button class="btn btn-info">Join</button>
  </form>
</div>

</body>
</html>
