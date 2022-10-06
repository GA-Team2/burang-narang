function getSpotLoad(spot){
	
	$('#list_load').load('SpotList.jsp?spot=' + spot);
	
	if(spot == 'tf'){
		// spot container 활성화 시 스크롤 및 탭 초기화
		document.getElementById('tfTap').classList.add("spotTab_active");
		document.getElementById('acTap').classList.remove("spotTab_active");
		document.getElementById('reTap').classList.remove("spotTab_active");
		document.getElementById('evTap').classList.remove("spotTab_active");
		document.getElementById('list_load').scrollTop = 0;
	} else if(spot == 'ac'){
		document.getElementById('tfTap').classList.remove("spotTab_active");
		document.getElementById('acTap').classList.add("spotTab_active");
		document.getElementById('reTap').classList.remove("spotTab_active");
		document.getElementById('evTap').classList.remove("spotTab_active");
		document.getElementById('list_load').scrollTop = 0;
	} else if(spot == 're'){
		document.getElementById('tfTap').classList.remove("spotTab_active");
		document.getElementById('acTap').classList.remove("spotTab_active");
		document.getElementById('reTap').classList.add("spotTab_active");
		document.getElementById('evTap').classList.remove("spotTab_active");
		document.getElementById('list_load').scrollTop = 0;
	} else if(spot == 'ev'){
		document.getElementById('tfTap').classList.remove("spotTab_active");
		document.getElementById('acTap').classList.remove("spotTab_active");
		document.getElementById('reTap').classList.remove("spotTab_active");
		document.getElementById('evTap').classList.add("spotTab_active");
		document.getElementById('list_load').scrollTop = 0;
	}
}

/* spotcontainer 종료 메서드 */
function cancelSpot() {
	document.querySelector(".spot_black").classList.add("hidden");
	document.getElementById('tfTap').classList.add("spotTab_active");
	document.getElementById('acTap').classList.remove("spotTab_active");
	document.getElementById('reTap').classList.remove("spotTab_active");
	document.getElementById('evTap').classList.remove("spotTab_active");
}

/* searchspot 띄우는 메서드 */
function searchSpot() {
	var search = document.getElementById('searchSpot').value;
	$('#list_load').load('SearchSpot.jsp?search=' + search);
}