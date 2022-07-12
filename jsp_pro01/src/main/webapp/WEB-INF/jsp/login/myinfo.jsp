<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내 정보</title>
	<%@ include file="../module/head.jsp" %>
</head>
<body>
	<%@ include file="../module/navigation.jsp" %>
	<section class="container">
		<form class="large-form" action="">
			<div class="img-form left">
				<c:url var="imgUrl" value="/static/img/emp/${sessionScope.loginData.empId}.png" />
				<img class="img-360" alt="여기에는 증명 사진이 배치됩니다." src="${imgUrl}">
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-80">ID</label>
					<input class="input-text w-auto" type="text" name="empId" value="${sessionScope.loginData.empId}" readonly>
				</div>
				<div class="input-form">
					<label class="input-label w-80">이름</label>
					<input class="input-text w-auto" type="text" name="empName" value="${sessionScope.loginData.empName}">
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-80">직급</label>
					<select class="select-form w-auto" name="jobId">
						<option></option>
					</select>
				</div>
				<div class="input-form">
					<label class="input-label w-80">부서</label>
					<select class="select-form w-auto" name="deptId">
						<option></option>
					</select>
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-80">이메일</label>
					<input class="input-text w-auto" type="text" name="email" value="${sessionScope.loginData.email}">
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-80">입사일</label>
					<input class="input-text w-auto" type="text" name="hireDate" value="">
				</div>
				<div class="input-form">
					<label class="input-label w-80">전화번호</label>
					<input class="input-text w-auto" type="text" name="phone" value="">
				</div>
			</div>
			<div class="input-form inline">
				<div class="input-form">
					<label class="input-label w-80">급여액</label>
					<input class="input-text w-auto" type="text" name="salery" value="">
				</div>
				<div class="input-form">
					<label class="input-label w-80">커미션</label>
					<input class="input-text w-auto" type="text" name="commission" value="">
				</div>
			</div>
			<div class="input-form form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
			</div>
		</form>
	</section>
</body>
</html>