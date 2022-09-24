package dateCheckPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		JsonObject jobj = null;
		DateCheckDBBean dcdb = DateCheckDBBean.getInstance();
		ArrayList<DateCheckBean> dateList = dcdb.getDate();
		JsonArray ary = new JsonArray();
		JsonParser parser = new JsonParser();
		for (int i = 0; i < dateList.size(); i++) {
			jsonObject.addProperty("p_tripdate", dateList.get(i).getP_tripdate());
			jsonObject.addProperty("datecount", dateList.get(i).getDatecount());
			String str = gson.toJson(jsonObject);
			jobj = (JsonObject)parser.parse(str);
			ary.add(jobj);
		}
		return ary.toString();
	}
}
