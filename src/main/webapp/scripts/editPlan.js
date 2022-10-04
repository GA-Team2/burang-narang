var planCount = [];

$("html, body").css({ overflow: "hidden", height: "100%" });
$("#element").on("scroll touchmove mousewheel", function (event) {
  event.preventDefault();
  event.stopPropagation();
  return false;
});

/* count 쿠키 세팅  
	count는 day당 하나씩 부여 됨 <div class="day_plan"> 개수 만큼
	예를 들어 1박 2일 이면 2일치의 일정을 짜니까
	count는 count1, count2의 두개의 쿠키가 생성됨
	각 쿠키는 해당 일자의 일정 횟수를 센다
*/
function setCount(i) {
  document.cookie = "count" + i + "=1";
}
function getCount(i) {
  // count 쿠키의 값 반환
  var count = getCookie("count" + i);
  return count;
}
// 쿠키의 value 값을 가져옴
function getCookie(name) {
  var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
  return value ? value[2] : null;
}

/* 일정 더하기 버튼을 눌렀을 때 해당 버튼을 구분할 class를 받아오기 위한 변수  */
var btnClass;

// + 버튼을 눌렀을 때 spot list를 modal로 띄움
function getSpotList(btn) {
  var url = "SpotList.jsp";
  // 누른 버튼 객체를 대입한 후, 해당 객체를 구분하는 클래스를 받아 옴
  btnClass = btn.classList;
  // 두번째 클래스 받아 옴
  btnClass = btnClass[1];
  console.log(btnClass);

  document.querySelector(".spot_black").classList.remove("hidden");
  $("#list_load").load("SpotList.jsp");
}

// editPlan 시작 시 plan_sequence 받아옴
window.onload = function () {
  var i = 1;
  while (true) {
    // count i번째 쿠키가 존재한다면 해당 쿠키의 유효기간을 설정해 삭제
    // js는 쿠키 삭제 메소드가 따로 존재하지 않음
    if (getCount(i) != null) {
      document.cookie = "count" + i + "=0; max-age=0";
      i++;
    } else {
      break;
    }
  }
  i = 1;
  while (document.querySelector(".day_plan" + i) != null) {
    var day = document.querySelector(".day_plan" + i);
    var count = 1;

    for (var j = 2; j < day.children.length; j++) {
      var child = day.children[j].tagName;
      if (child == "DIV") {
        count++;
        document.cookie = "count" + i + "=" + count;
      }
    }
    i++;
  }

  // 제목 수정
  var context = document.querySelector(".modal_context");
  context.children[0].innerHTML = "플랜 수정";
  // 버튼 수정
  var add = document.querySelector(".modal_add");
  add.setAttribute("value", "수정");
  add.setAttribute("onclick", "editCheck()");

  var cancel = document.querySelector(".modal_cancel");
  cancel.setAttribute("value", "취소");
  var url = window.document.location.href;
  var rownum = url.substring(url.indexOf("=") + 1);
  rownum = rownum.substring(0, 1);
  // plan detail.jsp
  cancel.setAttribute(
    "onclick",
    "location.href='planDetail.jsp?rownum=" + rownum + "'"
  );

  // popular copy plan 이면 pop이 존재하면
  var and = url.substring(url.indexOf("pop="));
  and = and.substring(and.indexOf("=") + 1);
  if (and != null) {
    if (and == "true") {
      context.children[0].innerHTML = "새 플랜 작성";
      add.setAttribute("value", "추가");
      cancel.setAttribute(
        "onclick",
        "location.href='planDetail.jsp?rownum=" + rownum + "&pop=" + and + "'"
      );
    }
  }
  console.log(and);

  // schedule에 세팅
  var form = document.scheduleForm;
  var title = document.editPlanForm.p_title.value;
  var firstdate = document.editPlanForm.p_firstdate.value;
  var lastdate = document.editPlanForm.p_lastdate.value;
  var tname = document.editPlanForm.t_namelist.value;

  form.title.value = title;
  form.firstdate.value = firstdate;
  form.lastdate.value = lastdate;
  form.tag_value = tname;

  var tagArea = document.getElementById("tag_area");
  var tag = tname.split(" ");

  // 공백 하나 더 인식 되서 length-1
  for (var j = 0; j < tag.length - 1; j++) {
    var addTag = document.createElement("span");
    var tagId = tag[j] + "_in";
    document.getElementById("tag_value").value += tag[j] + " ";
    addTag.id = tagId;
    addTag.className = "highlight";
    addTag.innerText = tag[j];
    addTag.onclick = function () {
      removeTag(tagId);
    };
    tagArea.appendChild(addTag);
  }

  // day
  var day = 0;
  while (true) {
    var day_plan = document.querySelector(".day_plan" + (day + 1));
    if (day_plan != null) day++;
    else break;
  }

  // seq 초기화
  var seq = [];
  for (var i = 0; i < day; i++) {
    seq[i] = 0;
  }

  for (var i = 0; i < day; i++) {
    // day = i + 1
    while (true) {
      var plan_seq = document.getElementById(
        "p_list" + (i + 1) + "_" + (seq[i] + 1)
      );
      if (plan_seq != null) seq[i] += 1;
      else break;
    }
  }

  for (var i = 1; i <= day; i++) {
    for (var j = 1; j <= seq[i - 1]; j++) {
      var name = document.getElementById("s_name" + i + "_" + j).value;
      var loc = document.getElementById("s_loc" + i + "_" + j).value;
      var pnum = document.getElementById("s_pnum" + i + "_" + j).value;
      placeSearch(loc + " " + name + " " + pnum, i);
    }
  }
  console.log(planCount);
};

