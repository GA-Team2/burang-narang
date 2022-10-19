<%@page import="java.net.URLDecoder"%>
<%@page import="org.ga2.buna.dao.tag.TagListDAO"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="org.ga2.buna.dao.plandetail.PlanDetailDAO"%>
<%@page import="org.ga2.buna.dto.PlanDetail"%>
<%@page import="org.ga2.buna.dao.planinfo.PlanInfoDAO"%>
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
%>
<html>
<head>
<meta charset="UTF-8" />
<title>플랜 저장 | 부랑나랑</title>
</head>

<body>
<%
	String p_title = request.getParameter("p_title");
	String p_firstdate = request.getParameter("p_firstdate");
	String p_lastdate = request.getParameter("p_lastdate");
	String t_namelist = request.getParameter("t_namelist");

	/* 세션값 받아오기 */
	String nickSession = (String) session.getAttribute("nick_s");
	String m_nickname = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	int p_public = Integer.parseInt(request.getParameter("p_public"));

	/* String 형식을 timestap 형식으로 변환 */
	SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
	Date fd = fm.parse(p_firstdate);
	Date ld = fm.parse(p_lastdate);
	Timestamp firstdate = new Timestamp(fd.getTime());
	Timestamp lastdate = new Timestamp(ld.getTime());

	/* planInfo 객체 */
	PlanInfo planInfo = new PlanInfo();
	planInfo.setM_nickname(m_nickname);
	planInfo.setP_title(p_title);
	planInfo.setP_firstdate(firstdate);
	planInfo.setP_lastdate(lastdate);
	planInfo.setT_namelist(t_namelist);
	/* 플랜 작성 일자 */
	planInfo.setP_regdate(new Timestamp(System.currentTimeMillis()));
	planInfo.setP_public(p_public);

	/* planInfo 저장 */
	PlanInfoDAO pi_dao = PlanInfoDAO.getInstance();
	int num = pi_dao.insertPlan(planInfo); // num이 -1이면 추가 실패 아니라면 rownum 반환
	if (num == -1) {
%>
		<script>
			alert("플랜 작성에 실패하였습니다.");
			location.href = "Index.jsp";
		</script>
<%
	}

	/* tag 저장 및 업데이트 */
	StringTokenizer st = new StringTokenizer(t_namelist);
	TagListDAO tag = TagListDAO.getInstance();
	while (st.hasMoreTokens()) {
		String tagname = st.nextToken();
		int re = tag.isTag(tagname);
		if (re == 1)
			tag.updateTag(tagname, true);
		else
			tag.insertTag(tagname);
	}

	/* tripday 반환  */
	int day = 0;
	while (true) { // day 개수 반환 1박 2일이면 i=2 반환
		if (request.getParameterValues("day" + (day + 1)) != null)
			day++;
		else
			break;
	}

	/* tripday의 plan을 배열로 반환 */
	for (int i = 1; i <= day; i++) { // day1 -> day2 -> day+n...
		/* day에 맞춰 input name에 숫자를 부여했음 => name+j로 어느 날짜의 계획인지 구분짓는다 */
		String[] p_seq = request.getParameterValues("p_seq" + i);
		// if(p_seq == null) break; //해당 날짜에 일정이 없을때, null => restore.js로 유효성 검사
		String[] s_snum = request.getParameterValues("s_snum" + i);
		String[] s_name = request.getParameterValues("s_name" + i);

		/* 현재 여행 날짜 계산 (yyyy-MM-dd) */
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstdate);
		Timestamp tripdate = firstdate;
		/* 첫째날이면 firstdate, 마지막 날이면 lastdate */
		if (i == 1)
			tripdate = firstdate;
		else if (i > 1 && i < day) {
			cal.add(Calendar.DATE, (i - 1)); // 둘째 날일 경우 firstdate+1day
			tripdate = new Timestamp(cal.getTime().getTime());
		} else if (i == day)
			tripdate = lastdate;

		for (int x = 0; x < p_seq.length; x++) {
			PlanDetail plandetail = new PlanDetail();
			PlanDetailDAO pd_dao = PlanDetailDAO.getInstance();
			plandetail.setP_tripday(i);
			plandetail.setP_tripdate(tripdate);
			plandetail.setP_sequence(x + 1);
			plandetail.setS_serialnum(s_snum[x]);
			plandetail.setP_spotname(s_name[x]);
			pd_dao.insertPlan(plandetail, num);
		}
	}
	/* 저장 성공 시 planDetail 페이지로 이동 */
	response.sendRedirect("PlanDetail.jsp?rownum=" + planInfo.getP_rownum());
	%>
</body>
</html>