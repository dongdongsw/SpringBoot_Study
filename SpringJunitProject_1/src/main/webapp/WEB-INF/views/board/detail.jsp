<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
   margin-top: 50px;
}

.row {
   margin: 0px auto;
   width: 800px;
}
</style>
</head>
<body>
   <div class="container">
      <div class="row">
         <h3 class="text-center">게시글 상세보기</h3>
	         <table class="table">
	            <tbody>
	               <tr>
	                  <th width="20%" class="text-center danger">번호</th>
	                  <td width="30%" class="text-center">${vo.no }</td>
	                  <th width="20%" class="text-center danger">작성일</th>
	                  <td width="30%" class="text-center">${vo.dbday }</td>
	               </tr>
	               <tr>
	                  <th width="20%" class="text-center danger">이름</th>
	                  <td width="30%" class="text-center">${vo.name }</td>
	                  <th width="20%" class="text-center danger">조회수</th>
	                  <td width="30%" class="text-center">${vo.hit }</td>
	               </tr>
	               <tr>
	               	  <th width="20%" class="text-center danger">제목</th>
	                  <td colspan="3">${vo.subject }</td>
	               </tr>
	               <tr>
	               	  <th width="20%" class="text-center danger">내용</th>
	                  <td >${vo.content }</td>
	               </tr>
	               <tr>
	                  <td colspan="3" class="text-center">
	                     <button type="button" class="btn btn-sm btn-danger">수정</button>
	                     <button type="button" class="btn btn-sm btn-danger">삭제</button>
	                     <button type="button" class="btn btn-sm btn-danger" onclick="javascripy:history.back()">목록</button>
	                  </td>
	               </tr>
	            </tbody>
	         </table>
      </div>
   </div>
</body>
</html>