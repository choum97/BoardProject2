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
	<div class="container">
		<h1>
			게시글 수정
		</h1>
		<a href="home">메인</a> / 
		<a href="javascript:history.back();">뒤로가기</a> 
	 	
	 	<c:if test="${member != null}">
			/ <a href="logout">로그아웃</a> 
		</c:if> 
	 	<c:if test="${photoBoardDetail.b_userId ne member.getM_userId()}">
	 		<c:redirect url="home"/>
		</c:if>
		<c:if test="${member == null}">
			<c:redirect url="loginView"/>
		</c:if>  
	</div>
	<hr>
	
	<div class="container">
		<form action="PhotoBoardModify" method="POST" enctype="multipart/form-data">
			<div>
				<input type="hidden" id="b_no" name="b_no" value="${photoBoardDetail.b_no}" />
				<div align="right">
					<p>
						<font size="1px">작성자  : ${photoBoardDetail.b_userId}</font> 
						<font size="1px">조회수  : ${photoBoardDetail.b_hit }</font> 
						<font size="1px">작성일  : ${photoBoardDetail.b_writing_date }</font>
					<p>
				</div>
				
				<div class="inputArea"> 
					<div class="select_img" align="center"> 
						<img src='<c:url value="/resources/images/photoBoard/${photoBoardDetail.b_file_name}"/>' alt="" class="img-fluid" >
						<input type="hidden" name="imgFile" value="${photoBoardDetail.b_file_name}" />
						
						<input type="file" id="imgFile" name="file" /><br>
					</div>
				</div>
				
				제목
				<div >
					<input type="text" id="b_title" name="b_title" value="${photoBoardDetail.b_title }" required>
				</div><br>
				
				내용
				<div>
					<textarea id="b_content" name="b_content"  class="form-control h-25" rows="10" required>${fn:replace(photoBoardDetail.b_content , '<br>', crlf)}</textarea>
				</div>
				<br>
				<div align="right">
            		<input class="btn btn-primary" type="submit" value="변경">
            		<input class="btn btn-primary" type="button" value="취소" onclick="javascript:history.back();"><hr>
				</div>
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