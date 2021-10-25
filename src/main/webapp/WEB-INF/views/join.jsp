<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>회원가입 페이지</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<form action="SignUpMember" name="joinForm" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="m_userId" placeholder="아이디" />
					<input type="button" onclick="IDCheck()" value="중복확인"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="m_name" placeholder="이름" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="m_pw" id="m_pw" placeholder="비밀번호" />
				</td>
			</tr>
			<tr>
				<td><input type="password" name="userPwChk" id="userPwChk" placeholder="비밀번호 입력" onkeyup="passConfirm()"> <font id="chkNotice" size="1"></font></td>
			</tr>
			<tr>
				<td><input type="email" name="m_email" placeholder="이메일" /></td>
			</tr>
		</table>
		<input type="submit" value="회원가입"><a href="home">메인</a> 
	</form><br>
	
	
	<script>
	$(function(){
	    $('#m_pw').keyup(function(){
	      $('#chkNotice').html('');
	    });

	    $('#userPwChk').keyup(function(){

	        if($('#m_pw').val() != $('#userPwChk').val()){
	          $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
	          $('#chkNotice').attr('color', '#f82a2aa3');
	        } else{
	          $('#chkNotice').html('비밀번호 일치함<br><br>');
	          $('#chkNotice').attr('color', '#199894b3');
	        }

	    });
	});
	</script>
</body>
</html>
