<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<h1>
		게시글 수정
	</h1>
	<a href="home">메인</a> / 
	<a href="javascript:history.back();">뒤로가기</a> 
 	
 	<c:if test="${member != null}">
		/ <a href="logout">로그아웃</a> 
	</c:if> 
<%--  	<c:if test="${photoBoardDetail.b_userId ne member.getM_userId()}">
 		<c:redirect url="home"/>
	</c:if>  --%>
	
	<hr>
    <div class="container">
		<form action="PhotoBoardWrite" role="form" method="POST" enctype="multipart/form-data">
			<div class="inputArea">
				<label for="imgLabel">이미지</label><br>
				<input type="file" id="imgFile" name="file" />
				<div class="select_img"><img src=""/></div>
			</div>
		
			<div>
				<label for="title" class="form-label"><strong>제목 :</strong></label>
				<input type="text" id="b_title" name="b_title">
			</div>
			<div>
				<label for="userId" class="form-label"><strong>작성자 :</strong></label>
				<input type="text" id="b_userId" name="b_userId" value="${sessionScope.member.getM_userId()}" required readonly>
			</div>
			
			<div>
				<label for="content" class="form-label"><strong>내용</strong></label>
				<textarea class="form-control h-25" rows="10" id="b_content" name="b_content"></textarea>
			</div>
			<div align="right">
				<input class="btn btn-primary" type="submit" value="등록">
	        	<input class="btn btn-primary" type="button" value="취소" onclick="javascript:history.back();">
			</div>
		</form>
	</div>
			
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
	<script>
		$("#imgFile").change(function(){
			if(this.files && this.files[0]) {
				var reader = new FileReader;
				reader.onload = function(data) {
					$(".select_img img").attr("src", data.target.result).width(1000);								
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
		
	</script>
	
</body>
</html>