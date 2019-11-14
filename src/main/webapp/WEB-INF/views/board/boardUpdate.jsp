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
  <h2>Update Insert Page</h2>
  <form action="${board}Update" method="post">
    <div class="form-group">
      <input type="hidden" name="num" value = "${dto.num}">
    </div>
    <div class="form-group">
    
      <label for="title">TITLE:</label>
      <input type="text" class="form-control" id="title"  name="title"
      value = "${dto.title}">
    </div>
    
      <label for="contents">CONTENTS:</label>
    <div class="form-group">
    
      <textarea rows="10" cols="160" name="contents">${dto.contents}</textarea>
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>


</body>
</html>