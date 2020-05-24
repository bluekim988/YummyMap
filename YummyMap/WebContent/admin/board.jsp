<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/YummyMap/css/admin/base.css">
<link rel="stylesheet" href="/YummyMap/css/admin/board.css">
<script type="text/javascript" src="/YummyMap/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/YummyMap/js/admin/board.js"></script>
<title>게시글 관리 페이지</title>
</head>

<body>
	<form method="post" action="" id="frm">
		<input type="hidden" name="mno" id="no" >
		<input type="hidden" name="nowpage" id="nowpage" value="${PAGE.nowPage }">
		<input type="hidden" name="searchs" id="searchs" >
		<input type="hidden" name="opts" id="opts">
		<input type="hidden" name="nos[]" id="txtno">
	</form>
	<div class="container mt-1">
		<nav class="d-flex justify-content-between navbar navbar-light">
			<a class="navbar-brand tcolor logo mt-5" href="#"> YUMMY MAP </a>
			<div>로그인 이미지</div>
		</nav>
		<div class="bar"></div>
		<div class="row row-cols-2 mt-2 sub">
			<div class="col-3 pt-5 pr-4 text-right bar-ri">
				<div>
					<a href="http://localhost/YummyMap/admin/main.mmy">
						<h5>회원 관리</h5>
					</a>
				</div>
				<div class="mt-3">
					<a href="http://localhost/YummyMap/admin/boardList.mmy">
						<h5>게시글 관리</h5>
					</a>
				</div>
			</div>

			<div class="col-9 d-flex flex-column bd-highlight mt-2"
				style="height: 575px;">
				<div class="mb-auto p-2 ">
					<div class="d-flex justify-content-around text-center">
						<div class="col-2">번호</div>
						<div class="col-4">제목</div>
						<div class="col-2">작성자</div>
						<div class="col-3">작성일</div>
						<div class="col-2">비고</div>
					</div>
					<div class="row bar py-1"></div>
					<c:forEach var="data" items="${LIST}">
						<div class="d-flex mt-3 justify-content-around text-center">
							<div class="col-2">
								<input type="checkbox" class="mr-2" name="no" value="${data.txtno }">${data.txtno}
							</div>
							<div class="col-4">${data.title }</div>
							<div class="col-2">${data.mid }</div>
							<div class="col-3">${data.sdate }</div>
							<div class="col-2">
								<button class="">삭제</button>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class=" p-2 d-flex bd-highlight">
					<button class="bd-highlight" id="allck">전체 선택</button>
					<button class="bd-highlight ml-1" id="allremve">선택 삭제</button>
					<select style="display: inline-block;" class="ml-auto col-2 form-control" id="opt" name="opt" >
						<option value="nos">검색조건</option>
						<c:if test="${empty OPT}">
							<option id="idsel" value="idch">작성자 검색</option>
							<option id="namesel" value="titlch">제목 검색</option>
						</c:if>
						<c:if test="${not empty OPT and OPT eq 'idch' }">
							<option id="idsel" value="idch" selected>작성자 검색</option>
							<option id="namesel" value="titlch">제목 검색</option>
						</c:if>
						<c:if test="${not empty OPT and OPT eq 'titlch' }">
							<option id="idsel" value="idch" >작성자 검색</option>
							<option id="namesel" value="titlch" selected>제목 검색</option>
						</c:if>
					</select>
					<div class="col-3 bd-highlight">
						<input type="search" class="form-control ds-input" id="search-input" placeholder="Search..."
							aria-label="Search for..." autocomplete="off" data-docs-version="4.5" spellcheck="false" role="combobox"
							aria-autocomplete="list" aria-expanded="false" aria-owns="algolia-autocomplete-listbox-0" dir="auto"
							style="position: relative; vertical-align: top;" name="search" value="${SCH}">
					</div>
						<button type="button" class="btn btn-secondary" id="sbtn">검색</button>
				</div>
				<div class="d-flex justify-content-around mb-1 mt-2" id="${PAGE.nowPage}">
					<div class="btn-group mr-2" role="group" aria-label="First group">
						<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
							<button type="button" class="btn btn-secondary pbtn">${page}</button>
						</c:forEach>
					</div>
				</div>
				</div>

			</div>
		<div class="bar"></div>
		</div>
	</div>

</body>

</html>