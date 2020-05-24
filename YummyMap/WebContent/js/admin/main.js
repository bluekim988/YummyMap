$(function(){
	let mno;
	$('.obtn').click(function(){
		let no = $(this).parents().parents().attr('id');
		let sel =	$('#opt').val();
		let scname = $('#search-input').val();
		$('#searchs').val(scname);
		$('#opts').val(sel);
		$('#no').val(no);
		$('#frm').attr('action','/YummyMap/admin/remember.mmy');
		$('#frm').submit();
	});
	
	$('.pbtn').click(function(){
		let page = $(this).text();
		let sel =	$('#opt').val();
		let scname = $('#search-input').val();
		$('#searchs').val(scname);
		$('#opts').val(sel);
		$('#nowpage').val(page);
		$('#frm').attr('action','/YummyMap/admin/main.mmy');
		$('#frm').submit();
		
	});
	
	$('#sbtn').click(function(){
		let sel =	$('#opt').val();
		let scname = $('#search-input').val();
		if(sel != 'nos' && !scname){
			alert('검색어를 입력하세요 ! ');
			$('#search-input').focus();
			return;
		}
		
		$('#searchs').val(scname);
		$('#opts').val(sel);
		$('#frm').attr('action','/YummyMap/admin/main.mmy');
		$('#frm').submit();
	});
	
	$('.rbtn').click(function(){
		mno = $(this).parents().parents().attr('id');
		$('#no').val(no);
		let id = $(this).parents().prevAll('.mid').text();
		$('.modal-body').html('<b>'+id+'</b> 해당 계정을 정말 삭제 하시겠습니까? ');
	});
	
	$('#rmbtn').click(function(){
		$('#no').val(mno);
		$('#frm').attr('action', '/YummyMap/admin/delmemberProc.mmy');
		$('#frm').submit();
	});
	$('#sid').hover(function(){
		$('#idinfo').attr('display','');
	},function(){
		$('#idinfo').attr('display','none');
	});
});