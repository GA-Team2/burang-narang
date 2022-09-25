package org.ga2.buna.dto;
import java.sql.Timestamp;

public class PopDTO {
	//PLANINFO TABLE
	private int p_rownum;
	private String p_title;
	private String t_namelist;
	private Timestamp p_regdate;
	private int p_like;
	
	//LIKEINFO TABLE
	private int m_gender;
	private int m_agerange;
	
	//TAGLIST TABLE
	private String t_name;
	private int t_hit;
	
	
	public static int pageSize = 10;
	public static int pageCount = 1;
	public static int pageNum = 1;
	
	public static String pageNumber(int limit, String like, String tagSearch) {
		
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
				
				if((like == null)) {
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

	public int getP_rownum() {
		return p_rownum;
	}

	public void setP_rownum(int p_rownum) {
		this.p_rownum = p_rownum;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getT_namelist() {
		return t_namelist;
	}

	public void setT_namelist(String t_namelist) {
		this.t_namelist = t_namelist;
	}

	public Timestamp getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(Timestamp p_regdate) {
		this.p_regdate = p_regdate;
	}

	public int getP_like() {
		return p_like;
	}

	public void setP_like(int p_like) {
		this.p_like = p_like;
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		PopDTO.pageSize = pageSize;
	}

	public static int getPageCount() {
		return pageCount;
	}

	public static void setPageCount(int pageCount) {
		PopDTO.pageCount = pageCount;
	}

	public static int getPageNum() {
		return pageNum;
	}

	public static void setPageNum(int pageNum) {
		PopDTO.pageNum = pageNum;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getT_hit() {
		return t_hit;
	}

	public void setT_hit(int t_hit) {
		this.t_hit = t_hit;
	}

	public int getM_gender() {
		return m_gender;
	}

	public void setM_gender(int m_gender) {
		this.m_gender = m_gender;
	}

	public int getM_agerange() {
		return m_agerange;
	}

	public void setM_agerange(int m_agerange) {
		this.m_agerange = m_agerange;
	}
	
	
	
}