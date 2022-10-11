/* count 쿠키 세팅  
* 각 쿠키는 각 날짜의 플랜 수를 세고, 플랜에 번호를 붙이기 위해 사용한다.
* trip day가 2이고 max(plan sequence)가 5이면
* count2=6 인 식
* 각 날짜의 쿠키는 setSpot() 메서드가 처음 실행될때 생성된다
*/
function setDay(tday, seq) {
  	document.cookie = "tripDay" + tday + "=" + seq;
}

function  setDays() {
	// tday = tripday
	var tday = 1;

	// 플랜 쿠키 삭제 후 수정하려는 플랜의 tripday와 plansequence에 맞춰 쿠키 생성
	while (document.querySelector(".day_plan" + tday) != null) {
		var day = document.querySelector(".day_plan" + tday);
		var seq = 1;

		// day의 children은 plan_list planlist의 개수 만큼 쿠키 세팅
		// day의 children[0]과 [1]은 planlist가 아니므로 j=2부터 시작
		for (var j = 2; j < day.children.length; j++) {
			// day의 자식에는 더하기 버튼도 있으므로 tagname="DIV"로 요소 구분
			var child = day.children[j].tagName;
			if (child == "DIV") count++;
		}
		setDay(tday, seq);
		tday++;
	}
}

function getDay(tday) {
	// count 쿠키의 값 반환
	var sequence = document.cookie.match("(^|;) ?" + "tripDay"+tday + "=([^;]*)(;|$)");
	return sequence ? sequence[2] : null;
}

/* 존재하는 모든 날짜 쿠키 삭제 */
function resetDay() {
	/* tday = tripday */
	var tday = 1;

	while (true) {
		// 플랜 쿠키 존재 시 삭제
		if (getDay(tday) != null) {
			removeDay(tday);
			tday++;
		} else break;
	}
}

/* 해당 날짜의 쿠키 삭제 */
function removeDay(tday) {
	document.cookie = "tripDay" + tday + "=0; max-age=0";
}