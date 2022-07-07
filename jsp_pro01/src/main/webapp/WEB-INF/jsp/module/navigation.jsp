<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = "";
	if(request.getAttribute("url") != null) {
		url = (String)request.getAttribute("url");
	}
%>
<header>
	<nav class="top-nav center">
		<ul class="nav">
			<li class="nav-item dropdown<%=url.contains("/jsp_") ? " active" : "" %>">
				<a class="nav-link" href="#">JSP/Servlet</a>
				<ul class="nav dropdown-nav">
					<li class="nav-item">
						<a class="nav-link" href="./jsp_script">스크립트 태그</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./jsp_request">request 객체</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./jsp_response">response 객체</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./jsp_model2">Model2</a>
					</li>
				</ul>
			</li>
			<li class="nav-item<%=url.contains("/emps") ? " active" : "" %>">
				<a class="nav-link" href="./emps">직원</a>
			</li>
			<li class="nav-item<%=url.contains("/depts") ? " active" : "" %>">
				<a class="nav-link" href="./depts">부서</a>
			</li>
			<li class="nav-item<%=url.contains("/locs") ? " active" : "" %>">
				<a class="nav-link" href="./locs">지역</a>
			</li>
		</ul>
	</nav>
</header>