$(function(){
	$('#lbtn').click(function(){
		$('#frm').attr('action','/YummyMap/admin/boardList.mmy');
		$('#frm').submit();
	});
	
	$('#delete').click(function(){
		$('#frm').attr('action','/YummyMap/admin/checkDel.mmy');
		$('#frm').submit();
	});
});