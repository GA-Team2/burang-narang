package pop;

import java.sql.Timestamp;

public class popDTO {
	private int B_ROWNUM;
	private String B_TITLE;
	private String B_HASHNAME;
	private int B_HASHHIT;
	private Timestamp B_REGDATE;
	private int B_LIKE;
	
	public static int pageSize = 10; //한페이지에 10개를 보여주기 위한 변수
	public static int pageCount = 1; //페이지 개수 카운트, 페이지(컬럼)가 많을수록 늘어남, ex)84건이면 페이지카운트=9
	public static int pageNum = 1; //페이지번호
	//public static으로 바로 사용할 수 있게 함. 
	
	public static String pageNumber(int limit) { //화면에 보이는 페이지 갯수 지정-> limit
		//페이지 목록들을 만들어주는 메소드
		//int limit -> 몇개의 페이지에 대한 로직을 처리할것인지 설정
		
		String str=""; //return 값
		int temp = (pageNum - 1) % limit; //시작페이지를 구하기 위함 0
		int startPage = pageNum - temp; //시작페이지 설정 1-0이기 때문에 1이됨
		
		if((startPage - limit) > 0) { //[이전]을 구현하기 위한 if문
			//limit=4, temp=0, startPage=1 가정
			//-> if(1-4 >0) false
			//->pageNum=5인경우 ->startPage=5
			//-> if((5-4)>0) true
			str = "<a href='popularityPlan.jsp?pageNum="+(startPage-1)+"'>[이전]</a>&nbsp;&nbsp;";
			//str = [이전]
		}
	
		for(int i=startPage; i<(startPage+limit); i++) { //페이지번호가 몇개인지 모르니
			//for(i=1; i<5; i++) ->4까지 나옴
			//pageNum=5인경우 for(i=5; i<9; i++)
			if(i == pageNum) {
				//i=1 -> 링크가 안걸림
				str+="["+i+"]&nbsp;&nbsp";
				//str = [1]
			} else {
				str+="<a href='popularityPlan.jsp?pageNum="+i+"'>["+i+"]</a>&nbsp;&nbsp;";
				//i=1반복문 진행 str=[1]+링크걸린[2]+링크걸린[3]+링크걸린[4]
				//pageNum=5 인경우 반복문 진행
				//str = [이전] +[5]+링크걸린[6]+링크걸린[7]+링크걸린[8]+링크걸린[9]+
			}
			if(i >= pageCount) { //페이지개수보다 크면 break
				//pageNum = 5 5>9 -> 브레이크 걸림
				break;
			}

		}
		if((startPage + limit) <= pageCount) { //[다음]을 구현하기 위한  if문
			//pageCount가 9라는 가정 -> if(1+4<=9) ->마지막이 다음으로 바뀜
			str += "<a href='popularityPlan.jsp?pageNum="+(startPage+limit)+"'>[다음]</a>";
			//str = [1]+링크가 걸린[2]+링크가 걸린[3]+링크가 걸린[4] + [다음]
			//str = [이전]+[5]+링크걸린[6]+링크걸린[7]+링크걸린[8]+링크걸린[9]+[다음]
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
