<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>환영합니다!</title>
</head>
<body>
	<br>
	<h1>로그인 성공!</h1>
	<p>${sessionScope.id}님 환영합니다.</p>
	<br>
	<a href="logout.do"><input type="button" value="로그아웃"></a>
	<br>
	<br>
	<a href="delete.do"><input type="button" value="회원 탈퇴" onclick="out()"></a>
	
	
	<script>
	function out() {
		alert("회원 탈퇴 하였습니다.");
	}
	</script>
</body>
</html>