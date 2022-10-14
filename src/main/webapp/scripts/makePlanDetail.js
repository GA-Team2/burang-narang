const planCount = [];

/* 일정 더하기 버튼을 눌렀을 때 해당 버튼을 구분할 class를 받아오기 위한 변수  */
let addBtn;


/*
* 플랜 추가 버튼을 눌렀을 때 spot list를 modal로 띄운다.
* 
* @param 플랜 추가 버튼
* @return 스팟 컨테이너 띄움
*/
function getSpotContainer(btn) {
	const url = "SpotList.jsp";

	/* tripday 구분하기 위해 버튼 객체 받아 옴 */
	addBtn = btn;
	
	// spot container 모달 띄움
  	document.getElementById("spot_container").classList.remove("hidden");
  	return getSpotList("tf");
}

/*
* spot container에서 추가하고 싶은 spot을 클릭하면 플랜에 추가된다.
*
* @parma 장소 요소
* */
function setSpot(spotList) {
	const spot = getSpot(spotList);

  	/* tripday를 알기 위해  id에서 tripday를 잘라 온다 */
  	const tday = Number(addBtn.getAttribute("id").substring(8));

  	/* plan sequence -> cookie로 tripday생성
	* plan이 처음 추가되면 쿠키를 세팅
	* tripday가 1인 경우 tripday1=1
	*/
  	if (getDay(tday) == null) setDay(tday, 1);
	// seq는 현재 추가되려하는 plan의 sequence
  	let seq = getDay(tday);


	/* plan list 생성 */
	const plan = makePlanList(spot, tday, seq);

	// trip day에 plan 요소 추가
  	const parent = addBtn.parentNode;
	// plan의 부모인 parent의 자식 요소 button의 앞에 plan 삽입
  	parent.insertBefore(plan, addBtn);
	// 지도 장소 검색
	placeSearch(spot.sLoc + " " + spot.sName + " " + spot.sPnum, tday);

	// 다음 플랜의 sequence 세팅
  	seq++;
	setDay(tday, seq);

	// modal 종료
	cancelSpot();
}

/*
* 플랜 요소를 만드는 메서드
*
* @param 장소, 여행 일자, 플랜 순서
* @return 플랜 리스트 요소
* */
function makePlanList(spot, tday, seq) {
	/* div.plan_list */
	const planList = document.createElement("div");
	planList.classList.add("plan_list");
	planList.setAttribute("id", "plan_list" + tday + "_" + seq);

	/* up-down button */
	const upAndDown = "<div class='change_plan_container'>"
						+"<div class='change_up_button' onclick='changeUpPlan(this)'>&#9650;</div>"
						+ "<div class='plan_seq' >" + seq + "</div>"
						+ "<div class='change_down_button' onclick='changeDownPlan(this)'>&#9660;</div>"
					+"</div>";

	/* plan main */
	/* i는 tripday seq는 sequence */
	const planDetail = "<div class='plan_detail'>"
							+ "<img src='"+spot.sPhoto+"'>"
							+ "<p>일정"+seq+"</p>"
							+ "<input type='text' value='" + seq + "' name='p_seq" + tday
								+ "' id='p_seq" + tday + "_" + seq + "' hidden>"
							+ "<p>" + spot.sName + "</p>"
							+ "<input type='text' value='" + spot.sNum + "' name='s_snum" + tday
								+ "' id='s_snum" + tday + "_" + seq + "' hidden>"
							+ "<input type='text' value='" + spot.sName + "' name='s_name" + tday
								+ "' id='s_name" + tday + "_" + seq + "' hidden>"
							+ "<p>" + spot.sType + "</p>"
							+ "<input type='text' value='" + spot.sType + "' name='s_type" + tday
								+ "' id='s_type" + tday + "_" + seq + "' hidden>"
							+ "<p>" + spot.sLoc + "</p>"
							+ "<input type='text' value='" + spot.sLoc + "' name='s_loc" + tday
								+ "' id='s_loc" + tday + "_" + seq + "' hidden>"
							+ "<input type='text' value='" + spot.sPnum + "' name='s_pnum" + tday
								+ "' id='s_pnum" + tday + "_" + seq + "' hidden>"
							+ "<div class='remove_plan_button' onclick='removePlan(this)'>X</div>"
					+ "</div>";

	planList.innerHTML = upAndDown + planDetail;

	return planList;
}


/*
* spot 정보 가져오는 메서드
* 
* @param 장소정보가 담긴 요소
* @return 장소 정보를 담은 열거형
* */
function getSpot(spotList) {
	/* children은 t내부의 태그 요소의 집합 */
	/* 각 spot의 div는 img와 spot 정보 들어간 div로 구성 */
 	const spotDiv = spotList.children[1];

  	const spot = {
    	sNum: spotDiv.children[0].value,
    	sName: spotDiv.children[1].innerText,
    	sType: spotDiv.children[2].innerText,
    	sPnum: spotDiv.children[3].innerText,
		sLoc: spotDiv.children[4].innerText,
		sPhoto: spotList.children[0].getAttribute("src")
  	};

  return spot;
}
