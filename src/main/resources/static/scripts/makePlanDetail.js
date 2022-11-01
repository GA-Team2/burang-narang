/* 일정 더하기 버튼을 눌렀을 때 해당 버튼을 구분할 class를 받아오기 위한 변수  */
let addBtn;


/**
 * 플랜 추가 버튼을 눌렀을 때 spot list를 modal로 띄운다.
 *
 * @param 플랜 추가 버튼
 */
function getSpotContainer(btn) {
    /* tripday 구분하기 위해 버튼 객체 받아 옴 */
    addBtn = btn;

    toggleSpotArea();
    getSpotList("traffic");
}

/**
 * spot container에서 추가하고 싶은 spot을 클릭하면 플랜에 추가된다.
 *
 * @parma 장소 요소
 */
function setSpot(spotDetail) {
    const spot = getSpot(spotDetail);
    const tday = Number(addBtn.getAttribute("id").substring(8));

    if (getDay(tday) == null) setDay(tday, 1);
    let seq = getDay(tday);

    /* plan list 생성 */
    const plan = makePlanList(spot, tday, seq);
    const parent = addBtn.parentNode;
    parent.insertBefore(plan, addBtn);

    setSpotSequence(tday, seq);
    // 지도 장소 검색
    (async () => {
        try {
            const result = await addressSearch(spot.sLoc);
            setMapSpot(result, tday, seq);
            movePoint(result);
        } catch (e) {
            console.log(e);
        }
    })();

    seq++;
    setDay(tday, seq);
    toggleSpotArea();
}

/**
 * 플랜 요소를 만드는 메서드
 *
 * @param 장소, 여행 일자, 플랜 순서
 * @return 플랜 리스트 요소
 */
function makePlanList(spot, tday, seq) {
    /* div.plan_list */
    const planList = document.createElement("div");
    planList.classList.add("plan_list");
    planList.setAttribute("id", "plan_list" + tday + "_" + seq);

    /* up-down button */
    const upAndDown = `<div class='change_plan_container'>
                       <div class='change_up_button' onclick='changeUpPlan(this)'>&#9650;</div>
                       <div class='plan_seq' >${seq}</div>
                       <div class='change_down_button' onclick='changeDownPlan(this)'>&#9660;</div>
                       </div>`;

    /* plan main */
    const planDetail = `<div class='plan_detail'>
                        <img src='${spot.sPhoto}'>
                        <p>일정${seq}</p>
                        <input type='text' value='${seq}' id='p_seq${tday}_${seq}' hidden>
                        <p>${spot.sName}</p>
                        <input type='text' value='${spot.sNum}' id='s_snum${tday}_${seq}' hidden>
                        <input type='text' value='${spot.sName}' id='s_name${tday}_${seq}' hidden>
                        <p>${spot.sType}</p>
                        <input type='text' value='${spot.sType}' hidden>
                        <p>${spot.sLoc}</p>
                        <input type='text' value='${spot.sLoc}' id='s_loc${tday}_${seq}' hidden>
                        <div class='remove_plan_button' onclick='removePlan(this)'>X</div>
                        </div>`;

    planList.innerHTML = upAndDown + planDetail;
    return planList;
}


/**
 * spot 정보 가져오는 메서드
 *
 * @param 장소 정보가 담긴 요소
 * @return 장소 정보를 담은 변수 반환
 */
function getSpot(spotData) {
    const spotDiv = spotData.children[1];

    const spot = {
        sNum: spotDiv.children[0].value,
        sName: spotDiv.children[1].innerText,
        sType: spotDiv.children[2].innerText,
        sPnum: spotDiv.children[3].innerText,
        sLoc: spotDiv.children[4].innerText,
        sPhoto: spotData.children[0].getAttribute("src")
    };
    return spot;
}