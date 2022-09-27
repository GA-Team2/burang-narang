<%@page import="java.net.URLDecoder"%>
<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="plan.PlanDAO"%>
<%@page import="like.LikeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	//플랜넘버
	int rownum = Integer.parseInt(request.getParameter("rownum"));
	//세션 값
	String nickSession = (String)session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	
	//인기페이지에서 넘어오면 true, 아니면 false
	String pop = request.getParameter("pop");
	
	MemberDAO mdao = MemberDAO.getInstance();
	MemberDTO member = mdao.getMember(nick);

	LikeDAO dao = LikeDAO.getInstance();
	int checkLike = dao.checkLike(rownum, nick);
	int likeNumber = dao.getLikeNum(rownum);
	
	int re=0;

	//회원이 좋아요 하지 않았을 경우
	if(checkLike==0) {
		dao.updateLike(rownum, true);
		re = dao.insertLike(member, rownum);
	//이미 좋아요 했을 경우
	} else if(checkLike==1) {
		if (likeNumber>0) {
			dao.updateLike(rownum, false);
			re = dao.deleteLike(rownum, nick);
		}
	}
	
	if (pop.equals("true")) {
		response.sendRedirect("planDetail.jsp?rownum="+rownum+"&pop=true");
	} else {
		response.sendRedirect("planDetail.jsp?rownum="+rownum+"&pop=false");
	}

	
	
	%>