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

<script type="text/javascript">	
	//전역변수 
	var xmlhttp;
	if (window.XMLHttpRequest) {
	   // code for modern browsers
	   // 데이터타입을 안 쓰면 자동으로 전역변수 
	   xmlhttp = new XMLHttpRequest();
	 } else {
	   // code for old IE browsers
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//request 정보 
	xmlhttp.open("GET", "./testAjax");	/* root밑 폴더명으로 생각*/
	
	//Get
	xmlhttp.send();
	
	xmlhttp.onreadystatechange=function(){
		if(this.readystate==4 && this.status == 200){
			alert(this.responseText);
		}
		
	}
	
</script>

</body>
</html>