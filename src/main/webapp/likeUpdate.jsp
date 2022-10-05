<%@page import="java.net.URLDecoder"%>
<%@page import="org.ga2.buna.dto.MemberDTO"%>
<%@page import="org.ga2.buna.dao.LikeDAO"%>
<%@page import="org.ga2.buna.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
	
	//플랜넘버
	int rownum = Integer.parseInt(request.getParameter("rownum"));
	
	//세션 값
	String nickSession = (String)session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	
	//인기페이지에서 넘어왔으면 true, 아니면 false
	String pop = request.getParameter("pop");
	
	MemberDAO mdao = MemberDAO.getInstance();
	MemberDTO member = mdao.getMember(nick);

	LikeDAO dao = LikeDAO.getInstance();
	//추천 여부 체크하는 메서드 호출
	int checkLike = dao.checkLike(rownum, nick);
	int likeNumber = dao.getLikeNum(rownum);
	
	int re=0;

	//해당 회원이 추천 하지 않았을 경우
	if(checkLike==0) {
		dao.updateLike(rownum, true);
		re = dao.insertLike(member, rownum);
	//이미 추천 했을 경우
	} else if(checkLike==1) {
		if (likeNumber>0) {			//추천 수가 마이너스값이 되지 않게 0이상일 때만 deleteLike 메서드 호출
			dao.updateLike(rownum, false);
			re = dao.deleteLike(rownum, nick);
		}
	}
	
	/**
	 * 인기페이지에서 넘어왔으면 pop쿼리스트링의 값을 true로 넘겨서 플랜 상세페이지로 넘어갔을 때
	 * 플랜가져오기 / 목록 버튼 보이게 해주고
	 * 반대의 경우는 false를 넘겨서 수정 / 취소 버튼 보이게 출력
	 */
	if (pop.equals("true")) {
		response.sendRedirect("planDetail.jsp?rownum="+rownum+"&pop=true");
	} else {
		response.sendRedirect("planDetail.jsp?rownum="+rownum+"&pop=false");
	}

	
	
	%>