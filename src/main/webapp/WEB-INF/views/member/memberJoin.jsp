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
  <!-- form -> reset, submit(controller로) -->
  <form action="./memberJoin" method="post" id="frm" enctype="multipart/form-data">
  
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" name ="id">
		<div id = "checkIdResult"></div>    <!-- 덮어씌우기   -->
    </div>
   
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" name ="pw">
    </div>
  
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
  
    <p>Gender</p>
	<div class="radio">
  	<label><input type="radio" name="gender" value="F" >F</label>
	</div>
	<div class="radio">
 	 <label><input type="radio" name="gender" value="M">M</label>
	</div>
	
	<!-- file -->
	<div class="form-group">
      <label for="file">File:</label>
      <input type="file" class="form-control" id="file" name = "file">
    </div>
	
	
     <input type = "submit" id ="join" class="btn btn-info" value = "Join">
  </form>
</div>

<script type="text/javascript">
	var idCheck = false; //false: 중복된 ID, 또는 중복 검사를 하지 않는 경우 
						 //true : 중복되지 않은 ID

	$("#join").click(function(){
		if(idCheck){
			$("#frm").submit();
		}
	});

	$("#id").blur(function() {
		var id = $(this).val();
		
		$.post("./memberCheckId",{id:id}, function(data){
			data = data.trim(); //공백제거
			if(data=='pass'){
				$("#checkIdResult").html('사용가능 ID');
				$("#checkIdResult").attr("class","text-success" );
				idCheck=true;
			}else{
				//$("#id").after('중복된 ID');
				$("#checkIdResult").html('중복된 ID');
				$("#checkIdResult").attr("class","text-danger");
				$("#id").val(" "); //id 공백으로 
				//$("#id").focus();
				idCheck=false;
			}
				
				
		});
	});
	
	$("#email").blur(function() {
		var email = $(this).val();
		
		
	});
	
	
		
		
</script>


</body>
</html>
