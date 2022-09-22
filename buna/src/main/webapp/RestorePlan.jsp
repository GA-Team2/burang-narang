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
		pi_dao.insertPlan(planInfo);
		
		// tag 저장 및 업데이트
		StringTokenizer st = new StringTokenizer(t_namelist);
		TagListDAO tag = TagListDAO.getInstance();
		while(st.hasMoreTokens()){
			String tagname = st.nextToken();
			int re = tag.isTag(tagname);
			if(re == 1) tag.updateTag(tagname);
			else tag.insertTag(tagname);
		}
		
		int i = 0;
		while(true){
			// day 개수 반환 1박 2일이면 i=2 반환
			if(request.getParameterValues("p_no"+(i+1)) != null) i++;
			else break;
		}
	%>
	<h1><%= p_title %></h1>
	<p>
		<%= p_firstdate %> ~ <%= p_lastdate %>
	</p>
	
	<table border="1">
		<tr>
			<td>여행 일차</td>
			<td>여행 날짜</td>
			<td>플랜 번호</td>
			<td>장소 넘버</td>
			<td>장소 이름</td>
			<td>장소 타입</td>
			<td>장소 위치</td>
		</tr>
		<%
		for(int j=1; j<=i; j++){
			// day1 -> day2 -> day+n...
			// day에 맞춰 input name에 숫자를 부여했음 => name+j로 어느 날짜의 계획인지 구분짓는다 
			String[] p_no = request.getParameterValues("p_no"+j);
			String[] s_snum = request.getParameterValues("s_snum"+j);
			String[] s_name = request.getParameterValues("s_name"+j);
			String[] s_type = request.getParameterValues("s_type"+j);
			String[] s_loc = request.getParameterValues("s_loc"+j);
			
			%>
				<tr>
					<td colspan="2">여행 날짜 : day<%= j %></td>
					<td colspan="5">
						<%
							// 현재 여행 날짜 계산 (yyyy-MM-dd)
							int sec = 600;		          
		                  	Calendar cal = Calendar.getInstance();
		                  	cal.setTime(firstdate);
		                  	
							Timestamp tripdate = firstdate;
							if(j==1) tripdate = firstdate;
							if(j>1 && j<i) {
								cal.add(Calendar.DATE, (j-1));
		              			tripdate = new Timestamp(cal.getTime().getTime());								
							}
							if(j==i) tripdate = lastdate;
						%>
						<%= tripdate %>
					</td>
				</tr>
			<%
			for(int x=0; x<p_no.length; x++){
				PlanDetail plandetail = new PlanDetail();
				PlanDetailDAO pd_dao = PlanDetailDAO.getInstance();
				
				plandetail.setP_tripday(j);
				plandetail.setP_tripdate(tripdate);
				plandetail.setP_sequence(x+1);
				plandetail.setS_serialnum(s_snum[x]);
				plandetail.setP_spotname(s_name[x]);
				
				pd_dao.insertPlan(plandetail, planInfo.getP_rownum());
				%>
				<tr>
					<td>Day <%= j %></td>
					<td><%= tripdate %></td>				
					<td><%= p_no[x] %></td>
					<td><%= s_snum[x] %></td>
					<td><%= s_name[x] %></td>
					<td><%= s_type[x] %></td>
					<td><%= s_loc[x] %></td>
				</tr>
				<%
			}
		}
		%>
	</table>
</body>
</html>