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
	private int planRownum;
	private String planTitle;
	private String tagNamelist;
	private Timestamp planRegdate;
	private int planLike;
	
	//MEMBERINFO TABLE
	private int memberGender;
	private int memberBirthyear;
	
	//TAGLIST TABLE
	private String tagName;
	private int tagHit;
	
	
	public static int pageSize = 10;
	public static int pageCount = 1;
	public static int pageNum = 1;
	
	public static String pageNumber(int limit, String like, String searchTag) throws UnsupportedEncodingException {
		
		String str="";
		int temp = (pageNum - 1) % limit;
		int startPage = pageNum - temp;
		
		if((startPage - limit) > 0) {
			str = "<a href='PopularityPlan.jsp?pageNum7="+(startPage-1)+"'>[이전]</a>&nbsp;&nbsp;";
		}
		
		for(int i=startPage; i<(startPage+limit); i++) {
			if(i == pageNum) {
				str+="["+i+"]&nbsp;&nbsp";
			} else {
				if (searchTag != null) {
					str+="<a href='PopularityPlan.jsp?pageNum="+i+"&searchTag="+URLEncoder.encode(searchTag, "utf-8")+"'>["+i+"]</a>&nbsp;&nbsp;";
				} else if(like == null) {
					str+="<a href='PopularityPlan.jsp?pageNum="+i+"'>["+i+"]</a>&nbsp;&nbsp;";
				} else {
					str+="<a href='PopularityPlan.jsp?pageNum="+i+"&like=true'>["+i+"]</a>&nbsp;&nbsp;";
				}
			}
			if(i >= pageCount) {
				break;
			}

		}
		if((startPage + limit) <= pageCount) {
			str += "<a href='PopularityPlan.jsp?pageNum="+(startPage+limit)+"'>[다음]</a>";
		}
		return str;
	}
}