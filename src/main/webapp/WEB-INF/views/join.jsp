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
	
	$(document).ready(function() {
		$('#IDCheck').click(function() {
			var param = {'m_userId':$("#m_userId").val()};
			if ($("#m_userId").val() == "") {
				swal({
					title: "중복확인",
					text: "아이디를 입력해주세요.",
					icon: "info",
					timer: 3000
				});
			}
			else {
				$.ajax({
					url: "IDCheck",
					type: "POST",
					data: param,
					success: function(data) {
						if (data != 1) {
							console.log(data);
							swal({
								title: "중복확인",
								text: "이미 사용중인 아이디입니다.",
								icon: "error",
								timer: 3000
							});
						}
						else {
							console.log(data);
							swal({
								title: "중복확인",
								text: "사용할 수 있는 아이디입니다.",
								icon: "success",
							});
							$('#IDCheck').attr('disabled', true);
							$('#m_userId').prop('readonly', true);
						}
					},
					error: function() {
						swal({
							title: "오류",
							text: "오류가 발생하였습니다.\n잠시 후 다시 시도해주세요.",
							icon: "error",
							timer: 3000
						});
					}
				});
			}
		})
	})
	
	function signUpMemberSubmit() {
		var m_userId = $("#m_userId").val();
		var m_pw = $("#m_pw").val();
		var userPwChk = $("#userPwChk").val();
		var m_name = $("#m_name").val();
		var m_email = $("#m_email").val();
		if(!m_userId) {
			swal({
				title: "회원가입",
				text: "아이디가 입력되지 않았습니다.",
				icon: "warning",
				timer: 3000
			});
			return false;
		}
		if(!$('#m_userId').prop("readonly")) {
			swal({
				title: "회원가입",
				text: "아이디 중복 확인이 되지 않았습니다.",
				icon: "warning",
				timer: 3000
			});
			return false;
		}
		else if(!m_pw) {
			swal({
				title: "회원가입",
				text: "비밀번호가 입력되지 않았습니다.",
				icon: "warning",
				timer: 3000
			});
			return false;
		}
		else if(m_pw != userPwChk) {
			swal({
				title: "회원가입",
				text: "비밀번호가 일치하지 않습니다.",
				icon: "warning",
				timer: 3000
			});
			return false;
		}
		else if(!m_name) {
			swal({
				title: "회원가입",
				text: "이름이 입력되지 않았습니다.",
				icon: "warning",
				timer: 3000
			});
			return false;
		}
		else if(!m_email) {
			swal({
				title: "회원가입",
				text: "이메일이 입력되지 않았습니다.",
				icon: "warning",
				timer: 3000
			});
			return false;
		}
		$("#form").submit();
	}

	</script>
</body>
</html>
