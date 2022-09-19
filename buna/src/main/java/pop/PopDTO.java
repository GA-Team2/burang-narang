package pop;

import java.sql.Timestamp;

public class PopDTO {
	private int B_ROWNUM;
	private String B_TITLE;
	private String B_HASHNAME;
	private int B_HASHHIT;
	private Timestamp B_REGDATE;
	private int B_LIKE;
	
	public static int pageSize = 10;
	public static int pageCount = 1;
	public static int pageNum = 1;
	
	public static String pageNumber(int limit) {
		
		String str="";
		int temp = (pageNum - 1) % limit;
		int startPage = pageNum - temp;
		
		if((startPage - limit) > 0) {
			str = "<a href='popularityPlan.jsp?pageNum="+(startPage-1)+"'>[이전]</a>&nbsp;&nbsp;";
		}
	
		for(int i=startPage; i<(startPage+limit); i++) {
			if(i == pageNum) {
				str+="["+i+"]&nbsp;&nbsp";
			} else {
				str+="<a href='popularityPlan.jsp?pageNum="+i+"'>["+i+"]</a>&nbsp;&nbsp;";
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
	
	public int getB_ROWNUM() {
		return B_ROWNUM;
	}
	public void setB_ROWNUM(int b_ROWNUM) {
		B_ROWNUM = b_ROWNUM;
	}
	public String getB_TITLE() {
		return B_TITLE;
	}
	public void setB_TITLE(String b_TITLE) {
		B_TITLE = b_TITLE;
	}
	public String getB_HASHNAME() {
		return B_HASHNAME;
	}
	public void setB_HASHNAME(String b_HASHNAME) {
		B_HASHNAME = b_HASHNAME;
	}
	public int getB_HASHHIT() {
		return B_HASHHIT;
	}
	public void setB_HASHHIT(int b_HASHHIT) {
		B_HASHHIT = b_HASHHIT;
	}
	public Timestamp getB_REGDATE() {
		return B_REGDATE;
	}
	public void setB_REGDATE(Timestamp b_REGDATE) {
		B_REGDATE = b_REGDATE;
	}
	public int getB_LIKE() {
		return B_LIKE;
	}
	public void setB_LIKE(int b_LIKE) {
		B_LIKE = b_LIKE;
	}
	
	
}
