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
<link rel="stylesheet" href="/YummyMap/css/admin/adminboardDetail.css">
<script type="text/javascript" src="/YummyMap/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/YummyMap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/YummyMap/js/admin/board.js"></script>
<title>게시글 관리 페이지</title>
</head>

<body>
	<form method="post" action="" id="frm">
		<input type="hidden" name="nowpage" id="nowpage" value="${PAGE.nowPage }">
		<input type="hidden" name="searchs" id="searchs" >
		<input type="hidden" name="opts" id="opts">
		<input type="hidden" name="nos" id="txtno">
	</form>
	<div class="container mt-1 mb5">
		<div class="bg-white nav-body">
			<div class=" mt-2 nav-btn">
				<div class="member_nav text-right mt-3">
					<div class="ctQZg">
						<!-- <a href="#" class="badge badge-light nav-item" id="join">Join</a>-->
						<div class="badge badge-light nav-item">${SID}</div>
						<a href="http://localhost/YummyMap/admin/adminedit.mmy" class="badge badge-light nav-item">정보수정</a>
						<a href="#" class="badge badge-light nav-item" id="logout">LOGOUT</a>
					</div>
				</div>
			</div>
			<a class="navbar-brand tcolor logo ml-1" href="http://localhost/YummyMap/admin/main.mmy" id=""> YUMMY MAP </a>
		</div>
		<div class="bar"></div>
		<div class="row row-cols-2 sub ml-1">
			<div class="col-3 pt-5 pr-4 text-right bar-ri">
				<div class="text-left mt-3">
					<a href="http://localhost/YummyMap/admin/main.mmy">
						<h5>회원 관리</h5>
					</a>
				</div>
				<div class="mt-4 text-left">
					<a href="http://localhost/YummyMap/admin/boardList.mmy">
						<h5>게시글 관리</h5>
					</a>
				</div>
			</div>

			<div class="col-9 d-flex flex-column bd-highlight mt-2"
				style="height: 575px;">
				      <div class="txt-line  mb-4">
        <div class="btns d-flex justify-content-end pr-4 mt-2" >
            <a href="#" class="badge badge-danger" id="delete">삭제</a>
        </div>
        <div class="b-w border-bottom ml-5 mt-4"></div>
        <div class="d-flex title">
            <div class="txt-title pt-4" id="title">title</div>
            <div class="pt-4 d-flex">
                <div class="list-item-like like-size">
                    <span class="heart"><i class="far fa-heart " aria-hidden="true" ></i> </span>
                </div>
            </div>
        </div>
        <div class="b-w border-bottom ml-5 mt-4"></div>
        <div class="txt-body pt-4 " id="txt">
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ
            내용ㅁㄴㅇㄻㄴㅇ리만어림나얼민아ㅓㄹ;ㅣㅁ넝ㄹ;ㅣㅁ너ㅏㅇ리;만ㅇ러민ㅇ라ㅓㅁㅇ노라ㅓㅗ만어로민아러미낭럼;ㅣㄴ아럼ㄹㅇ니ㅓㅏ

        </div>
    </div>
			
			</div>

			</div>
		<div class="bar"></div>
		</div>
	</div>
	
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button type="button" class="btn btn-danger" id="rmbtn">확인</button>
      </div>
    </div>
  </div>
</div>

</body>

</html>