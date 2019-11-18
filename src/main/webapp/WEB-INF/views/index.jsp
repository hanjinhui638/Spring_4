<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./layout/bootStrap.jsp" />	
</head>
<body>
<c:import url="./layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id = "result">
	<input type="text" id = "num">
	<button id ="btn">CLICK</button>
	
</div>
<script type="text/javascript">
	$("#btn").click(function(){
		var num = $("#num").val();
											//data  = > response Text
		//$.get("./getNum?num="+num, function(data){
		//	$("#result").append(data);
			
		//});				//{파라미터:변수명}
		$.post("./getNum",{num:num} ,function(data) {
				$("#result").append(data);
		});
	});

</script>
</body>
</html>