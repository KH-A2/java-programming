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
	<fmt:formatNumber value="1000" /><br>
	<fmt:formatNumber value="0.1" type="percent" /><br>
	<fmt:formatNumber value="1000" type="currency" /><br>
	<fmt:formatNumber value="1000" type="currency" currencySymbol="$" /><br>
	
	<hr>
	<%
		Date date = new Date();
		request.setAttribute("date", date);
	%>
	<fmt:formatDate value="${date}" type="date" /><br>
	<fmt:formatDate value="${date}" type="date" dateStyle="full" /><br>
	<fmt:formatDate value="${date}" type="date" dateStyle="long" /><br>
	<fmt:formatDate value="${date}" type="date" dateStyle="medium" /><br>
	<fmt:formatDate value="${date}" type="date" dateStyle="short" /><br>
	<fmt:formatDate value="${date}" type="date" pattern="YYYY-MM-dd E EEEE" /><br>
	
	<hr>
	
	<fmt:formatDate value="${date}" type="time" /><br>
	<fmt:formatDate value="${date}" type="time" timeStyle="full" /><br>
	<fmt:formatDate value="${date}" type="time" timeStyle="long" /><br>
	<fmt:formatDate value="${date}" type="time" timeStyle="medium" /><br>
	<fmt:formatDate value="${date}" type="time" timeStyle="short" /><br>
	<fmt:formatDate value="${date}" type="time" pattern="a hh:mm:ss.SSS" /><br>
	<fmt:formatDate value="${date}" type="time" pattern="HH:mm:ss Z z zzzz" /><br>
	
	<hr>
	
	<fmt:formatDate value="${date}" type="both" /><br>
	<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="short" /><br>
</body>
</html>












