$(window).ready(function() {
	$("#login").click(function() {
		var id = $("#id").val();
		var pass = $("#pass").val();
		var query = {
			id:id,
			pass:pass
		};
		$.ajax({
			type:"post",
			url:"login.do",
			data:query,
			success:function(data) {
				var ck=$(data).find("p").text();
				if(ck=="1") {
					alert("로그인에 성공하였습니다.");
					window.location.href="view.do";
				} else if (ck=="0"){
					alert("로그인 실패! 패스워드를 확인해주세요.");
				} else {
					alert("로그인 실패! 아이디를 확인해주세요.");
				}
			}
		});	
	});
});