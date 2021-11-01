<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />

</head>

<body>
	<div class="container">
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
	</div>
	<hr>
	
	<div class="container">
		<div align="right">
			<p>
				<input type="text" id="b_no" value="${photoBoardDetail.b_no}">
				<input type="text" id="m_userId" value="${member.getM_userId()}">
				
				<font size="1px">작성자  : ${photoBoardDetail.b_userId}</font>&nbsp;
				<font size="1px">조회수  : ${photoBoardDetail.b_hit+1 }</font> &nbsp;
				<font size="1px">작성일  : ${photoBoardDetail.b_writing_date }</font>&nbsp;
				<div id="divReloadLayer">
					<c:choose>
						<c:when test="${member ne null && boardLikeCheck eq 1}"> 
							<button id="" onclick=""> &#x1f497; ${photoBoardDetail.b_like}</button>
						</c:when>
						<c:when test="${member ne null && boardLikeCheck eq 0}">  
							<a href="BoardLikeUp?b_no=${photoBoardDetail.b_no}&m_userId=${member.getM_userId()}">
							<button>&#x2661; <div id="result">${photoBoardDetail.b_like}</div></button></a>
						</c:when>
						<c:otherwise> 
							<button id="buttonNoLogin" onclick="buttonNoLogin_click();" >&#x2661; ${photoBoardDetail.b_like}</button>
						 </c:otherwise>
					</c:choose>
				</div>
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
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
		function buttonNoLogin_click() {
			swal({
				title: "로그인",
				text: "로그인이 되어야 하트를 누를 수 있습니다.",
				icon: "warning",
			});
		}
		
		function buttonUp() {
			
			//count('plus')
			//var b_no = $("#b_no").val();
			//var m_userId = $("#m_userId").val();
			//location.href = "BoardLikeUp";
		}
		/*
		function buttonDown() {
			
			
			location.href = "BoardLikeDown";
			count('minus')
			var b_no = $("#b_no").val();
			var m_userId = $("#m_userId").val();
		}
		
 		function count(type)  {
			  // 결과를 표시할 element
			  const resultElement = document.getElementById('result');
			  
			  // 현재 화면에 표시된 값
			  let number = resultElement.innerText;
			  
			  // 더하기/빼기
			  if(type === 'plus') {
				
			    number = parseInt(number) + 1;
			    reloadDivArea();
			  }else if(type === 'minus')  {
			    number = parseInt(number) - 1;
			  }
			  
			  // 결과 출력
			  resultElement.innerText = number;
		}
		
		
		 
		function reloadDivArea() {
		    $('#divReloadLayer').load(location.href+' #divReloadLayer');
		}*/

	</script>
</body>
</html>