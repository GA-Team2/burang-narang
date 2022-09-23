function getSpotLoad(spot){
	var ele = document.getElementById("jsp_tag");
	console.log(ele);
	
	$('#list_load').load('SpotList.jsp?spot='+spot);
}

function cancelSpot() {
	document.querySelector(".spot_black").classList.add("hidden");
}