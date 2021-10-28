<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>

<body>
	<h1>
		게시글 조회
	</h1>
	<a href="home">메인</a> / 
	<a href="javascript:history.back();">뒤로가기</a> 
 	
 	<c:if test="${member != null}">
		/ <a href="logout">로그아웃</a> 
	</c:if> 
 	<c:if test="${b_userId eq member.getM_userId()}">
		/ <a href="PhotoBoardModifyView?b_no=${photoBoardDetail.b_no}">수정</a>
		/ <a href="PhotoBoardDelete?b_no=${photoBoardDetail.b_no}">삭제</a> 
	</c:if> 
	<hr>
	<div class="container">
		<div align="right">
			<p>
				<font size="1px">작성자  : ${photoBoardDetail.b_userId}</font>
				<font size="1px">조회수  : ${photoBoardDetail.b_hit }</font>
				<font size="1px">작성일  : ${photoBoardDetail.b_writing_date }</font>
			<p>
		</div>
		<div align="center">
		<c:if test="${photoBoardDetail.b_file_name ne null}">
			<img src='<c:url value="/resources/images/photoBoard/${photoBoardDetail.b_file_name}"/>' alt="" class="img-fluid">
		</c:if>
		</div>
		
		<div align="center">
			<h3>${photoBoardDetail.b_title}</h3>
			<br>
			<p><c:out escapeXml="false" value="${fn:replace(photoBoardDetail.b_content, crlf, '<br>')}"/></p>
		</div>
	</div>
</body>
</html>