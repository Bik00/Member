$(window).ready(function() {
	$("#check").click(function() {
		var id = $("#id").val();
		var query = {
				id:id
			};
		$.ajax({
			type:"post",
			url:"confirm.do",
			data:query,
			success:function(data) {
				ck = $(data).find("p").text();
				if(ck=="1") {
					alert("아이디 사용 가능")
				} else {
					alert("아이디 중복");
				}
			}
		});	
	});
	
	$("#register").click(function() {
		var stat = checkIt();
		var id = $("#id").val();
		var query = {
			id:id
		};
		if(stat == "true") {
			$.ajax({
				type:"post",
				url:"confirm.do",
				data:query,
				success:function(data) {
					var ck=$(data).find("p").text();
					if(ck=="1") {
						var id = $("#id").val();
						var passwd = $("#passwd").val();
						var phone = $("#phone").val();
						var query = {
							id:id,
							passwd:passwd,
							phone:phone
						};
						$.ajax({
							type:"post",
							url:"registerPro.do",
							data:query,
							success:function(data) {
								alert("회원 가입을 환영합니다.");
								window.location.href="index.do";
							}
						});	
					}
					else {
						alert("아이디 중복! 아이디 다시 입력해주세요.");
						$("#idtext").focus();
					}
				}
			});
		}
	});	
	
	function checkIt(){
		status = true;

		if(!$("#id").val()){ 
			alert("아이디를 입력하세요");
			$("#idtext").focus();
			status = false;
			return false; 
		}
		if(!$("#passwd").val()){
			alert("비밀번호를 입력하세요");
			$("#passwd").focus();
			status = false;
			return false;
		}
		
		if(!$("#phone").val()){
			alert("이름을 입력하세요");
			$("#phone").focus();
			status = false;
			return false;
		}
		return status;
	}
});