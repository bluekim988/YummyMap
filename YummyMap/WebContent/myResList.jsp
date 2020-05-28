<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 찜 리스트</title>
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
                        <div class="XrOey"><a class="_0ZPOP kIKUG _4700r " id="myListIcon"><svg aria-label="활동 피드"
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
            <a class="navbar-brand nav-item-size" href="/YummyMap/board/boardMain.mmy">
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
        <form class="p-rel search-btn" style="width: 150px;" action="/YummyMap/main/selectCateList.mmy" method="get" id="cateFrm">
            <select class="form-control form-control-sm border-top-0 border-left-0 border-right-0" name="category" id="cateBox">
			  	<option selected>CATEGORY</option>
			  	<c:forEach var="cateList" items="${cateList}">
			  	<option value="${cateList}">${cateList}</option>
			  	</c:forEach>
			</select>
        </form>
    </div>
    <!--검색창 영역 마지막입니다-->
    <!--side nav 시작입니다-->
    <div class="nav-side">
        <div class="tcolor list_title text-left">
            나의 찜 리스트
        </div>
        <div id="sideitem">
        <!-- 사이드 리스트 아이템 시작 -->
			<c:forEach var="ResData" items="${myResList}"> 
            <div class="ml-3 mt-3 list-item">
                <div class="list-item-info">
                    <div class="list-item-title t2color">${ResData.resname}</div>
                    <div class="list-item-sub t2color">${ResData.addr}</div>
                    <c:forEach var="menu" items="${ResData.menuList}">
                    <a class="list-item-sub t2color">${menu}</a>
                    </c:forEach>
                </div>
                <c:if test="${sid != null && ResData.ispick == 'N'}">
                <div class="list-item-like">
                    <p class="heart pickRes" id="${ResData.resno}"><i class="far fa-heart " ></i> </p>
                </div>
                </c:if>
                <c:if test="${sid != null && ResData.ispick == 'Y'}">
                <div class="list-item-like">
                    <p class="heart pickRes" id="${ResData.resno}"><i class="fas fa-heart"></i></p>
                </div>
                </c:if>
            </div>
         	</c:forEach>
		<!-- 사이드 리스트 아이템 끝 -->
        </div>
    </div>
    <!--side nav 마지막입니다-->
    <div class=" line2 list2-ml">
        <div class="row" id="line2">
        <!-- 이미지리스트 아이템 시작 -->
        	<c:forEach var="ResData2" items="${myResList}">
            <div class="orange-line res-item" id="${ResData2.resno}">
                <div class="text-right pb-1">
                    <div class="imgdiv">
                        <img src="/YummyMap/resimg/${ResData2.imgList.get(0)}" >
                        <div class="text-left tcolor res-item-title ml-2 mt-1">
                            ${ResData2.resname}[${ResData2.avg}]
                        </div>
                    </div>
                </div>
                <div class="text-left ml-2 pt-4">
                    <p id="star_grade">
                    	<c:forEach var="star" begin="1" end="${ResData2.avg}">
                        <a class="fas fa-star tcolor"></a>
                        </c:forEach>
                        <c:if test="${ResData2.avg *10 % 10 != 0 }">
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
	
    
  //로그인 여부를 확인합니다.
  let userid = '${sid}';
  if(!userid) {
	  $('#login').show();
	  $('#logout').hide();
	  $('#mypage').attr('href', '/YummyMap/join/join.mmy');
  } else {
	  $('#login').hide();
	  $('#logout').show();
	  $('#mypage').attr('href', '/YummyMap/member/member.mmy');
  }
	
	//검색기능 이벤트입니다.
	  $("#searchTag").keydown(function(key) {
         if (key.keyCode == 13) {
        	let query_str = $('#searchTag').val();
			$(location).attr('href', '/YummyMap/main/searchList.mmy?q='+query_str);
			
         }
      });
	  let que_str = '${param.q}';
	//상세보기 전환 이벤트입니다.
	$('.res-item').click(function(){
		let resno = $(this).attr('id');
		console.log(que_str);
		$(location).attr('href', '/YummyMap/main/detail.mmy?r='+resno+'&q='+que_str);
	});
	
	//찜(하트) 비동기 처리입니다.
	$('.pickRes').click(function(){
		let resNo = $(this).attr('id');
		$.ajax({
			url:'/YummyMap/main/pickMyRes.mmy',
			type:'post',
			dataType:'json',
			data:{
				'resNo':resNo
			},
			success:function(data){
				let success_result = data.result;
				console.log(success_result);
				location.reload();
			}
		});

	});
	//카테고리 선택 이벤트입니다.
	$('#cateBox').change(function(){
		$('#cateFrm').submit();
	});
	
	let cate_param = '${param.category}';
	if(cate_param) {
		$('#cateSet').val(cate_param);
	}


});
    

</script>

</html>