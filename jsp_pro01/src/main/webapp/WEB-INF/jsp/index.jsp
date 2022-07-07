<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome JSP/Servlet</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/navigation.css">
</head>
<body>
	<%@ include file="./module/navigation.jsp" %>
	<h1>Welcome JSP/Servlet</h1>
	<c:choose>
		<c:when test="${param.x == 'a'}">
			파라미터 x의 값이 a 면 실행
		</c:when>
		<c:when test="${param.x == 'b'}">
			파라미터 x의 값이 b 면 실행
		</c:when>
		<c:when test="${param.x == 'c'}">
			파라미터 x의 값이 c 면 실행
		</c:when>
		<c:otherwise>
			모든 when 조건에 해당하지 않으면 실행됨
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<%
		List<String> lst = new ArrayList<String>();
		lst.add("a"); lst.add("b"); lst.add("c"); lst.add("d");
		request.setAttribute("lst", lst);
	%>
	<ul>
		<c:forEach begin="1" end="5" var="v">
			<li>${v}</li>
		</c:forEach>
	</ul>
	<br>
	<ul>
		<c:forEach items="${lst}" var="v">
			<li>${v}</li>
		</c:forEach>
	</ul>
</body>
</html>












