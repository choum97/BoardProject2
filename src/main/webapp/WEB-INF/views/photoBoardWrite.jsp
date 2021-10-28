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
	
	${member.getM_userId()}
	<hr>
	
	
			
	
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