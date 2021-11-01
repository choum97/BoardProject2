<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>
			Hello world!  
		</h1>
	
		<c:if test="${member == null}">
			<a href="loginView">로그인</a> 
			/ <a href="SignUpMemberView">회원가입</a>
			/ <a href="PhotoBoardListView">게시판</a>
		</c:if>
		<c:if test="${member != null}">
			 <a href="PhotoBoardListView">게시판</a>
			/ <a href="logout">로그아웃</a>
		</c:if>
	</div>
	<hr>
	
	<%--
 	<c:if test="${member == null}">
	
		<c:redirect url="loginView"/>
	</c:if> 
	--%>
</body>
</html>
