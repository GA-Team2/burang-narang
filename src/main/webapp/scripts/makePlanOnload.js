// makeplan 페이지 시작 시 count 쿠키가 있다면 삭제
window.onload = function () {
	var i = 1;
  	while (true) {
    	// count i번째 쿠키가 존재한다면 해당 쿠키의 유효기간을 설정해 삭제
    	// js는 쿠키 삭제 메소드가 따로 존재하지 않음
    	if (getCount(i) != null) {
      		document.cookie = "count" + i + "=0; max-age=0";
      		i++;
    	} else break;
  	}
};