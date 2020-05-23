<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="/YummyMap/css/admin/base.css">
	<link rel="stylesheet" href="/YummyMap/css/admin/board.css">
	<script type="text/javascript" src="/YummyMap/js/jquery-3.5.0.min.js"></script>
	<title>게시글 관리 페이지</title>
</head>

<body>
	<div class="container mt-1">
		<nav class="d-flex justify-content-between navbar navbar-light">
			<a class="navbar-brand tcolor logo mt-5" href="#">
				YUMMY MAP
			</a>
			<div>
				로그인 이미지
			</div>
		</nav>
		<div class="bar"></div>
		<div class="row row-cols-2 mt-2 sub">
			<div class="col-3 pt-5 pr-4 text-right bar-ri">
				<div><a href="#">
						<h5>회원 관리</h5>
					</a></div>
				<div class="mt-3">
					<a href="#">
						<h5>게시글 관리</h5>
					</a>
				</div>
			</div>

			<div class="col-9 d-flex flex-column bd-highlight mt-2 hi40" style="height: 540px;">
				<div class="mb-auto p-2 ">
					<div class="d-flex justify-content-around text-center">
						<div class="col-2"><input type="checkbox" class="mr-2" id="allno">번호</div>
						<div class="col-4">제목</div>
						<div class="col-2">작성자</div>
						<div class="col-3">작성일</div>
						<div class="col-2">비고</div>
					</div>
					<div class="row bar py-1"></div>
					<div class="d-flex mt-3 justify-content-around text-center">
						<div class="col-2"><input type="checkbox" class="mr-2" id="no" name="no">1</div>
						<div class="col-4">sa</div>
						<div class="col-2">강사님</div>
						<div class="col-3">2020/05/01 11:21</div>
						<div class="col-2">
							<button class="">삭제</button>
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-around">
					<div class="btn-group mr-2 border" role="group" aria-label="First group">
						<button type="button" class="btn btn-secondary">1</button>
						<button type="button" class="btn btn-secondary">2</button>
						<button type="button" class="btn btn-secondary">3</button>
						<button type="button" class="btn btn-secondary">4</button>
					</div>
				</div>
				<div class=" p-2 d-flex bd-highlight">
					<button class="bd-highlight">전체 선택</button>
					<button class="bd-highlight ml-1">선택 삭제</button>
					<select style="display: inline-block;" class="ml-auto col-2 form-control" name="opt">
						<option value="">검색조건</option>
						<option id="title">제목 검색</option>
						<option id="idsel">계정 검색</option>
					</select>
					<div class="col-4 bd-highlight">
						<input type="search" class="form-control ds-input" id="search-input" placeholder="Search..."
							aria-label="Search for..." autocomplete="off" data-docs-version="4.5" spellcheck="false" role="combobox"
							aria-autocomplete="list" aria-expanded="false" aria-owns="algolia-autocomplete-listbox-0" dir="auto"
							style="position: relative; vertical-align: top;"></div>
				</div>

			</div>
		</div>
		<div class="bar"></div>
	</div>

</body>

</html>