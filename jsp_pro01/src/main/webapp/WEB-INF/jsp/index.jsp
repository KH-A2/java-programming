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
	<%@ include file="./module/head.jsp" %>
</head>
<body>
	<%@ include file="./module/navigation.jsp" %>
	<section class="container">
		<c:url var="loginUrl" value="/login" />
		<form class="small-form" action="${loginUrl}" method="post">
			<div class="input-form wide">
				<label class="input-label">직원ID</label>
				<input type="text" class="input-text" name="empId" value="" data-required="직원ID를 입력하세요.">
				<c:if test="${not empty error.deptId}">
					<label class="input-label-error">${error.deptId}</label>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">부서명</label>
				<select class="select-form" name="deptId" data-required="부서명을 선택하세요.">
					<c:forEach items="${deptList}" var="deptDto">
						<option value="${deptDto.deptId}">[${deptDto.deptId}] ${deptDto.deptName}</option>
					</c:forEach>
				</select>
				<c:if test="${not empty error.deptName}">
					<label class="input-label-error">${error.deptName}</label>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">이름</label>
				<input type="text" class="input-text" name="empName" value="" data-required="이름을 입력하세요.">
				<c:if test="${not empty error.deptName}">
					<label class="input-label-error">${error.deptName}</label>
				</c:if>
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">로그인</button>
			</div>
		</form>
	</section>
</body>
</html>












