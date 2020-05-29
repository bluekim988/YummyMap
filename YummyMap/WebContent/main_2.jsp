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
                        <div class="XrOey"><a class="_0ZPOP kIKUG _4700r "  id="myListIcon"><svg aria-label="활동 피드"
                                    class="_8-yf5 " fill="#262626" height="24" viewBox="0 0 48 48" width="24">
                                    <path
                                        d="M34.6 6.1c5.7 0 10.4 5.2 10.4 11.5 0 6.8-5.9 11-11.5 16S25 41.3 24 41.9c-1.1-.7-4.7-4-9.5-8.3-5.7-5-11.5-9.2-11.5-16C3 11.3 7.7 6.1 13.4 6.1c4.2 0 6.5 2 8.1 4.3 1.9 2.6 2.2 3.9 2.5 3.9.3 0 .6-1.3 2.5-3.9 1.6-2.3 3.9-4.3 8.1-4.3m0-3c-4.5 0-7.9 1.8-10.6 5.6-2.7-3.7-6.1-5.5-10.6-5.5C6 3.1 0 9.6 0 17.6c0 7.3 5.4 12 10.6 16.5.6.5 1.3 1.1 1.9 1.7l2.3 2c4.4 3.9 6.6 5.9 7.6 6.5.5.3 1.1.5 1.6.5.6 0 1.1-.2 1.6-.5 1-.6 2.8-2.2 7.8-6.8l2-1.8c.7-.6 1.3-1.2 2-1.7C42.7 29.6 48 25 48 17.6c0-8-6-14.5-13.4-14.5z">
                                    </path>
                                </svg></a>
                            <div class="_0Sl_t">
                                <div class="poA5q" style="margin-left: -423px;"></div>
                            </div>
                        </div>
                        <div class="XrOey"><a  id="mypage"><svg aria-label="프로필" class="_8-yf5 " fill="#262626" height="24"
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
        <div class="b-subtitle text-left"><p class="pt-3">상세정보페이지</p></div>
        <div class=" nav-item-1 d-flex justify-content-end">
            <a class="navbar-brand nav-item-size" href="/YummyMap/game/game.mmy" id="">
                <i class="fas fa-gamepad"></i>
            </a>
            <a class="navbar-brand nav-item-size" href="/YummyMap/board/boardMain.mmy">
                <i class="far fa-clipboard"></i>
            </a>
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
        <form class="p-rel search-btn" style="width: 150px;" action="/YummyMap/main/selectCateList.mmy" method="get" id="cateFrm">
            <select class="form-control form-control-sm border-top-0 border-left-0 border-right-0" name="category" id="cateBox">
			  	<option selected id="cateSet">CATEGORY</option>
			  	<c:forEach var="cateList" items="${cateList}">
			  	<option value="${cateList}">${cateList}</option>
			  	</c:forEach>
			</select>
        </form>
    </div>
    <!--검색창 영역 마지막입니다-->
    <!--side nav 시작입니다-->
    <div class="nav-side bg-white" style="overflow:auto; overflow-x:hidden;">
        <div class="t2color list_title text-left">
            YUMMY LIST
        </div>
        <div>
            <div class="ml-3 mt-3 list-item">
                <div class="list-item-info">
                    <div class="list-item-title t2color" id="resName">${vo.resname}</div>
                    <div class="list-item-sub text-muted">${vo.addr}</div>
                    <c:forEach var="menu" items="${vo.menuList}">
                    <a class="list-item-sub text-muted">${menu}</a>
                    </c:forEach>
                </div>
                <c:if test="${sid != null && vo.ispick == 'N'}">
                <div class="list-item-like">
                    <p class="heart pickRes" id="${vo.resno}"><i class="far fa-heart " ></i> </p>
                </div>
                </c:if>
                <c:if test="${sid != null && vo.ispick == 'Y'}">
                <div class="list-item-like">
                    <p class="heart pickRes" id="${vo.resno}"><i class="fas fa-heart"></i></p>
                </div>
                </c:if>
            </div>
        </div>
    </div>
    <!--side nav 마지막입니다-->
    <div class="line2 list2-ml mb-5" style="overflow-x:none;">
        <div class="row">
            <div class="orange-line res-item content">
                <div class="text-right md_ft1">
                    <div class="imgdiv">
                        <span class="imgspan">
                            <img src="/YummyMap/resimg/${vo.imgList.get(0)}" style="height: 260px;">
                            <div id="map" style="width:100%;height:260px;"></div>
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
                            ${vo.resname}[${vo.avg}]
                        </div>
                    </div>
                </div>
                <div class="bizinfo_area mb-5">
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
                                    <li><span class="addr dt_ft" id="resAddr">${vo.addr}</span><span class="btn"></span>
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
                    <div class="d-flex">
	                    <div class="rv_tt "> REVIEW</div>
	                    <small class="text-muted pl-2 ">리뷰(${vo.reviewCount})</small>
                    </div>
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
                    	<c:if test="${vo.isReview == 'N'}">
                    	<button type="button" class="btn btn-primary btn-sm ml-1 r-btn" id="${vo.resno}" style="width: 70px">작성</button>
                    	</c:if>
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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d8654c7466588faa58bc40d0b9bef6ce&libraries=services"></script>
<script type="text/javascript" src="../js/jquery-3.5.0.min.js"></script>
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
	 
	//별 이벤트처리
	var star_num;
	 $('#star_grade a').click(function(){
			// 별점의 on 클래스 전부 제거 
	        $(this).parent().children("a").removeClass("on");  
	     	// 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가
	        $(this).addClass("on").prevAll("a").addClass("on"); 
	         // 해당별점 값 가져오기
	        star_num = $(this).attr('id');	
	        return false;
	 });
	 
	 $('.r-btn').click(function(){
		 if(!userid) {
			 alert('로그인을 진행해주세요');
			 return;
		 }
		 if(!star_num){
			 alert('평점을 선택해주세요');
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
	
	//마이리스트 이벤트 처리 입니다.
	$('#myListIcon').click(function(){
		if(!userid) {
			alert('로그인을 진행해주세요');
			return;
		}
		$(location).attr('href', '/YummyMap/main/myList.mmy');
	});

	//카테고리 선택 이벤트입니다.
	$('#cateBox').change(function(){
		$('#cateFrm').submit();
	});
	
	let cate_param = '${param.category}';
	if(cate_param) {
		$('#cateSet').val(cate_param);
	}
	
	
	// 카카오 지도 API
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	// 장소 검색 객체를 생성합니다
	var ps = new kakao.maps.services.Places(); 
	var keyword_tag = document.getElementById('resName').innerText;
	var keyword = '구로디지털단지역 ' + keyword_tag;
	if(keyword_tag.indexOf('구로디지털')>0){
		keyword = keyword_tag;
	}
	// 키워드로 장소를 검색합니다
	ps.keywordSearch(keyword, placesSearchCB); 

	// 키워드 검색 완료 시 호출되는 콜백함수 입니다
	function placesSearchCB (data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {

	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
	        // LatLngBounds 객체에 좌표를 추가합니다
	        var bounds = new kakao.maps.LatLngBounds();

	        for (var i=0; i<1; i++) {
	            displayMarker(data[i]);    
	            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
	        }       

	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	        map.setBounds(bounds);
	    } 
	}
	// 지도에 마커를 표시하는 함수입니다
	function displayMarker(place) {
	    
	    // 마커를 생성하고 지도에 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: new kakao.maps.LatLng(place.y, place.x) 
	    });


	}


});
</script>

</html>