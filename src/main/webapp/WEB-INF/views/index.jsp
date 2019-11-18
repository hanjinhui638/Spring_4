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
<div class = "container">
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id = "noticeResult" class="alert alert-warning">
	
</div>

<div >
	
	<select id = "select">
		<option value = "d">Dog</option>
		<option value = "c">Cat</option>
		<option value = "b">Bird</option>
	</select>
	
	<div id = "kind">
		<select>
			<option >치와와</option>
			<option>푸들</option>
			<option>말티즈</option>
		</select>
	</div>
</div>

<div>
	<input type = "text" id = "num">
	<button id = "btn">Number</button>
</div>
<div id = "result"></div>

<script type="text/javascript">	
	$("#btn").click(function() {

		
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
	
		var num = $("#num").val();
		
		
		//request 정보 
		/* xmlhttp.open("GET", "./testAjax?num="+num); */	/* root밑 폴더명으로 생각*/
		xmlhttp.open("POST", "./testAjax");
	
		//Get
		//xmlhttp.send();
		
		//Post
		//xmlHttp.send("파라미터");
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("num="+num);
		
		xmlhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status == 200){
				//document.getElementById("result").innerHTML=this.responseText 자바스크립트 
			//jqeury
			$("#result").html(this.responseText);
			
			this.responseText;
		}
		
	}
	});
	
	
	
	$("#select").change(function() {
		//alert($(this).val());  - > test
					
		var xmlhttp;
		
		//1. XMLHttpRequest 객체 생성
		if (window.XMLHttpRequest) {
		 	  
		 	  xmlhttp = new XMLHttpRequest();
		 } else {
		   		
		  	 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		//2. 요청 정보 작성 
		xmlhttp.open("GET","./selectAnimal?kind="+$("#select").val());
		
		//3. 요청 전송
		//Get
		xmlhttp.send();
		//Post
		//xmlhttp.send("파라미터이름= 파라미터값&파라미터 이름2 = 파라미터 값2")
		//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		//4. 결과 처리	 callback 함수 
		xmlhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status ==200){
				
				$("#kind").html(this.responseText);
				
				this.responseText;
			}
			
			
		}
		
	});
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	var xmlhttp;
	
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}else{
		 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.open("GET","./notice/noticeResult");
	
	xmlhttp.send();
	
	xmlhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status == 200){
			
			$("#noticeResult").html(this.responseText);
			this.responseText;
			
		}
	};
	
</script>
</div>
</body>
</html>