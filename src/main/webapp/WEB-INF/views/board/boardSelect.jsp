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
<style type="text/css">
	.contents {
		background-color: lightgray;
		width: 100%;
		height: 200px;
		padding: 20px;
		font-size: 15px;
		margin-bottom: 20px;
	}
</style>
<body>
<c:import url="../layout/nav.jsp" />
	<%-- <h1>${data}</h1> --%>
	
	<div class="container">
		<h2>${board} Select Page</h2>
		<br>
	  <table class="table">
	    <thead>
	      <tr class="info"><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th></tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>${boardVO.title}</td>
	        <td>${boardVO.writer}</td>
	        <td>${boardVO.reg_date}</td>
	        <td>${boardVO.hit}</td>
	      </tr>
	    </tbody>
	  </table>
	  <div class="contents">
		${boardVO.contents}
	  </div>
	<div>
		<c:forEach items = "${boardVO.files}" var="file">
			<a href="./fileDown?fnum=${file.fnum}">${file.oname}</a>
		</c:forEach>		
	</div>
	  
	  <div>
	  <c:if test="${member.id eq select.writer}">
	  	<a href="${board}Update?num=${boardVO.num}" class="btn btn-info">Update</a>
	 	<a href="${board}Delete?num=${boardVO.num}" class="btn btn-danger">Delete</a>
	 	</c:if>
	 	
		<c:catch>
			<c:if test="${board eq 'qna'}">
		 		<a href="${board}Reply?num=${boardVO.num}" class="btn btn-warning">Reply</a>
		 	</c:if>
	 	</c:catch>
		<a href="${board}List" class="btn btn-primary">List</a>
		</div>
	</div>
	
	
</body>
</html>