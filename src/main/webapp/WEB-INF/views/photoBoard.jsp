<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


</head>
<body id="page-top">
    <div id="wrapper">
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<div class="container-fluid">
				</div>
			</div>
			
			<!-- 게시글 페이징 처리(기준 10개) -->
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<!-- 첫 페이지면 Disabled 아니라면 Enabled -->
					<c:choose>
						<c:when test="${Paging.pageNo eq Paging.firstPageNo }">
							<li class="page-item disabled">
								<a class="page-link" href="PhotoBoardView?page=${Paging.prevPageNo }">Previus</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="PhotoBoardView?page=${Paging.prevPageNo }">Previus</a>
							</li>
						</c:otherwise>
					</c:choose>
					<!-- 페이지 갯수만큼 버튼 생성 -->
					<c:forEach var="i" begin="${Paging.startPageNo }" end="${Paging.endPageNo }" step="1">
						<c:choose>
							<c:when test="${i eq Paging.pageNo }">
								<li class="page-item disabled">
									<a class="page-link" href="PhotoBoardView?page=${i}"><c:out value="${i}"/></a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="PhotoBoardView?page=${i}"><c:out value="${i}"/></a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- 마지막 페이지면 Disabled 아니라면 Enabled -->
					<c:choose>
						<c:when test="${Paging.pageNo eq Paging.finalPageNo }">
							<li class="page-item disabled">
								<a class="page-link" href="PhotoBoardView?page=${Paging.nextPageNo }">Next</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="PhotoBoardView?page=${Paging.nextPageNo }">Next</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>