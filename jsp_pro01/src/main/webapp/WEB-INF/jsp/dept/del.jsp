<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>삭제 확인</title>
</head>
<body>
	<%
		DeptDTO data = (DeptDTO) request.getAttribute("data");
	%>
	<ul>
		<li>부서코드 : <%=data.getDeptId() %></li>
		<li>부서명 : <%=data.getDeptName() %></li>
	</ul>
	<p>삭제할 데이터가 맞습니까?</p>
	<div>
		<button type="button">삭제</button>
		<button type="button" onclick="history.back();">취소</button>
	</div>
</body>
</html>