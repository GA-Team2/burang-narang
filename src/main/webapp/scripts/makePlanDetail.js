var planCount = [];
/* 일정 더하기 버튼을 눌렀을 때 해당 버튼을 구분할 class를 받아오기 위한 변수  */
var plusBtn;


/* + 버튼을 눌렀을 때 spot list를 modal로 띄운다
* 띄움과 동시에 어느 날짜의 일정 더하기 버튼을 눌렀는지 구분하기 위해
* btnClass에 해당 버튼의 구분 클래스(btn_day)를 입력한다.
* tripday가 3이면 btn_day3 
*/
function getSpotContainer(btn) {
	var url = "SpotList.jsp";
	/* tripday 구분하기 위해 버튼 객체 받아 옴 */
	plusBtn = btn;
	
	// spot container 모달 띄움
  	document.querySelector(".spot_black").classList.remove("hidden");
  	getSpotList("tf");
}


// spot container에서 장소 클릭 시 플랜에 추가되는 메서드
function setSpot(spotlist) {
  	/* get spot data  - 맨 아래의 getSpot 메서드 참고 */
	var spot = getSpot(spotlist);

  	/* tripday를 알기 위해  id에서 tripday를 잘라 온다 */
  	var tday = Number(plusBtn.getAttribute("id").substring(8));

  	/* plan sequence -> cookie로 tripday생성
	* plan이 처음 추가되면 쿠키를 세팅
	* tripday가 1인 경우 tripday1=1
	*/
  	if (getDay(tday) == null) setDay(tday, 1);
	// seq는 현재 추가되려하는 plan의 sequence
  	var seq = getDay(tday);
	/* plan list 생성 */
	var plan = makePlanList(spot, tday, seq);


	// trip day에 plan 요소 추가
  	var parent = plusBtn.parentNode;
	// plan의 부모인 parent의 자식 요소 button의 앞에 plan 삽입
  	parent.insertBefore(plan, plusBtn);
	// 지도 장소 검색
	placeSearch(spot.loc + " " + spot.name + " " + spot.pnum, tday);

	// 다음 플랜의 sequence 세팅
  	seq++;
  	document.cookie = "tripDay" + tday + "=" + seq;
	// modal 종료
	cancelSpot();
}


function makePlanList(spot, tday, seq) {
	/* plan 요소 추가 */
	/* div.plan_list */
	var plan = document.createElement("div");
	plan.classList.add("plan_list");
	plan.setAttribute("id", "p_list" + tday + "_" + seq);

	/* up-down button */
	var up_down = "<div class='up_down'>"
						+"<div class='up' onclick='moveUpPlan(this)'>&#9650;</div>"
						+ "<div class='plan_no' >" + seq + "</div>"
						+ "<div class='down' onclick='moveDownPlan(this)'>&#9660;</div>"
					+"</div>";

	/* plan main */
	/* i는 tripday seq는 sequence */
	var plan_main = "<div class='plan_main'>"
							+ "<img src='"+spot.photo+"'>"
							+ "<p>일정"+seq+"</p>"
							+ "<input type='text' value='" + seq + "' name='p_seq" + tday + "' hidden>"
							+ "<p>" + spot.name + "</p>"
							+ "<input type='text' value='" + spot.snum + "' name='s_snum" + tday + "' hidden>"
							+ "<input type='text' value='" + spot.name + "' name='s_name" + tday + "' hidden>"
							+ "<p>" + spot.type + "</p>"
							+ "<input type='text' value='" + spot.type + "' name='s_type" + tday + "' hidden>"
							+ "<p>" + spot.loc + "</p>"
							+ "<input type='text' value='" + spot.loc + "' name='s_loc" + tday + "' hidden>"
							+ "<input type='text' value='" + spot.pnum + "' name='s_pnum" + tday + "' hidden>"
							+ "<div class='remove_plan' onclick='removePlan(this)'>X</div>"
					+ "</div>";

	plan.innerHTML = up_down + plan_main;

	return plan;
}


/* 추가한 일정을 삭제하는 메소드 */
// re는 setspot에서 추가한 plan 요소의 삭제 버튼 164행
function removePlan(re) {
  	/* plan_main 
		플랜 추가시 추가되는 컨테이너 중 오른쪽의 spot 정보를 제공하는 박스
	*/
 	var plan = re.parentNode;
  	/* plan_list 
		플랜 추가시 추가 되는 컨테이너 전체
		plan_list 안에 up_down과 plan_main div가 존재
	*/
  	var parent = plan.parentNode;
	/* sequence */
  	var seq = Number(parent.children[0].children[1].innerText);
  	/* trip day 구하기 */
  	var tday = Number(parent.getAttribute("id").substring(6, i.indexOf("_", 2)));

  	// 지도 좌표 삭제
  	deletePlace(planCount.indexOf(tday + "") + (seq - 1));
  	planCount.splice(planCount.indexOf(tday + "") + (seq - 1), 1);

  	/* 삭제 하려는 플랜의 다음 플랜이(형제가) 있는 경우 
	* plan sequnce를 1씩 감소시켜 수정한다.
 	*/
  	while (true) {
  		var next = document.getElementById("p_list" + tday + "_" + (seq + 1));
    	if (next != null) {
    		next.children[0].children[1].innerHTML = seq;
      		next.children[1].children[1].innerHTML = "일정" + seq;
      		next.children[1].children[2].setAttribute("value", seq);
      		next.setAttribute("id", "p_list" + tday + "_" + seq);
      		seq++;
    	} else break;
  	}

  	// 플랜 sequence 수정 후 해당 tripday의 max sequence도 수정
  	setDay(tday, seq);
	// 해당 tripday의 모든 플랜이 삭제되었을 때 쿠키의 유효 기간 0으로 만들어 쿠키 삭제 -> 막아둠
	// 지도 api와 함께 수정 필요
	if(seq == 0) removeDay(tday);

	// plan_list 요소 삭제
  	parent.remove();
}

// spot의 정보 가져오는 메서드
function getSpot(spotlist) {
	/* children은 t내부의 태그 요소의 집합 */
	/* 각 spot의 div는 img와 spot 정보 들어간 div로 구성 */
	// spot = div
 	var spotDiv = spotlist.children[1];

  	var spot = {
    	snum: spotDiv.children[0].value,
    	name: spotDiv.children[1].innerText,
    	type: spotDiv.children[2].innerText,
    	pnum: spotDiv.children[3].innerText,
		loc: spotDiv.children[4].innerText,
		photo: spotlist.children[0].getAttribute("src")
  	};

  return spot;
}
