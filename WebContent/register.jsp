<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPEE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 화면</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<script src="./js/register.js?ver=3"></script>
</head>
<body>
	<br>
	<h2>회원가입 화면</h2>
	<ul>
		<li>아이디 : <input type="text" maxlength="50" width="100" id="id"><input type="button" value="중복확인" id="check"><br></li>
		<li>비밀번호 : <input type="password" maxlength="20" width="100" id="passwd"><br>
		<li>연락처 : <input type="text" maxlength="20" width="100" id="phone"><br>
		<input type="button" value="회원가입" id="register">
		<a href="index.do"><input type="button" value="돌아가기"></a></li>
	</ul>
</body>
</html>