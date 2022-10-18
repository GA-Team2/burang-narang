<%@page import="java.util.ArrayList"%>
<%@page import="org.ga2.buna.dao.tag.TagListDAO"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="org.ga2.buna.dao.PlanDetailDAO"%>
<%@page import="org.ga2.buna.dto.PlanDetail"%>
<%@page import="org.ga2.buna.dao.PlanInfoDAO"%>
<%@page import="org.ga2.buna.dto.PlanInfo"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  request.setCharacterEncoding("utf-8");

  int p_rownum = Integer.parseInt(request.getParameter("p_rownum"));
  int p_public = Integer.parseInt(request.getParameter("p_public"));

  String p_title = request.getParameter("p_title");
  String p_firstdate = request.getParameter("p_firstdate");
  String p_lastdate = request.getParameter("p_lastdate");
  String t_namelist = request.getParameter("t_namelist");

  /* String 형식을 timestap 형식으로 변환 */
  SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
  Date fd = fm.parse(p_firstdate);
  Date ld = fm.parse(p_lastdate);
  Timestamp firstdate = new Timestamp(fd.getTime());
  Timestamp lastdate = new Timestamp(ld.getTime());

  /* tag 갱신 */
  PlanInfoDAO plDAO = PlanInfoDAO.getInstance();
  /* 기존 planInfo의 태그 */
  PlanInfo pTag = plDAO.getPlanInfo(p_rownum);
  StringTokenizer st = null;
  TagListDAO tag = TagListDAO.getInstance();
  /* 기존 태그 받아와 hit 삭제  */
  if (pTag.getT_namelist() != null) { // 기존 태그가 없을 경우 null 처리
    st = new StringTokenizer(pTag.getT_namelist());
    while (st.hasMoreTokens()) {
      String tagname = st.nextToken();
      tag.updateTag(tagname, false); // 태그 hit 삭제
    }
  }

  /* planInfo 저장 */
  PlanInfo planInfo = new PlanInfo();
  planInfo.setP_rownum(p_rownum);
  planInfo.setP_title(p_title);
  planInfo.setP_firstdate(firstdate);
  planInfo.setP_lastdate(lastdate);
  planInfo.setT_namelist(t_namelist);
  planInfo.setP_public(p_public);

  /* planInfo update */
  plDAO.updatePlanInfo(planInfo);

  /* tag 갱신 */
  st = new StringTokenizer(t_namelist);
  while (st.hasMoreTokens()) {
    String tagname = st.nextToken();
    int re = tag.isTag(tagname);
    if (re == 1)
      tag.updateTag(tagname, true);
    else
      tag.insertTag(tagname);
  }

  /* day = tripday */
  int day = 0;
  while (true) {
    if (request.getParameterValues("day" + (day + 1)) != null)
      day++;
    else
      break;
  }

  PlanDetailDAO pd_dao = PlanDetailDAO.getInstance();
  /* 기존 planDetail 삭제 */
  int re = pd_dao.deletePlan(p_rownum);

  if (re == 1) { // re == 1 이면 plan detail 정상 삭제됨
    for (int j = 1; j <= day; j++) {
      String[] p_seq = request.getParameterValues("p_seq" + j);
      String[] s_snum = request.getParameterValues("s_snum" + j);
      String[] s_name = request.getParameterValues("s_name" + j);
      String[] s_type = request.getParameterValues("s_type" + j);
      String[] s_loc = request.getParameterValues("s_loc" + j);

      /* tripdate => 현재 여행 날짜 계산 (yyyy-MM-dd) */
      Calendar cal = Calendar.getInstance();
      cal.setTime(firstdate);
      Timestamp tripdate = firstdate;

      if (j == 1)
        tripdate = firstdate;
      else if (j > 1 && j < day) {
        cal.add(Calendar.DATE, (j - 1));
        tripdate = new Timestamp(cal.getTime().getTime());
      }
      else if (j == day)
        tripdate = lastdate;
      for (int x = 0; x < p_seq.length; x++) {
        PlanDetail plandetail = new PlanDetail();
        plandetail.setP_tripday(j);
        plandetail.setP_tripdate(tripdate);
        plandetail.setP_sequence(x + 1);
        plandetail.setS_serialnum(s_snum[x]);
        plandetail.setP_spotname(s_name[x]);
        pd_dao.insertPlan(plandetail, p_rownum);
      }
    }
  } else {
%>
    <script>
      alert("플랜 수정에 실패하였습니다.");
      location.href = "Index.jsp";
    </script>
<%
  }
  response.sendRedirect("PlanDetail.jsp?rownum=" + p_rownum);
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>플랜 수정 OK | 부랑나랑</title>
</head>
<body>

</body>
</html>