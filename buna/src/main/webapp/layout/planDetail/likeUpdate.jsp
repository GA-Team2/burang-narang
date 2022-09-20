<%@page import="plan.PlanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int rownum = Integer.parseInt(request.getParameter("rownum"));

	PlanDAO dao = PlanDAO.getInstance();
	int re = dao.updateLikeNum(rownum);
	
	if (re==1) {
		out.print(re);
	} else {
		out.print(re);
	}
%>