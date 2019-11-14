<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>

<div class="container">
  <h2>Notice Select Page</h2>
  <ul class="list-group">
    <li class="list-group-item">Title : ${dto.title} </li>
    <li class="list-group-item">Writer : ${dto.writer} </li>
    <li class="list-group-item">DATE : ${dto.reg_date}</li>
    <li class="list-group-item">HIT : ${dto.hit} </li>
  </ul>
   <p>CONTENTS: ${dto.contents} </p>
	<div id="box">
		<a class = "btn btn-danger" href="${board}List?num=${dto.num}">List</a>
		<a class = "btn btn-primary" href="${board}Update?num=${dto.num}">Update</a>
 		<a class = "btn btn-danger" href="${board}Delete?num=${dto.num}">Delete</a>
 		<a class = "btn btn-primary" href="${board}Reply?num=${dto.num}">Reply</a>
		
	
	<%-- <%if(memberDTO !=null && memberDTO.getId().equals(noticeDTO.getWriter())) {%>
 	<% }%> --%>
 	
	</div>
</div>


</body>
</html>