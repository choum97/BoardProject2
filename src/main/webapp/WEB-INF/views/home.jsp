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
	
	<div class="container">
		<h3>최근 게시글</h3>
		<c:forEach var="photoBoardList" items="${photoBoardList}">
			<div class="col-lg-4 col-md-6">
				<div>
					<c:choose>
						<c:when test="${photoBoardList.b_file_name ne null}">
							<img src='<c:url value="/resources/images/photoBoard/${photoBoardList.b_file_name}"/>' alt="" width="300" height="200"  onerror="javascript:setTimeout('location.reload()',1500); console.log('새로고침');">
						</c:when>
						<c:otherwise>
							<img src='<c:url value="/resources/images/noImage.png"/>' width="300" height="200">
						</c:otherwise>
					</c:choose>
				</div>
				<div>
					<p align="right"><font size="1px"> 조회수 : ${photoBoardList.b_hit}</font></p>
					<h3 style="font-size: 19px;">
						<a href="PhotoBoardDetailView?b_no=${photoBoardList.b_no}"><c:out value="${fn:substring(photoBoardList.b_title, 0 ,20)}" /></a>
					</h3>
					<p><c:out value="${fn:substring(photoBoardList.b_content,0,20)}" /></p>
					<ul class="tour-one__meta list-unstyled">
						<li><font size="1px">작성자 : ${photoBoardList.b_userId}&emsp;&emsp; 작성일 : ${photoBoardList.b_writing_date} </font> </li>
					</ul>
				</div>
			</div>
		</c:forEach>
	
	</div>
	<%--
 	<c:if test="${member == null}">
	
		<c:redirect url="loginView"/>
	</c:if> 
	--%>
</body>
</html>
