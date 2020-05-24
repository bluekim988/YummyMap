<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="/YummyMap/css/main_1.css" />
    <link rel="stylesheet" href="/YummyMap/css/nav.css" />
    <script src="/YummyMap/js/jquery-3.5.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <style>

    </style>
</head>

<body>
    <!-- nav 영역입니다-->
    <div class="bg-white border-bottom fixed-top nav-body">
        <div class=" mt-2 nav-btn">
            <div class="member_nav text-right mt-3">
                <div class="ctQZg">
                    <div class="_47KiJ">
                        <div class="XrOey"><a class="_0ZPOP kIKUG _4700r " href="#"><svg aria-label="활동 피드"
                                    class="_8-yf5 " fill="#262626" height="24" viewBox="0 0 48 48" width="24">
                                    <path
                                        d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z">
                                    </path>
                                </svg></a>
                            <div class="_0Sl_t">
                                <div class="poA5q" style="margin-left: -423px;"></div>
                            </div>
                        </div>
                        <div class="XrOey" id=""><a href="#" id="mypage"><svg aria-label="프로필" class="_8-yf5 " fill="#262626" height="24"
                                    viewBox="0 0 48 48" width="24">
                                    <path
                                        d="M24 26.7c7.4 0 13.4-6 13.4-13.4S31.4 0 24 0 10.6 6 10.6 13.4s6 13.3 13.4 13.3zM24 3c5.7 0 10.4 4.6 10.4 10.4S29.7 23.7 24 23.7s-10.4-4.6-10.4-10.4S18.3 3 24 3zm9.1 27.1H14.9c-7.4 0-13.4 6-13.4 13.4v3c0 .8.7 1.5 1.5 1.5s1.5-.7 1.5-1.5v-3c0-5.7 4.6-10.4 10.4-10.4h18.3c5.7 0 10.4 4.6 10.4 10.4v3c0 .8.7 1.5 1.5 1.5s1.5-.7 1.5-1.5v-3c-.1-7.4-6.1-13.4-13.5-13.4z">
                                    </path>
                                </svg></a></div>
                    </div>
                    <a href="/YummyMap/join/login.mmy" class="badge badge-light nav-item" id="login">LOGIN</a>
                    <a href="/YummyMap/join/logoutProc.mmy" class="badge badge-light nav-item" id="logout">LOGOUT</a>
                </div>
            </div>
        </div>
        <a class="navbar-brand tcolor logo" href="/YummyMap/main.mmy">
            YUMMY MAP
        </a>
        <div class=" nav-item-1 d-flex justify-content-end">
            <a class="navbar-brand nav-item-size" href="/YummyMap/game/game.mmy" >
                <i class="fas fa-gamepad" id="game"></i>
            </a>
            <a class="navbar-brand nav-item-size" href="#">
                <i class="far fa-clipboard"></i>
            </a>
        </div>
    </div>
    </div>
    <!-- nav 마지막 입니다-->
    <!--검색창 영역입니다-->
    <div class="sel-body bg-white">
        <div class="input-group-sm input-group-sm p-rel search-box">
            <label for="searchTag"><i class="fas fa-search ml-4 mt-3"></i></label>
            <input id="searchTag" class="ml-1 border-top-0 border-left-0 border-right-0" placeholder="  SEARCH" type="text"
                class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="p-rel search-btn">
            <button type="button" id="sub_btn" class="btn btn-warning btn-sm" data-toggle="modal"
                data-target="#staticBackdrop">
                위치선택
            </button>
        </div>
    </div>
    <!--검색창 영역 마지막입니다-->
    <!--모달 페이지 시작입니다-->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title ml-4 md_ft2" id="staticBackdropLabel">위치 선택 </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-3 ml-4 mr-4 md_cl">
                                <table class="table table-hover md_ft">
                                    <thead>
                                        <tr>
                                            <th scope="col">호선</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">2호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">3호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">4호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">5호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">6호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">7호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">8호선</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">9호선</th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="col-6 md_cl1 ml-3">
                                <table class="table table-hover md_ft1">
                                    <thead>
                                        <tr>
                                            <th scope="col">역이름</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th class="sub-item" scope="row">신림역</th>
                                        </tr>
                                        <tr>
                                            <th class="sub-item" scope="row">구로디지털단지역</th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary md_btn">선택</button>
                    <button type="button" class="btn btn-secondary md_btn1" data-dismiss="modal">취소</button>
                </div>
            </div>
        </div>
    </div>
    <!--모달 페이지 마지막입니다-->
    <!--side nav 시작입니다-->
    <div class="nav-side">
        <div class="tcolor list_title text-left">
            YUMMY LIST
        </div>
        <div id="sideitem">
        <!-- 사이드 리스트 아이템 시작 -->
        	<c:forEach var="data" items="${list}">
            <div class="ml-3 mt-3 list-item">
                <div class="list-item-info">
                    <div class="list-item-title t2color">${data.resname}</div>
                    <div class="list-item-sub t2color">${data.addr}</div>
                    <c:forEach var="menu" items="${data.menuList}">
                    <div class="list-item-sub t2color">${menu}</div>
                    </c:forEach>
                </div>
                <div class="list-item-like">
                    <span class="heart"><i class="far fa-heart " aria-hidden="true"></i> </span>
                </div>
            </div>
         	</c:forEach>
		<!-- 사이드 리스트 아이템 끝 -->
        </div>
    </div>
    <!--side nav 마지막입니다-->
    <div class=" line2 list2-ml">
        <div class="row">
        <!-- 이미지리스트 아이템 시작 -->
        	<c:forEach var="data2" items="${list}">
            <div class="orange-line res-item" id="${data2.resno}">
                <div class="text-right">
                    <div class="imgdiv">
                        <img src="/YummyMap/resimg/${data2.imgList.get(0)}" >
                        <div class="text-left tcolor res-item-title ml-2 mt-1">
                            ${data2.resname}[${data2.avg}]
                        </div>
                    </div>
                    <div class="list-item-like mt-1 mr-2">
                        <span class="heart"><i class="far fa-heart " aria-hidden="true"></i> </span>
                    </div>
                </div>
                <div class="text-left ml-2">
                    <p id="star_grade">
                    	<c:forEach var="star" begin="1" end="${data2.avg}">
                        <a class="fas fa-star tcolor"></a>
                        </c:forEach>
                        <c:if test="${vo.avg *10 % 10 != 0 }">
	                        <a class="fas fa-star-half-alt tcolor"></a>
                        </c:if>
                    </p>
                </div>
            </div>
            </c:forEach>
            <!-- 이미지리스트 아이템 끝 -->

        </div>
    </div>
