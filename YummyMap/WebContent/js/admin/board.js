$(function(){
	let txtnos = [];
	$('.pbtn').click(function(){
		let page = $(this).text();
		$('#nowpage').val(page);
		let inid = $('#search-input').val();
		let opt = $('#opt').val();
		$('#searchs').val(inid);
		$('#opts').val(opt);
		$('#frm').attr('action','/YummyMap/admin/boardList.mmy');
		$('#frm').submit();
	});
	
	$('#sbtn').click(function(){
		let inid = $('#search-input').val();
		let opt = $('#opt').val();
		$('#searchs').val(inid);
		$('#opts').val(opt);
		$('#frm').attr('action','/YummyMap/admin/boardList.mmy');
		$('#frm').submit();
	});
	
	$('#allck').click(function(){
		$("input:checkbox").attr('checked','checked');
	});
	
	$('#allremve').click(function(){
		$("input:checkbox[name='no']:checked").each(function(){
			txtnos.push($(this).val()); 
		});
		for(let i=0; i<txtnos.length; i++){
			alert(txtnos[i]);
		}
		
		$.ajax({
			url: '/YummyMap/admin/checkDel.mmy',
			type: 'post',
			datatype: 'text',
			data:{
				'txtno' : txtnos
			}
		});
		
	});
});