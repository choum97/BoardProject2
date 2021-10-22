<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입 페이지</title>
</head>
<body>
	<form action="/join" method="post">
		<input type="text" name="m_userId" placeholder="아이디" />
		<input type="password" name="password" placeholder="비밀번호" />
		<input type="password" name="confirmPassword" placeholder="비밀번호 확인" />
		<input type="email" name="email" placeholder="이메일" />
		<button>회원가입</button>
	</form>
</html>
