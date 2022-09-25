package plan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Servlet implementation class planDetailServelet
 */
@WebServlet("/planDetailServlet")
public class planDetailServlet123 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
	      int rownum = Integer.parseInt(request.getParameter("rownum"));
	      PlanDAO dcdb = PlanDAO.getInstance();
//	      db배열 선언
	      
	      try {
	    	  ArrayList<PlanJoinDTO> dateList = dcdb.getPlanDetail(rownum);
//		      jsonObject를 배열로 바꿔주는 클래스
		      JSONArray Jary = new JSONArray();
		      for (int i = 0; i < dateList.size(); i++) {
//		         jsonObject를 생성하는 클래스
		         JSONObject sobj = new JSONObject();
		         
//		         p_tripdate json 추가
		         sobj.put("p_spotname", dateList.get(i).getP_spotname());
//		         datecount json 추가
		         sobj.put("s_location", dateList.get(i).getS_location());
		         sobj.put("s_pnumber", dateList.get(i).getS_pnumber());
//		         생성한 Object 배열에 추가
		         Jary.put(sobj);
		      }
//	         ajax로 json데이터를 넘김
	         response.getWriter().print(Jary.toString());
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
}