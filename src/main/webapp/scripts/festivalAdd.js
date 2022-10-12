
		// 내 플랜에 추가 버튼을 누르면 
		function click_on() {

			var check = '${nick_s}';
			if (check == 'null' || check == "") {
				alert("로그인을 하셔야합니다")

				location.href = "login.jsp";

				return false;
			}
		
			return confirm("플랜 작성페이지로 이동하시겠습니까?");
		}

	
	// // 내 플랜에 추가 버튼을 누르면
	// 	function click_on() {
	// 		// 세션값(아이디) 여부 체크 
	// 		// var check = '${nick_s}';
	// 		var check = "";

	// 		if ($("#loginId").text()==null || $("#loginId").text()=="") {

	// 			alert("로그인을 하셔야합니다")
	// 			location.href = "login.jsp";

	// 			return false;
	// 		}
	// 		return confirm("플랜 작성페이지로 이동하시겠습니까?");
	// 	}
	
		// 내 플랜에 추가 버튼을 누르면
		// function click_on() {
		// 	// 세션값(아이디) 여부 체크 
		// 	// var check = '${nick_s}';
		// 	var check = localStorage.getItem("nick_s");
		// 	console.log(check);
		// 	if (check == null || check == "") {
		// 		alert("로그인을 하셔야합니다")
		// 		// 세션값(아이디)이 없을경우 로그인 페이지로 보냄 
		// 		location.href = "login.jsp";
		// 		// a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함 
		// 		return false;
		// 	}
		// 	// 세션값(아이디)이 존재하면 a태그로 true반환 MakePlan 페이지로 이동
		// 	return confirm("플랜 작성페이지로 이동하시겠습니까?");
		// }
	