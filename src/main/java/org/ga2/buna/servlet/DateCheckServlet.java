package org.ga2.buna.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ga2.buna.dao.DateCheckDBBean;
import org.ga2.buna.dto.DateCheckBean;
import org.json.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "dateCheckServlet", urlPatterns = "/datacheck")
public class DateCheckServlet extends HttpServlet {
    /**
	* ajax에서 get방식의 controller 
	* @author 한병태
	*
	*/   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터를 주고받을 때 문자열 인코딩  
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			//servlet 페이지로 리턴
			response.getWriter().print(getDB());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * DAO로부터 가져온 ArrayList배열을 제이슨 배열로 바꿔주는 메소드
	 * @return 문자열로 이루어진 제이슨 배열 획득
	 * @throws Exception
	 */
	public String getDB() throws Exception {
		//DAO선언
		DateCheckDBBean dcdb = DateCheckDBBean.getInstance();
		//ArrayList에 getDAte메소드 리턴
		ArrayList<DateCheckBean> dateList = dcdb.getDate();
		//제이슨 배열 클래스 선언 -> 제이슨 오브젝트를 배열로 형성해줌
		JSONArray Jary = new JSONArray();
		for (int i = 0; i < dateList.size(); i++) {
			//제이슨 오브젝트 클래스 선언 -> 일반 배열을 제이슨 오브젝트로 변환해줌
			JSONObject sobj = new JSONObject();
			//제이슨 오브젝트에 key와 value를 입력하고 변환 
			sobj.put("planTripdate", dateList.get(i).getPlanTripdate());
			sobj.put("datecount", dateList.get(i).getDatecount());
			//제이슨 배열로 형성
			Jary.put(sobj);
		}
		//제이슨 배열 문자열로 리턴
		return Jary.toString();
	}
}