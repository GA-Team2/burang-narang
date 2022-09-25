<%@page import="org.ga2.buna.dao.TagListDAO"%>
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
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>플랜 저장(임시) | 부랑나랑</title>
</head>
<body>
	<%
		String p_title = request.getParameter("p_title");
		String p_firstdate = request.getParameter("p_firstdate");
		String p_lastdate = request.getParameter("p_lastdate");
		String t_namelist = request.getParameter("t_namelist");
		int p_public = Integer.parseInt(request.getParameter("p_public"));
		// sql에 대입하기 전에 String 형식을 timestap 형식으로 변환
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date fd = fm.parse(p_firstdate);
		Date ld = fm.parse(p_lastdate);
		Timestamp firstdate = new Timestamp(fd.getTime());
		Timestamp lastdate = new Timestamp(ld.getTime());
		
		
		// planInfo 저장
		PlanInfo planInfo = new PlanInfo();
		// 닉네임 세션으로 받아오기
		planInfo.setM_nickname("닉네임 임시");
		planInfo.setP_title(p_title);
		planInfo.setP_firstdate(firstdate);
		planInfo.setP_lastdate(lastdate);
		planInfo.setT_namelist(t_namelist);
		// 작성 일자
		planInfo.setP_regdate(new Timestamp(System.currentTimeMillis()));
		planInfo.setP_public(p_public);
		// planInfo 저장
		PlanInfoDAO pi_dao = PlanInfoDAO.getInstance();
		int num = pi_dao.insertPlan(planInfo);
		
		// num이 -1이면 추가 실패
		// 아니라면 rownum 반환
		if(num == -1) {
			%>
				<script>
					alert("플랜 작성에 실패하였습니다.");
					location.href="index.jsp";
				</script>
			<%
		}
		
		// tag 저장 및 업데이트
		StringTokenizer st = new StringTokenizer(t_namelist);
		TagListDAO tag = TagListDAO.getInstance();
		while(st.hasMoreTokens()){
			String tagname = st.nextToken();
			int re = tag.isTag(tagname);
			if(re == 1) tag.updateTag(tagname, true);
			else tag.insertTag(tagname);
		}
		
		int day = 0;
		while(true){
			// day 개수 반환 1박 2일이면 i=2 반환
			if(request.getParameterValues("day"+(day+1)) != null) day++;
			else break;
		}
		
		for(int i=1; i<=day; i++){
			// day1 -> day2 -> day+n...
			// day에 맞춰 input name에 숫자를 부여했음 => name+j로 어느 날짜의 계획인지 구분짓는다
			String[] p_seq = request.getParameterValues("p_seq"+i);
			// 해당 날짜에 일정이 없을때, null
			if(p_seq == null) break;
			String[] s_snum = request.getParameterValues("s_snum"+i);
			String[] s_name = request.getParameterValues("s_name"+i);

			// 현재 여행 날짜 계산 (yyyy-MM-dd)       
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(firstdate);
		                  	
			Timestamp tripdate = firstdate;
			if(i==1) tripdate = firstdate;
			if(i>1 && i<day) {
				cal.add(Calendar.DATE, (i-1));
		        tripdate = new Timestamp(cal.getTime().getTime());								
			}
			if(i==day) tripdate = lastdate;
	
			for(int x=0; x<p_seq.length; x++){
				PlanDetail plandetail = new PlanDetail();
				PlanDetailDAO pd_dao = PlanDetailDAO.getInstance();
				
				plandetail.setP_tripday(i);
				plandetail.setP_tripdate(tripdate);
				plandetail.setP_sequence(x+1);
				plandetail.setS_serialnum(s_snum[x]);
				plandetail.setP_spotname(s_name[x]);
				
				pd_dao.insertPlan(plandetail, num);
			}
		}
		response.sendRedirect("index.jsp");
		%>
</body>
</html>