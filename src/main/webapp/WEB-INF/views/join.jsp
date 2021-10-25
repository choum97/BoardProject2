<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입 페이지</title>
</head>
<body>
	<form action="/join" name=joinForm method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="m_userId" placeholder="아이디" />
					<input type="button" onclick="idOverlap()" value="중복확인"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="m_name" placeholder="이름" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="m_pw" placeholder="비밀번호" />
				</td>
			</tr>
			<tr>
			<!-- onkeyup="JP function" 입력이 되었을 때, -->
				<td>
					<input type="password" name="passwordConfrim" id="passwordConfirm" placeholder="비밀번호 입력" onkeyup="passConfirm()"> <span id ="confirmMsg"></span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="email" name="m_email" placeholder="이메일" />
				</td>
			</tr>
		</table>
		<a href="home">메인</a>
	</form>

	<script type="text/javascript">
		function idOverlap(){
			console.log("idOverlap 호출")
			console.log("아이디 입력 값 : "+joinForm.m_userId.value)
			$.ajax({
				type :"post",/* 전송 방식 */
				url :"idOverlap", /* 컨트롤러 사용할 때. 내가 보낼 데이터의 주소. */
				data : {"m_userId" : joinForm.m_userId.value},
				/* JSON형식 안에 JSON 형식으로 표현한 데이터. 
		        "파라미터 이름" : 폼태그에 적은 NAME 값.ID입력창의 NAME값.value 여러 개도 가능
				data :{	"id" : joinForm.id.value, 
				"id1" : joinForm.password.value}, 이렇게도 사용 가능.					
				*/
				dataType : "text",	/* text, xml, html, script, json, jsonp 가능 */
		        //정상적인 통신을 했다면 function은 백엔드 단에서 데이터를 처리.
				success : function(data){	
					if(data=="1"){
						alert("이 아이디는 사용 가능합니다.");
					}else{	//ajax가 제대로 안됐을 때 .
						alert("이 아이디는 사용  불가능합니다.");
					}
				},
				error : function(){
					alert("아이디 중복 확인 ajax 실행 실패");
				}
			});
			
		}
	
	
		/* 자바 스크립트 함수 선언(비밀번호 확인) */
	
		function passConfirm() {
		/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
		/* document : 현재 문서를 의미함. 작성되고 있는 문서를 뜻함. */
		/* getElementByID('아이디') : 아이디에 적힌 값을 가진 id의 value를 get을 해서 password 변수 넣기 */
			var password = document.getElementById('m_pw');					//비밀번호 
			var passwordConfirm = document.getElementById('passwordConfirm');	//비밀번호 확인 값
			var confrimMsg = document.getElementById('confirmMsg');				//확인 메세지
			var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
			var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
			
			if(m_pw.value == passwordConfirm.value){//password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
				confirmMsg.style.color = correctColor;/* span 태그의 ID(confirmMsg) 사용  */
				confirmMsg.innerHTML ="비밀번호 일치";/* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
			}else{
				confirmMsg.style.color = wrongColor;
				confirmMsg.innerHTML ="비밀번호 불일치";
			}
		}
	</script>	
</body>
</html>
