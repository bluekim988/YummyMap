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
    <link rel="stylesheet" href="/YummyMap/css/main_2.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
                        <div class="XrOey"><a href="#" id="mypage"><svg aria-label="프로필" class="_8-yf5 " fill="#262626" height="24"
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
        <a class="navbar-brand tcolor logo" href="/YummyMap/main.mmy" id="">
            YUMMY MAP
        </a>
        <div class=" nav-item-1 d-flex justify-content-end">
            <a class="navbar-brand nav-item-size" href="/YummyMap/game/game.mmy" id="">
                <i class="fas fa-gamepad"></i>
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
            <label for=""><i class="fas fa-search ml-4 mt-3"></i></label>
            <input class="ml-1 border-top-0 border-left-0 border-right-0" id="searchTag" placeholder="  SEARCH" type="text"
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
                                            <th scope="row">강남역</th>
                                        </tr>
                                        <tr>
                                            <th scope="row">구로디지털단지역</th>
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
        <div>
        	<c:forEach var="resData" items="${resList}">
            <div class="ml-3 mt-3 list-item">
                <div class="list-item-info">
                    <div class="list-item-title t2color">${resData.resname}</div>
                    <div class="list-item-sub t2color">${resData.addr}</div>
                    <c:forEach var="menu" items="${resData.menuList}">
                    <a class="list-item-sub t2color">${menu}</a>
                    </c:forEach>
                </div>
                <div class="list-item-like">
                    <span class="heart"><i class="far fa-heart " aria-hidden="true"></i> </span>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <!--side nav 마지막입니다-->
    <div class="line2 list2-ml mb-5">
        <div class="row">
            <div class="orange-line res-item content">
                <div class="text-right md_ft1">
                    <div class="imgdiv">
                        <span class="imgspan">
                        	<c:forEach var="imgdata" items="${vo.imgList}">
                            <img src="/YummyMap/resimg/${imgdata}" style="height: 260px;">
                            </c:forEach>
                        </span>
                        <div class="text-left ml-2">
                            <p id="star_grade">
	                    	<c:forEach var="star" begin="1" end="${vo.avg}">
	                        <a class="fas fa-star tcolor"></a>
	                        </c:forEach>
	                        <c:if test="${vo.avg *10 % 10 != 0 }">
	                        <a class="fas fa-star-half-alt tcolor"></a>
	                        </c:if>
                            </p>
                        </div>
                        <div class="text-left tcolor res-item-title ml-2 mt-1">
                            ${vo.resname}
                            <span class="heart"><i class="far fa-heart" aria-hidden="true"></i> </span>
                            <div class="list-item-like heart">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="bizinfo_area">
                    <div class="list_bizinfo">
                        <div class="list_item list_item_biztel"><span class="tit" aria-label="전화" role="img"><svg
                                    class="icon" role="presentation" version="1.1" width="20" height="20"
                                    viewBox="0 0 25 25">
                                    <path fill="#9E9E9E"
                                        d="M13.309,16.492l-0.314-0.062C6.572,15.15,1.596,10.172,0.316,3.745L0.254,3.431L3.682,0l5.095,5.09 L6.494,7.371c0.755,1.186,1.763,2.185,2.949,2.925l2.271-2.27l5.033,5.029L13.309,16.492z M1.559,3.822 c1.258,5.694,5.668,10.106,11.358,11.364l2.132-2.132l-3.336-3.332L9.655,11.78l-0.387-0.194c-1.712-0.962-3.098-2.341-4.052-4.01 L4.989,7.179L7.078,5.09L3.682,1.697L1.559,3.822z">
                                    </path>
                                </svg></span>
                            <div class="txt dt_ft1">${vo.tel}</div>
                        </div>
                        <div class="list_item list_item_address"><span class="tit" aria-label="주소" role="img"><svg
                                    class="icon" role="presentation" version="1.1" width="20" height="20"
                                    viewBox="0 0 25 25">
                                    <path fill="#9E9E9E"
                                        d="M8.501,5.697c0.991,0,1.797,0.808,1.797,1.801c0,0.992-0.806,1.798-1.797,1.798 	c-0.991,0-1.797-0.807-1.797-1.798C6.704,6.506,7.51,5.697,8.501,5.697 M8.501,4.498c-1.654,0-2.997,1.343-2.997,3.001 	c0,1.655,1.342,2.999,2.997,2.999c1.654,0,2.997-1.343,2.997-2.999C11.498,5.841,10.154,4.498,8.501,4.498L8.501,4.498z M8.501,1.2 	c3.473,0.002,6.3,2.832,6.3,6.308c0,1.171-0.326,2.312-0.943,3.306L8.5,17.143l-5.357-6.328C2.525,9.816,2.199,8.675,2.199,7.509 	C2.201,4.032,5.028,1.202,8.501,1.2 M8.501,0C4.366,0.002,1.001,3.37,0.999,7.508c0,1.421,0.406,2.811,1.173,4.017L8.5,19 	l6.328-7.475c0.769-1.205,1.172-2.591,1.172-4.017C16,3.37,12.636,0.002,8.501,0L8.501,0z">
                                    </path>
                                </svg></span>
                            <div class="txt dt_pd">
                                <ul class="list_address">
                                    <li><span class="addr dt_ft">${vo.addr}</span><span class="btn"><a class="link"
                                                href="#">지도보기</a></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="list_item list_item_menu mt-3"><span class="tit" aria-label="메뉴" role="img"><svg
                                    class="icon" role="presentation" version="1.1" width="20" height="20"
                                    viewBox="0 0 25 25">
                                    <path fill="#9E9E9E"
                                        d="M4.5,0C2.567,0,1,1.567,1,3.5v3c0,1.762,1.306,3.205,3,3.45V17h1V9.95C6.694,9.705,8,8.262,8,6.5v-3 C8,1.567,6.433,0,4.5,0z M6.8,6.5c0,1.268-1.032,2.3-2.3,2.3S2.2,7.769,2.2,6.5v-3c0-1.268,1.032-2.3,2.3-2.3s2.3,1.032,2.3,2.3V6.5 z M14.8,0v6.5c0,1.096-0.772,2.012-1.8,2.242V0h-1v8.742c-1.028-0.23-1.8-1.146-1.8-2.242V0H9v6.5c0,1.762,1.306,3.205,3,3.45V17h1 V9.95c1.694-0.245,3-1.688,3-3.45V0H14.8z">
                                    </path>
                                </svg></span>
                                  <div class="txt d-flex">
                            	<c:forEach var="menudata" items="${vo.menuList}">
								<div class="menu pr-3">${menudata}</div>
								</c:forEach>
                            </div>

                        </div>
                    </div>
                    <div class="rv_tt"> RIVIEW </div>
                    	<a class="pr-2">별점선택</a>
                    <div id="star_grade">
                    	<a class="fas fa-star " id="1"></a>
                    	<a class="fas fa-star " id="2"></a>
                    	<a class="fas fa-star " id="3"></a>
                    	<a class="fas fa-star " id="4"></a>
                    	<a class="fas fa-star " id="5"></a>
                    </div>
                    <div class="d-flex">
                    	<input class="form-control form-control-sm r-input border-top-0 border-left-0 border-right-0" type="text" placeholder="한줄 리뷰 달기" id="r-txt">
                    	<button type="button" class="btn btn-primary btn-sm ml-1 r-btn" id="${vo.resno}" style="width: 70px">작성</button>
                    </div>
                    <c:forEach var="rdata" items="${list}">
				    <div class="d-flex mt-3">
				        <div class="r-sdate">
				            ${rdata.sdate}
				        </div>
				        <div class="r-id pr-3 text-left">
				            ${rdata.id}
				        </div>
				        <div class="r-txt">
				            ${rdata.txt}
				        </div>
				        <div class="r-avg ">
				            ${rdata.starnum}점
				        </div>
				        <c:if test="${sid == rdata.id}">
				        <div class="pl-3 "><a href="/YummyMap/main/removeReview.mmy?revno=${rdata.revno}&resno=${vo.resno}" class="badge badge-danger">삭제</a></div>
				        </c:if>
				    </div>
				    </c:forEach>
                </div>
            </div>
        </div>
    </div>

</body>
<script type="text/javascript" src="../js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	//하트 이벤트처리 입니다.
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
	 
	//별 이벤트처리
	var star_num;
	 $('#star_grade a').click(function(){
	        $(this).parent().children("a").removeClass("on");  /* 별점의 on 클래스 전부 제거 */ 
	        $(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
	        star_num = $(this).attr('id');
	        return false;
	 });
	 $('.r-btn').click(function(){
		 if(!userid) {
			 alert('로그인을 진행해주세요');
			 return;
		 }
		console.log(star_num); 
		 let rtxt = $('#r-txt').val();
		 let res_no = $(this).attr('id');
		 $(location).attr('href', '/YummyMap/main/reviewProc.mmy?s='+star_num+'&t='+rtxt+'&r='+res_no);
	 });
	 
		//검색기능 이벤트입니다.
	  $("#searchTag").keydown(function(key) {
        if (key.keyCode == 13) {
       	let query_str = $('#searchTag').val();
			$(location).attr('href', '/YummyMap/main/searchList.mmy?q='+query_str);
			
        }
     });


});
</script>

</html>