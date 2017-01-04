<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPEE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<script src="./js/login.js?ver=2"></script>
</head>
<body>
	<br>
	<h2>로그인</h2>
	<ul>
		<li>아이디 : <input type="text" maxlength="50" width="100" id="id"><br></li>
		<li>비밀번호 : <input type="password" maxlength="20" width="100" id="pass"><br>
		<input type="button" value="로그인하기" id="login">
		<a href="register.do"><input type="button" value="회원가입하기"></a></li>
	</ul>
</body>
</html>