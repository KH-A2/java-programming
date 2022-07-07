<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, locs.model.LocsDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/navigation.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/required.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/form.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/table.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/required.js"></script>
</head>
<body>
	<%@ include file="../module/navigation.jsp" %>
	<h1>지역 조회 결과</h1>
	<section class="container">
		<div>
			<form action="./locs" method="get">
				<div class="input-form form-left">
					<button class="btn btn-outline" type="button" onclick="location.href='./locs/add'">추가</button>
				</div>
				<div class="input-form form-right">
					<input class="input-text" type="text" name="search" data-required="지역코드를 입력하세요.">
					<button class="btn btn-outline" type="submit">조회</button>
				</div>
			</form>
		</div>
		<table class="table wide vertical-hidden hover">
			<colgroup>
				<col class="col-120">
				<col class="col-auto">
				<col class="col-120">
				<col class="col-120">
				<col class="col-120">
				<col class="col-120">
				<col class="col-120">
			</colgroup>
			<thead>
				<tr>
					<th>지역코드</th>
					<th>주소</th>
					<th>우편번호</th>
					<th>도시명</th>
					<th>주</th>
					<th>국가코드</th>
					<th class="border-hidden-right"></th>
				</tr>
			</thead>
			<tbody>
				<%
					if(request.getAttribute("locsDatas") != null) {
						List<LocsDTO> datas = (List<LocsDTO>) request.getAttribute("locsDatas");
						for(LocsDTO data: datas) {
				%>
							<tr>
								<td><%=data.getLocId() %></td>
								<td><%=data.getStAddr() %></td>
								<td><%=data.getPostal() %></td>
								<td><%=data.getCity() %></td>
								<td><%=data.getState() %></td>
								<td><%=data.getCtyId() %></td>
								<td class="border-hidden-right">
									<button type="button" class="btn btn-icon" onclick="location.href='./locs/mod?id=<%=data.getLocId() %>'">
										<span class="material-symbols-outlined">edit</span>
									</button>
									<button type="button" class="btn btn-icon" onclick="location.href='./locs/del?id=<%=data.getLocId() %>'">
										<span class="material-symbols-outlined">delete</span>
									</button>
								</td>
							</tr>
				<%
						}
					}
				%>
			</tbody>
		</table>
	</section>
</body>
</html>