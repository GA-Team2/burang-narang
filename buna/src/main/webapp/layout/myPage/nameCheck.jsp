<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nickname = request.getParameter("inputNickname");

	MemberDAO dao = MemberDAO.getInstance();
	int re = dao.checkNickname(nickname);
	
	if (re==1) {
		out.print(re);
	} else {
		out.print(re);
	}
%>