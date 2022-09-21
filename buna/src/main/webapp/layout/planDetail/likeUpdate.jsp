<%@page import="plan.PlanDAO"%>
<%@page import="like.LikeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int rownum = Integer.parseInt(request.getParameter("rownum"));
	String nick = (String) session.getAttribute("nick_s");
	
	LikeDAO dao = LikeDAO.getInstance();
	int checkLike = dao.checkLike(rownum, nick);
	
	if (checkLike==1) {
		
	}
%>