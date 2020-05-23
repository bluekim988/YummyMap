$(function(){
	$('#join').click(function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		if(!sid){
			alert('아이디를 입력하세요');
			$('#id').focus();
			return;
		}else if(!spw){
			alert('비밀번호를 입력하세요');
			$('#pw').focus();
			return;
		}
		
		var idck = idchk(sid);
		var pwck = pwchk(spw);
		if(idck == false || pwck == false){
			alert('아이디 또는 비밀번호가 올바르지 않습니다');
			$('#id').focus();
			return;
		}
		
		
		$('#frm').submit();

		alert(cnt);
/*		$.ajax({
			url: '/YummyMap/admin/login.ck',
			type: 'post',
			dataType: 'json',
			data: {
				'id' : sid,
				'pw' : spw
			},
			success: function(data) {
				var result = data.cnt;
				if(result == 0){
					$('#id').val('');
					$('#pw').val('');
					$('#id').focus();
					$('#idck').removeClass('d-none');
				}else{
					$('#frm').submit();
				}
			},
			error: function(){
				alert('통신 실패');
			}
		});*/
		
	});
	
	function idchk(id) {
		var pett = /^([A-Za-z]){1}\w{4,12}$/;
		var ok = pett.test(id);
		return ok;
	}
	
	function pwchk(pw) {
		var patt = /^([a-z0-9!@#$%^&*-+_]){1}(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*-=])[a-zA-Z0-9!@#$%^&*-+_]{7,12}$/i;
		var pwok = patt.test(pw);
		return pwok;
	}
});