<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dept.model.DeptDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 추가</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/required.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/form.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/required.js"></script>
</head>
<body>
	<section class="container">
		<%
			Map<String, String> error = request.getAttribute("error") != null ? (Map<String, String>)request.getAttribute("error") : null;
			DeptDTO data = request.getAttribute("data") != null ? (DeptDTO)request.getAttribute("data") : null;
		%>
		<form class="small-form" action="./add" method="post">
			<div class="input-form wide">
				<label class="input-label">부서ID</label>
				<% if(error == null) { %>
					<input type="text" class="input-text" name="deptId" value="<%=data == null ? "" : data.getDeptId() %>" data-required="부서 ID를 입력하세요.">
				<% } else { %>
					<input type="text" class="input-text" name="deptId" value="<%=data.getDeptId() == -1 ? "" : data.getDeptId() %>" data-required="부서 ID를 입력하세요.">
					<% if(error.get("deptId") != null) { %>
						<label class="input-label-error"><%=error.get("deptId") %></label>
					<% } %>
				<% } %>
			</div>
			<div class="input-form wide">
				<label class="input-label">부서명</label>
				<% if(error == null) { %>
					<input type="text" class="input-text" name="deptName" value="<%=data == null ? "" : data.getDeptName() %>" data-required="부서명을 입력하세요.">
				<% } else { %>
					<input type="text" class="input-text" name="deptName" value="<%=data.getDeptName() %>" data-required="부서명을 입력하세요.">
					<% if(error.get("deptName") != null) { %>
						<label class="input-label-error"><%=error.get("deptName") %></label>
					<% } %>
				<% } %>
			</div>
			<div class="input-form wide">
				<label class="input-label">관리자ID</label>
				<% if(error == null) { %>
					<input type="text" class="input-text" name="mngId" value="<%=data == null ? "" : data.getMngId() %>" data-required="관리자 ID를 입력하세요.">
				<% } else { %>
					<input type="text" class="input-text" name="mngId" value="<%=data.getMngId() == -1 ? "" : data.getMngId() %>" data-required="관리자 ID를 입력하세요.">
					<% if(error.get("mngId") != null) { %>
						<label class="input-label-error"><%=error.get("mngId") %></label>
					<% } %>
				<% } %>
			</div>
			<div class="input-form wide">
				<label class="input-label">지역ID</label>
				<% if(error == null) { %>
					<input type="text" class="input-text" name="locId" value="<%=data == null ? "" : data.getLocId() %>" data-required="지역 ID를 입력하세요.">
				<% } else { %>
					<input type="text" class="input-text" name="locId" value="<%=data.getLocId() == -1 ? "" : data.getLocId() %>" data-required="지역 ID를 입력하세요.">
					<% if(error.get("locId") != null) { %>
						<label class="input-label-error"><%=error.get("locId") %></label>
					<% } %>
				<% } %>
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
				<button class="btn btn-outline btn-cancel" type="button" onclick="location.href='<%=request.getContextPath() %>/depts'">취소</button>
			</div>
		</form>
	</section>
</body>
</html>