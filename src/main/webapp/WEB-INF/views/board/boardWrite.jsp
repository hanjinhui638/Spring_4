
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
	<div class="container">
	  <h2>${board} Write Form</h2>
	  <form action="${board}Write" method="post" enctype="multipart/form-data">
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea  rows="20" cols="50" class="form-control" id="contents" placeholder="Enter Contents" name="contents"></textarea>
	    </div>
	    
	    <div id = "files">
	    <div class = "form-group">
	      <label for="file" class = "control-label col-sm-2" >File:</label>
	      <div class = "col-sm-9">
	      <input type="file" class="form-control " id="file" name="file">
	      </div>
	      <div class = "col-sm-1">
	      <input type="button" class="form-control btn btn-danger del" value="del">
	      </div>
	    </div>
	    </div>
	    
			<input type="button" class = "btn btn-success" value="Add File" id = "add">
	    </form>
	    	 <button class="btn btn-info">Submit</button>
	</div>
	<script type="text/javascript">
		var files = $("#files").html(); //click event 밖에 선언 
		var count =0; 		//안에 선언하면 초기화
	
		$("#files").empty(); //내용만지움 vs remove(전체를지움)
		
		
		$("#add").click(function () {
				if(count<5){
				$("#files").append(files);
				count++;
				}else{
					alert("최대 5개 가능");
				}
		});
		
		
		$(".del").click(function() {
			vent.preventDefault();
			alert("del");
		});
		
	
	</script>
	
</body>
</html>