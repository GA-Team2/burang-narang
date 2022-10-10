/* count 쿠키 세팅  
* 각 쿠키는 각 날짜의 플랜 수를 세고, 플랜에 번호를 붙이기 위해 사용한다.
* trip day가 2이고 max(plan sequence)가 5이면
* count2=6 인 식
* 각 날짜의 쿠키는 setSpot() 메서드가 처음 실행될때 생성된다
*/
function setCount(tday) {
  	document.cookie = "count" + tday + "=1";
}

function getCount(tday) {
	// count 쿠키의 값 반환
	var count = getCookie("count" + tday);
  	return count;
}

// 쿠키의 value 값을 가져옴
function getCookie(name) {
 	var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
 	return value ? value[2] : null;
}