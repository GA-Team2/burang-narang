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

//day tab 클릭시 스크롤
function tabScroll(tab){
	var day = tab.getAttribute("id").substring(3);
	day = Number(day);

	var tday = 1;
	while(document.getElementById("day" + tday) != null){
		var element = document.getElementById("day" + tday);
		if(tday != day){
			if(element.classList.contains("active_day")) element.classList.remove("active_day");
		}else {
			if(!element.classList.contains("active_day")) element.classList.add("active_day");
		}
		tday++;
	}

	var height = 0;
	/* 이동하려는 탭의 앞의 플랜들의 길이의 합 */
	for(var j = (day - 1); j > 0; j--){
		var conHeight = document.querySelector(".day_plan" + j);
		conHeight = conHeight.scrollHeight;
		height += conHeight;
	}

	var con = document.forms.makePlanForm;
	// edit 폼인 경우
	if(con == null) con = document.forms.editPlanForm;
	con.scrollTop = height;
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
	var mapContainer = document.getElementById("map_area");
	mapContainer.style.width = "100%";
	map.relayout();
});