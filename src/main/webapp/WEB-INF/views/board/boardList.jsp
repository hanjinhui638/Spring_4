<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<c:import url="../layout/bootStrap.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
	<!-- <img alt="" src="../resources/images/au53.jpg"> 프론트 ->resources -->
	
	
	
	<div class="container">
		<h2>Board LIST</h2>
		<div>
			<form id = "frm" action="./noticeList">
				<input type="hidden" id="curPage" value = "1" name ="curPage">
				<select name = "kind">
				
					<option id = "kt" value = "kt">Title</option>
					<option id = "kc" value = "kc">Contents</option>
							
				</select>
					<input type="text" name ="search" value = "${rowMaker.search}">
					<button>검색</button>			
			</form>
		</div>
		
		
		<table class="table">
			<thead>
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRIGHT</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var = "dto" varStatus="st"> 
					
				<tr>
					<td>${dto.num}</td>
					<td><a href = "./noticeSelect?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.reg_date}</td>
					<td>${dto.hit}</td>
				<%-- 	<td>${dto.hit}: ${st.last}</td> --%>
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
			<div>
					<ul class="pagination">
					<c:if test="${pager.curBlock gt 1}">
						<%-- <li><a href="./noticeList?curPage=${pager.startNum-1}">이전</a></li> --%>
						<li><span id="${pager.startNum-1}" class="list">이전</span></li>
						</c:if>
					<c:forEach begin ="${pager.startNum}" end="${pager.lastNum}" var="i">
						  <li><span id ="${i}" class ="list">${i}</span></li>
					</c:forEach>
					<c:if test = "${pager.curBlock lt pager.totalBlock}">
						<li><span id= "${pager.lastNum+1}" class = "list">다음</span></li>
						</c:if>
					</ul>
			
			</div>
		
		
			<%-- <div>
				<c:forEach begin="1" end = "10" var = "i" varStatus="st">	<!-- 역으로는 안됨 10 9 8 ...  10포함-->
						${pageScope.i} : ${st.begin} 
				</c:forEach>		
			</div> --%>
			<%-- <c:if test="${empty sessionScope.member}"> --%>
				<a href = "./noticeWrite" >Write</a>
		<%-- 	</c:if> --%>
		
	</div>
	<script type="text/javascript">
		var kind = '${rowMaker.kind}';
		if(kind ==''){
			kind = "kt";
			
		}
		$("#"+kind).prop("selected",true);
		$(".list").click(function(){
			$('#curPage').val($(this).attr("id"));
			$("#frm").submit();
			
			
		});
		
	
	</script>
	
</body>
</html>