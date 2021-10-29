<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>

<body>
	 <div class="container">
		<h1>
			게시판 목록 
		</h1>
		<a href="home">메인</a>
	 	<c:if test="${member != null}">
			/ <a href="PhotoBoardWriteView">게시글작성</a> 
			/ <a href="logout">로그아웃</a>
		</c:if> 
	</div>
	<hr>
    <div class="container" align="center">
		<div id="content">
			<div class="container">
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
		</div>
		
		<!-- 게시글 페이징 처리(게시글 9개로 설정 됨) -->
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<!-- 첫 페이지면 Disabled 아니라면 Enabled -->
				<c:choose>
					<c:when test="${Paging.pageNo eq Paging.firstPageNo }">
						<li class="page-item disabled">
							<a class="page-link" href="PhotoBoardListView?page=${Paging.prevPageNo }">Previus</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="PhotoBoardListView?page=${Paging.prevPageNo }">Previus</a>
						</li>
					</c:otherwise>
				</c:choose>
				<!-- 페이지 갯수만큼 버튼 생성 -->
				<c:forEach var="i" begin="${Paging.startPageNo }" end="${Paging.endPageNo }" step="1">
					<c:choose>
						<c:when test="${i eq Paging.pageNo }">
							<li class="page-item disabled">
								<a class="page-link" href="PhotoBoardListView?page=${i}"><c:out value="${i}"/></a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="PhotoBoardListView?page=${i}"><c:out value="${i}"/></a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 마지막 페이지면 Disabled 아니라면 Enabled -->
				<c:choose>
					<c:when test="${Paging.pageNo eq Paging.finalPageNo }">
						<li class="page-item disabled">
							<a class="page-link" href="PhotoBoardListView?page=${Paging.nextPageNo }">Next</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="PhotoBoardListView?page=${Paging.nextPageNo }">Next</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
	
</body>
</html>