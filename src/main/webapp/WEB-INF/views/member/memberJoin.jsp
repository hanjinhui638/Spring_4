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
      <input type="button" id="checkId" value = "중복확인">
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
    <!--   <div class="form-group">
      <label for="gender">gender:</label>
      <input type="text" class="form-control" id="gender" name = "gender">
    </div> -->
    <p>Gender</p>
	<div class="radio">
  	<label><input type="radio" name="gender" value="F" >F</label>
	</div>
	<div class="radio">
 	 <label><input type="radio" name="gender" value="M">M</label>
	</div>
    
     <button class="btn btn-info">Join</button>
  </form>
</div>

<script type="text/javascript">
		//$(선택자).action();
		$("#checkId").click(function() {
			var id = $("#id").val();
			window.open("./memberCheckId?id="+id,"", "width=700, height=200, left=400, top=200");
		}); //callback함수 
		
		
</script>


</body>
</html>
