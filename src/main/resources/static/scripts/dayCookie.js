/* count 쿠키 세팅  
* 각 쿠키는 각 날짜의 플랜 수를 세고, 플랜에 번호를 붙이기 위해 사용한다.
* trip day가 2이고 max(plan sequence)가 5이면
* count2=6 인 식
* 
* @param 여행 일자, 플랜 순서
*/
function setDay(tday, seq) {
  	document.cookie = "tripDay" + tday + "=" + seq;
}

/*
* editPlan, copyPlan 페이지에서 plan detail에 맞춰 trip day 쿠키 생성
* */
function  setDays() {
	let tday = 1;

	while (document.getElementById("day_plan" + tday) != null) {
		const day = document.getElementById("day_plan" + tday);
		let seq = 1;

		for (let j = 1; j < day.children.length; j++) {
			if(document.getElementById("plan_list" + tday + "_" + j) != null) seq++;
		}
		setDay(tday, seq);
		tday++;
	}
}

function getDay(tday) {
	// count 쿠키의 값 반환
	const sequence = document.cookie.match("(^|;) ?" + "tripDay"+tday + "=([^;]*)(;|$)");
	return sequence ? sequence[2] : null;
}

/*
* 존재하는 모든 날짜 쿠키 삭제
*
* */
function resetDay() {
	let tripDay = 1;
	while (true) {
		// 플랜 쿠키 존재 시 삭제
		if (getDay(tripDay) != null) {
			removeDay(tripDay);
			tripDay++;
		} else break;
	}
}

/* 
* 해당 날짜의 쿠키 삭제
* 
* @param 여행 일자
* */
function removeDay(tday) {
	document.cookie = "tripDay" + tday + "=0; max-age=0";
}