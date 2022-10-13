package org.ga2.buna.dto;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopDTO {
	
	//PLANINFO TABLE
	private int p_rownum;
	private String p_title;
	private String t_namelist;
	private Timestamp p_regdate;
	private int p_like;
	
	//MEMBERINFO TABLE
	private int m_gender;
	private int m_birthyear;
	
	//TAGLIST TABLE
	private String t_name;
	private int t_hit;
	
	
	public static int pageSize = 10;
	public static int pageCount = 1;
	public static int pageNum = 1;
	
	public static String pageNumber(int limit, String like, String searchTag) throws UnsupportedEncodingException {
		
		String str="";
		int temp = (pageNum - 1) % limit;
		int startPage = pageNum - temp;
		
		if((startPage - limit) > 0) {
			str = "<a href='popularityPlan.jsp?pageNum7="+(startPage-1)+"'>[이전]</a>&nbsp;&nbsp;";
		}
		
		for(int i=startPage; i<(startPage+limit); i++) {
			if(i == pageNum) {
				str+="["+i+"]&nbsp;&nbsp";
			} else {
				if (searchTag != null) {
					str+="<a href='popularityPlan.jsp?pageNum="+i+"&searchTag="+URLEncoder.encode(searchTag, "utf-8")+"'>["+i+"]</a>&nbsp;&nbsp;";
				} else if(like == null) {
					str+="<a href='popularityPlan.jsp?pageNum="+i+"'>["+i+"]</a>&nbsp;&nbsp;";
				} else {
					str+="<a href='popularityPlan.jsp?pageNum="+i+"&like=true'>["+i+"]</a>&nbsp;&nbsp;";
				}
			}
			if(i >= pageCount) {
				break;
			}

		}
		if((startPage + limit) <= pageCount) {
			str += "<a href='popularityPlan.jsp?pageNum="+(startPage+limit)+"'>[다음]</a>";
		}
		return str;
	}
}