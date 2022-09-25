//컨트롤러
package dateCheckPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/DateCheckServlet")
public class DateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
//			ajax로 json데이터를 넘김
			response.getWriter().print(getDB());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDB() throws Exception {
		DateCheckDBBean dcdb = DateCheckDBBean.getInstance();
//		db배열 선언
		ArrayList<DateCheckBean> dateList = dcdb.getDate();
//		jsonObject를 배열로 바꿔주는 클래스
		JSONArray Jary = new JSONArray();
		for (int i = 0; i < dateList.size(); i++) {
//			jsonObject를 생성하는 클래스
			JSONObject sobj = new JSONObject();
			
//			p_tripdate json 추가
			sobj.put("p_tripdate", dateList.get(i).getP_tripdate());
//			datecount json 추가
			sobj.put("datecount", dateList.get(i).getDatecount());
//			생성한 Object 배열에 추가
			Jary.put(sobj);
		}
//		배열을 문자열로 리턴
		return Jary.toString();
	}
}
