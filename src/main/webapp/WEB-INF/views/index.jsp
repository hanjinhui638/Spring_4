<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<c:import url="./layout/bootStrap.jsp" />
<c:import url="./layout/summerNote.jsp"></c:import>
</head>
<body>
	<c:import url="./layout/nav.jsp" />
	<h1>Hello world!</h1>
	<P id="p">The time on the server is ${serverTime}.</P>

	<!-- <div id = "editor"></div>
		<script type="text/javascript">
 		$("#editor").summernote();
		</script> -->

	<button id="btn3">Click Movies</button>
	<div id="img"></div>
	<button id="btn2">click</button>
	<button id="btn">Get Json</button>
	
	
<script type="text/javascript">

	$("#btn").click(function() {
		$.get("./getJson3", function(data) {
			
			$.each(data, function(i, vo) {
				//data를 vo에 i는 index번호
				console.log(i);
				console.log(vo.num);
			});
			
			/* for(var i=0; i<data.length;i++){
				console.log(data[i].num)	
			} */
			
			//alert(data[0].num);
			//data = data.trim();
			//data = JSON.parse(data); 	//var data를 JSON type로 
			//alert(typeof data);
			
			//alert(data.title);
			//alert(data.writer);
			//alert(data.contents);
		});
	});
	
	$("#btn2").click(function() {
		$.ajax({
			type:"GET", 
			url: "https://api.manana.kr/exchange/price.json",
			data: {
				base:"USD",
				price:1,
				code:"KRW"
			},
			success: function(data) {
				console.log(data.KRW);
			}
		});			
	});
	
	$("#btn3").click(function() {
		$.ajax({
			type:"GET",
			url: "https://yts.lt/api/v2/list_movies.json",
			data:{
				limit:2
			},
			success: function(data) {
				var a = '<img src ="'+data.data.movies[0].medium_cover_image+'">'
				$("#img").append(a);
				
				console.log(data.data.movies[0].medium_cover_image);
			},
			error:function(data){
				console.log(data);
				
			}
		})
		
	});
	
</script>

</body>
</html>