</body>
<script type="text/javascript" src="/YummyMap/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	//하트 이벤트입니다.
    $(".heart").click(function () {
        if ($(this).hasClass("liked")) {
            $(this).html('<i class="far fa-heart" aria-hidden="true"></i>');
            $(this).removeClass("liked");
        } else {
            $(this).html('<i class="fa fa-heart" aria-hidden="true"></i>');
            $(this).addClass("liked");
        }
    });
    
  //로그인 여부를 확인합니다.
  let userid = '${sid}';
  if(!userid) {
	  $('#login').show();
	  $('#logout').hide();
	  $('#mypage').attr('href', '/YummyMap/join/join.mmy');
  } else {
	  $('#login').hide();
	  $('#logout').show();
	  $('#mypage').attr('href', '/YummyMap/member/mypage.mmy');
  }
    
	//검색기능 비동기 이벤트입니다.
	  $("#searchTag").keydown(function(key) {
         if (key.keyCode == 13) {
        	let str = $('#searchTag').val();
			$(location).attr('href', '/YummyMap/main/searchList.mmy?q='+str);
         }
      });
	
	//상세보기 전환 이벤트입니다.
	$('.res-item').click(function(){
		let resno = $(this).attr('id');
		$(location).attr('href', '/YummyMap/main/detail.mmy?r='+resno);
	});

});
    

</script>

</html>