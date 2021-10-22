<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="login" method="post">
		<input type="text" name="m_userId" placeholder="아이디" />
		<input type="password" name="m_pw" placeholder="비밀번호" />
		<button>로그인</button>
	</body>
</html>
