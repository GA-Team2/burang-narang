/* count 쿠키 세팅  
* 각 쿠키는 각 날짜의 플랜 수를 세고, 플랜에 번호를 붙이기 위해 사용한다.
* trip day가 2이고 max(plan sequence)가 5이면
* count2=6 인 식
* 각 날짜의 쿠키는 setSpot() 메서드가 처음 실행될때 생성된다
*/
function setDay(tday, seq) {
  	document.cookie = "tripDay" + tday + "=" + seq;
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