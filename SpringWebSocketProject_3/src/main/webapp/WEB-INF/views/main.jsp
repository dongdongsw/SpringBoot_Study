<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	margin:0px auto;
	width: 400px;
}
.h3{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>메인 페이지</h3>
			<table class="table">
				<tbody>
					<sec:authorize access="isAnonymous()">
						<tr>
							<td class="text-center">
								<a href="/login" class="btn btn-sm btn-success">로그인</a>
							</td>
						</tr>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
					<tr>
						<td class="text-center">
							<a href="/join" class="btn btn-sm btn-danger">회원가입</a>
						</td>
					</tr>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<tr>
							<td class="text-center">
								<strong>
									<sec:authentication property="name"/>
								</strong>
								님 환영합니다!!
							</td>
						</tr>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<tr>
							<td class="text-center">
								<a href="#" class="btn btn-sm btn-primary">일반 채팅</a>
							</td>
						</tr>
						<sec:authorize access="hasRole('USER')">
						<tr>
							<td class="text-center">
								<a href="#" class="btn btn-sm btn-info">1:1채팅</a>
							</td>
						</tr>
						</sec:authorize>
						<tr>
							<td class="text-center">
								<a href="/logout" class="btn btn-sm btn-warning">로그아웃</a>
							</td>
						</tr>
						<sec:authorize access="hasRole('ADMIN')">
							<tr>
								<td class="text-center">
									<a href="#" class="btn btn-sm btn-warning">채팅관리</a>
								</td>
							</tr>
						</sec:authorize>
					</sec:authorize>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>