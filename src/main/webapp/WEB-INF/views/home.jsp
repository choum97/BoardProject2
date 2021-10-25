<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

	<c:if test="${member == null}">
		<a href="loginView">로그인</a> <br>
		<a href="SignUpMemberView">회원가입</a><br>
		<a href="#">게시판</a>
	</c:if>
	<c:if test="${member != null}">
		<a href="#">게시판</a>
		<a href="logout">로그아웃</a>
	</c:if>
	
	<%--
 	<c:if test="${member == null}">
	
		<c:redirect url="loginView"/>
	</c:if> 
	--%>
</body>
</html>
