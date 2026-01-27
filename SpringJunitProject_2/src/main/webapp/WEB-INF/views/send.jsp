<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
		margin: 0px auto;
		width: 500px;
	}
	h3{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>메일 보내기</h3>
			<form action="/send_ok" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th class="text-center success" width="20%">보내는 사람</th>
							<td width="80%">
								<input type="text" name="sender" class="input-sm" size="20">
							</td>
						</tr>
						<tr>
							<th class="text-center success" width="20%">받는 사람</th>
							<td width="80%">
								<input type="text" name="reciver" class="input-sm" size="20">
							</td>
						</tr>
						<tr>
							<th class="text-center success" width="20%">제목</th>
							<td width="80%">
								<input type="text" name="subject" class="input-sm" size="20">
							</td>
						</tr>
						<tr>
							<th class="text-center success" width="20%">내용</th>
							<td width="80%">
								<textarea rows="10" cols="40" name="content"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">
								<button type="submit" class="btn-sm btn-primary">전송</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>