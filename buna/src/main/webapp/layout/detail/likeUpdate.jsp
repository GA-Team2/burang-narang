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
	String nick = (String) session.getAttribute("nick_s");
	//myPage값
	String mypage = request.getParameter("mypage");
	
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
		System.out.println(re);
	//이미 좋아요 했을 경우
	} else if(checkLike==1) {
		if (likeNumber>0) {
			dao.updateLike(rownum, false);
			re = dao.deleteLike(rownum, nick);
			System.out.println(re);
		}
	}
		response.sendRedirect("planDetail.jsp?rownum="+rownum+"&mypage="+mypage);
	//}
	%>