<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/YummyMap/js/jquery-3.5.0.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#frm').submit();
});
</script>
</head>

<body>
	<form method="post" action="/YummyMap/admin/login.mmy" id="frm">
		<input type="hidden" name="cnt" value="${CNT}">
	</form>
</body>
</html>