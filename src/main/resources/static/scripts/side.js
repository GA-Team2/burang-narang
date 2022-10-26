/* 사이드 바 이동 */
$(document).ready(function () {
    // side x좌표 이동 
    $('#side_button').click(function () {
        // r 값 : 오른쪽에서 x 좌표 위치
        // 초기값 0
        var r = $('#side_bar').css('right');
        var w = '-' + $('#side_bar').css('width');
        if (r == '0px') {
            $('#side_bar').animate({ 'right': w }, 500);
            // 바뀐 좌표 재 대입
            r = $('#side_bar').css('right');
         document.getElementById("side_button").innerHTML = "&#9664;";
        } else {
            $('#side_bar').animate({ 'right': 0 }, 500);
            // 바뀐 좌표 재 대입
            r = $('#side_bar').css('right');
         	document.getElementById("side_button").innerHTML = "&#9654;";
        }
    });
});

/*
* 날짜 탭 클릭 시 해당 날짜의 플랜으로 스크롤 이동
*
* @param 날짜 탭
* */
function tabScroll(dayTab){
	const day = Number(dayTab.getAttribute("id").substring(3));

	changeTabClass(day);

	let height = 0;
	/* 이동하려는 탭의 앞의 플랜들의 길이의 합 */
	for(var j = (day - 1); j > 0; j--){
		const conHeight = document.getElementById("day_plan" + j).scrollHeight;
		height += conHeight;
	}

	planDetail.scrollTop = height;
}

/*
* 날짜 탭 active 클래스 조정 - css 삭제, 더하기
*
* @param 여행 날짜
*  */
function changeTabClass(day) {
	let tripDay = 1;

	while(document.getElementById("day" + tripDay) != null){
		const dayTab = document.getElementById("day" + tripDay);

		if(tripDay != day) dayTab.classList.remove("active_day");
		else dayTab.classList.add("active_day");

		tripDay++;
	}
}

/* 지도 세로 스크롤 방지 */
$("html, body").css({ overflow: "hidden", height: "100%" });
$("#element").on("scroll touchmove mousewheel", function (event) {
	event.preventDefault();
	event.stopPropagation();
	return false;
});

/* 사이드 바 움직임에 따라 지도 크기 조정 */
document.getElementById("side_button").addEventListener("click", function () {
	var mapContainer = document.getElementById("map");
	mapContainer.style.width = "100%";
	map.relayout();
});