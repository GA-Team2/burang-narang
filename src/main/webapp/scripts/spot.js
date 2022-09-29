function getSpotLoad(spot){
	
	$('#list_load').load('SpotList.jsp?spot='+spot);
	
	if(spot == 'tf'){
		document.getElementById('tfTap').classList.add("spotTab_active");
		document.getElementById('acTap').classList.remove("spotTab_active");
		document.getElementById('reTap').classList.remove("spotTab_active");
		document.getElementById('evTap').classList.remove("spotTab_active");
	} else if(spot == 'ac'){
		document.getElementById('tfTap').classList.remove("spotTab_active");
		document.getElementById('acTap').classList.add("spotTab_active");
		document.getElementById('reTap').classList.remove("spotTab_active");
		document.getElementById('evTap').classList.remove("spotTab_active");
	} else if(spot == 're'){
		document.getElementById('tfTap').classList.remove("spotTab_active");
		document.getElementById('acTap').classList.remove("spotTab_active");
		document.getElementById('reTap').classList.add("spotTab_active");
		document.getElementById('evTap').classList.remove("spotTab_active");
	} else if(spot == 'ev'){
		document.getElementById('tfTap').classList.remove("spotTab_active");
		document.getElementById('acTap').classList.remove("spotTab_active");
		document.getElementById('reTap').classList.remove("spotTab_active");
		document.getElementById('evTap').classList.add("spotTab_active");
	}
}

function cancelSpot() {
	document.querySelector(".spot_black").classList.add("hidden");
}

function searchSpot() {
	var search = document.getElementById('searchSpot').value;
	$('#list_load').load('SearchSpot.jsp?search='+search);
}