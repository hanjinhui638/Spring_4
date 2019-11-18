<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"></c:import>
</head>
<body>
	<div class = "container">
	<h1>${param.id} (은)는 ${result}</h1> 
	
		<form class="form-inline" action="./memberCheckId">
		
  		<div class="form-group">
   		 <label for="id">ID:</label>
    	<input type="text" class="form-control" value="${param.id}" id="id" placeholder="id입력" name = "id"> <%-- ${dto.id} null값  name= "id"--%>
 		 </div>
 	 <button type="submit" class="btn btn-default">Submit</button>
 	 <c:if test="${empty dto}">
 	 <input type="button" id="useId" value = "사용하기">
 	 </c:if>
	</form> 
	
	</div>
	<script type="text/javascript">
		$("#useId").click(function() {
			var id = $("#id").val();
			
			//javascript
			//opener.document.getElementById("id").value=id;
			
			//jquery
			$("#id", opener.document).val(id);
			
			window.self.close();
	});


</script>
	

</body>
</html>