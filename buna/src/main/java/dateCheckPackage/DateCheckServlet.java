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
import org.json.simple.parser.JSONParser;

@WebServlet("/DateCheckServlet")
public class DateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(getDB());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getDB() throws Exception {
		DateCheckDBBean dcdb = DateCheckDBBean.getInstance();
		ArrayList<DateCheckBean> dateList = dcdb.getDate();
		JSONArray Jary = new JSONArray();
		JSONObject jobj = new JSONObject();
		JSONParser parser = new JSONParser();
		for (int i = 0; i < dateList.size(); i++) {
			JSONObject sobj = new JSONObject();
			sobj.put("p_tripdate", dateList.get(i).getP_tripdate());
			sobj.put("datecount", dateList.get(i).getDatecount());
			Jary.put(sobj);
		}
		return Jary.toString();
	}
}
