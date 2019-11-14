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
    <li class="list-group-item">Title : ${noticeVO.title} </li>
    <li class="list-group-item">Writer : ${noticeVO.writer} </li>
    <li class="list-group-item">DATE : ${noticeVO.reg_date}</li>
    <li class="list-group-item">HIT : ${noticeVO.hit} </li>
  </ul>
   <p>CONTENTS: ${noticeDTO.contents} </p>
	<div id="box">
		<a class = "btn btn-primary" href="./noticeUpdate?num=${noticeVO.num}">Update</a>
 		<a class = "btn btn-danger" href="./noticeDelete?num=${noticeVO.num}">Delete</a>
		
	
	<%-- <%if(memberDTO !=null && memberDTO.getId().equals(noticeDTO.getWriter())) {%>
 	<% }%> --%>
 	
	</div>
</div>


</body>
</html>