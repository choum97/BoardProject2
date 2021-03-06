<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<a href="home">메인</a>
		<hr>
		<form method="post">
			<input type="text" name="m_userId" id="m_userId" placeholder="아이디" /><br>
			<input type="password" name="m_pw" id="m_pw" placeholder="비밀번호" />
			<input type="button" value="로그인"  id="submitBtn">
		</form>
		
	</div>
	<script>
		$(document).ready(function() {
			$('#submitBtn').click(function() {
				var param = {'m_userId':$("#m_userId").val(), 'm_pw': $("#m_pw").val()};
				$.ajax({
					url: "login",
					type: "POST",
					data: param,
					success: function(data) {
						if (data != 1) {
							alert('잘못된 아이디이거나, 비밀번호가 틀렸습니다.');
						}
						else {
							alert('환영합니다 ' + $('#m_userId').val() + '님');
							location.href = "home"
						}
					}
				});
			})
		})
	
	</script>
</body>
</html>
