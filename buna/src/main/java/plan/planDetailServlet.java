package plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/planDetailServlet")
public class planDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	    int rownum = Integer.parseInt(request.getParameter("rownum"));
//	    System.out.println(rownum);
	      
		try {
			out.print(getDB(rownum));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		      jsonObject를 배열로 바꿔주는 클래스
	}
	public String getDB(int rownum) throws Exception{
		PlanDAO dcdb = PlanDAO.getInstance();
//	    db배열 선언
	    JSONArray Jary = new JSONArray();
	    ArrayList<PlanJoinDTO> dateList = dcdb.getPlanDetail(rownum);
		for (int i = 0; i < dateList.size(); i++) {
//		         jsonObject를 생성하는 클래스
			JSONObject sobj = new JSONObject();
			
//		         p_tripdate json 추가
			sobj.put("p_spotname", dateList.get(i).getP_spotname());
//		         datecount json 추가
			sobj.put("s_location", dateList.get(i).getS_location());
			sobj.put("s_pnumber", dateList.get(i).getS_pnumber());
			if (dateList.get(i).getS_serialnum().startsWith("E")) {
				sobj.put("p_spotname", dateList.get(i).getE_venue());
			}
//		         생성한 Object 배열에 추가
			Jary.put(sobj);
		}
		return Jary.toString();
	}
}