function setSpot(t) {
  /* get spot data */
  var spot = {};
  spot = getSpot(t);

  var button = document.querySelector("." + btnClass);
  /* 몇 번째 날인지 */
  var i = btnClass.substring(7);

  /* n일차를 갯수로 */
  //   planCount.push(Number(i));
  //   planCount.sort();
  //   console.log(planCount);

  /* plan no -> cookie로 count생성 */
  if (getCount(i) == null) setCount(i);
  var cnt = getCount(i);

  /* plan 요소 추가 - 요소 구성은 git 참고 */
  /* div.plan_list */
  var plan = document.createElement("div");
  plan.classList.add("plan_list");
  plan.setAttribute("id", "p_list" + i + "_" + cnt);

  placeSearch(spot.loc + " " + spot.name + " " + spot.pnum, i);
  console.log(spot.loc);
  console.log(spot.name);
  console.log(spot.pnum);
  /* up-down button */
  var up_down =
    "<div class='up_down'>" +
    "<div class='up' onclick='goUp(this)'>&#9650;</div>" +
    "<div class='plan_no' >" +
    cnt +
    "</div>" +
    "<div class='down' onclick='goDown(this)'>&#9660;</div>" +
    "</div>";

  /* plan main */
  var plan_main =
    "<div class='plan_main'>" +
   "<img src='"+spot.photo+"'>" + 
    "<p>일정" +
    cnt +
    "</p>" +
    "<input type='text' value='" +
    cnt +
    "' name='p_seq" +
    i +
    "' hidden>" +
    "<p>" +
    spot.name +
    "</p>" +
    "<input type='text' value='" +
    spot.snum +
    "' name='s_snum" +
    i +
    "' hidden>" +
    "<input type='text' value='" +
    spot.name +
    "' name='s_name" +
    i +
    "' hidden>" +
    "<p>" +
    spot.type +
    "</p>" +
    "<input type='text' value='" +
    spot.type +
    "' name='s_type" +
    i +
    "' hidden>" +
    "<p>" +
    spot.loc +
    "</p>" +
    "<input type='text' value='" +
    spot.loc +
    "' name='s_loc" +
    i +
    "' hidden>" +
    "<input type='text' value='" +
    spot.pnum +
    "' name='s_pnum" +
    i +
    "' hidden>" +
    "<div class='remove_plan' onclick='removePlan(this)'>X</div>" +
    "</div>";

  plan.innerHTML = up_down + plan_main;

  document.querySelector(".spot_black").classList.add("hidden");

  var parent = document.querySelector(".day_plan" + i);
  parent.insertBefore(plan, button);

  cnt++;
  document.cookie = "count" + i + "=" + cnt;
}

/* 추가한 일정을 삭제하는 메소드 */
// re는 x 버튼
function removePlan(re) {
  /* plan_main */
  var plan = re.parentNode;
  /* plan_list 
		id = p_list + i(day) +_+ seq(no)
	*/
  var parent = plan.parentNode;
  var p_seq = parent.children[0].children[1];
  var seq = p_seq.innerText;
  // int가 제대로 인식이 안 될때가 있어서 파싱
  seq = Number(seq);

  /* i 구하기 */
  var i = parent.getAttribute("id");
  console.log(i);
  i = i.substring(6, i.indexOf("_", 2));
  i = Number(i);

  //	삭제 하려는 플랜의 다음 플랜이(형제가) 있는 경우
  while (true) {
    var next = document.getElementById("p_list" + i + "_" + (seq + 1));
    if (next != null) {
      next.children[0].children[1].innerHTML = seq;
      next.children[1].children[1].innerHTML = "일정" + seq;
      next.children[1].children[2].setAttribute("value", seq);
      next.setAttribute("id", "p_list" + i + "_" + seq);
      seq++;
    } else break;
  }

  // 플랜 번호 수정 후 해당 day의 플랜 개수를 세는 count 쿠키 수정
  var cnt = getCount(i);
  cnt = Number(cnt);
  cnt--;
  document.cookie = "count" + i + "=" + cnt;
if(cnt == 0) document.cookie = "count"+i+"=0; max-age=0";

  parent.remove();
}

// spot의 정보 가져오는 메서드
function getSpot(t) {
  /* get data */
  /* children은 t내부의 태그 요소의 집합 */
  var photo = t.children[0].getAttribute("src");
  var x = t.children[1];
  var snum = x.children[0].value;
  var sname = x.children[1].innerText;
  // event의 경우 venue
  var stype = x.children[2].innerText;
  var pnum = x.children[3].innerText;
  var sloc = x.children[4].innerText;
  var spot = {
    snum: snum,
    name: sname,
    type: stype,
    pnum: pnum,
    loc: sloc,
		photo: photo
  };

  return spot;
}
