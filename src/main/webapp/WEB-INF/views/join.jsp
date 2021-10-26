<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>회원가입 페이지</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
	<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
</head>
<body>
	<form action="SignUpMember" id="form" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="m_userId" id="m_userId" placeholder="아이디" />
					<input type="button" id="IDCheck" value="중복확인"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="m_name" id="m_name" placeholder="이름" />
				</td>
				
			</tr>
			<tr>
				<td>
					<input type="password" name="m_pw" id="m_pw" placeholder="비밀번호" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="userPwChk" id="userPwChk" placeholder="비밀번호 입력" onkeyup="passConfirm()"> <font id="chkNotice" size="1"></font>
				</td>
			</tr>
			<tr>
				<td>
					<input type="email" name="m_email" id="m_email" placeholder="이메일" />
				</td>
			</tr>
		</table>
		<input type="button" onclick="signUpMemberSubmit()" value="회원가입"><a href="home">메인</a> 
	</form><br>
	
	
	<script>

	</script>
</body>
</html>
