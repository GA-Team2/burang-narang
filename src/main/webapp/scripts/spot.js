var tf = document.getElementById('tfTap');
var ac = document.getElementById('acTap');
var re = document.getElementById('reTap');
var ev = document.getElementById('evTap');
var sList = document.getElementById('list_load');


function getSpotList(spot){
	
	$('#list_load').load('SpotList.jsp?spot=' + spot);
	
	if (spot == 'tf') {
		// spot container 활성화 시 스크롤 및 탭 초기화
		resetSpotCon();
		tf.classList.add("spotTab_active");
	} else if (spot == 'ac') {
		resetSpotCon();
		ac.classList.add("spotTab_active");
	} else if (spot == 're') {
		resetSpotCon();
		re.classList.add("spotTab_active");
	} else if (spot == 'ev') {
		resetSpotCon();
		ev.classList.add("spotTab_active");
	}
}


/* spotcontainer 종료 메서드 */
function cancelSpot() {
	document.querySelector(".spot_black").classList.add("hidden");
}

/* searchspot 띄우는 메서드 */
function searchSpot() {
	var search = document.getElementById('searchSpot').value;
	$('#list_load').load('SearchSpot.jsp?search=' + search);
}

function resetSpotCon() {
	tf.classList.remove("spotTab_active");
	ac.classList.remove("spotTab_active");
	re.classList.remove("spotTab_active");
	ev.classList.remove("spotTab_active");
	/* 스크롤 초기화 */
	sList.scrollTop = 0;
}