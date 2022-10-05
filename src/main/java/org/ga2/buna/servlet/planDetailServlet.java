package org.ga2.buna.servlet;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dto.PlanJoinDTO;
import org.json.JSONArray;
	import org.json.simple.JSONObject;

	@WebServlet("/planDetailServlet")
	public class planDetailServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//주고받는 데이터 인코딩
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			//servlet 페이지로 출력해주는 메소드
			PrintWriter out = response.getWriter();
			//ajax로 받는 매개변수를 저장
		    int rownum = Integer.parseInt(request.getParameter("rownum"));
			try {
				//servlet페이지로 리턴
				out.print(getDB(rownum));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//가져온 DB를 제이슨 배열로 바꾸는 메소드
		public String getDB(int rownum) throws Exception{
			//DAO선언
			PlanDAO dcdb = PlanDAO.getInstance();
			//제이슨 배열 선언
		    JSONArray Jary = new JSONArray();
			//ArrayList 배열에 getPlanDetail 리턴
		    ArrayList<PlanJoinDTO> dateList = dcdb.getPlanDetail(rownum);
			//배열 전체를 가져오기위한 반복문
			for (int i = 0; i < dateList.size(); i++) {
				//jsonObject를 생성하는 클래스
				JSONObject sobj = new JSONObject();
				
				//각각의 ArrayList 배열을 제이슨 오브젝트로 변환하는 과정
				sobj.put("p_spotname", dateList.get(i).getP_spotname());
				sobj.put("s_location", dateList.get(i).getS_location());
				sobj.put("s_pnumber", dateList.get(i).getS_pnumber());
				//S_serialnum가 E로 시작할 경우
				if (dateList.get(i).getS_serialnum().startsWith("E")) {
					//E_venue 추가
					sobj.put("p_spotname", dateList.get(i).getE_venue());
				}
				sobj.put("p_tripday", dateList.get(i).getP_tripday());
				//생성한 Object json 배열에 추가
				Jary.put(sobj);
			}
			//json 배열 문자열로 리턴
			return Jary.toString();
		}
	}
