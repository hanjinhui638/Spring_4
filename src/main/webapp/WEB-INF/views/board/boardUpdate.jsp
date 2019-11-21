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
	  <h2>${board} Update Form</h2>
	  <form action="${board}Update" method="post">
	  	
	  	<div class="form-group">
	      <input type="hidden" class="form-control" value="${update.num}" id="num" name="num">
	    </div>
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" value="${update.title}" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" value="${update.writer}" readonly="readonly" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea  rows="20" cols="50" class="form-control" id="contents" placeholder="Enter Contents" name="contents">${update.contents}</textarea>
	    </div>
	    
	    
	      <div id = "files">
	    	<div class = "form-group" title = "parent" >
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
	    
	    <div class = "form-group">
	    <c:forEach items="${update.files}" var= "file">
	    	<div id = "f${file.fnum}">
	    		<p>${file.oname}<input type="button" value="del" class = "del_file" id = "${file.fnum}"></p>
	    	</div>
	    </c:forEach>
	    </div>
	    
	     <button class="btn btn-info">Submit</button>
	    </form>
	</div>
	
	
	
<script type="text/javascript">
		var files = $("#files").html();
		$("#files").empty();
		var count  = ${size};
		var count = 0;
		
		//위임이벤트 
		$("#files").on("click",".del",function(){
			//$(this).parent().parent().remove();
			$(this).parents(".form-group").remove();
			count--;
		});
		
		$("#add").click(function(){
			if(count<5){
				$("#files").append(files);
				count++;
			}else{
				alert("최대 5개 가능")
			}
			
		});
		
		
		$(".del_file").click(function() {
			var fnum = $(this).attr("id");
			
			//alert(fnum); test
			
			$.post("./fileDelete", {fnum:fnum},function(data){		
				data = data.trim(); 			//공백제거 꼭!! 
				
				if(data == '1'){
						$("#f"+fnum).remove(); 	//this = data //공통된 것으로 묶어주기 
						count--;
				}
				alert(data);
				console.log(); 
			});
		});
	
	</script>
	
</body>
</html>