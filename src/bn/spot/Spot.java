package bn.spot;

public class Spot {
	// 이름, 종류, 정보, 인기 -> pk로 쓸 id 부여 필요할 듯
	private String s_name;
	private String s_type;
	private String s_content;	
	private int s_pop;
	
	
	public String getS_name() {return s_name;}
	public void setS_name(String s_name) {this.s_name = s_name;}
	public String getS_type() {return s_type;}
	public void setS_type(String s_type) {this.s_type = s_type;}
	public String getS_content() {return s_content;}
	public void setS_content(String s_content) {this.s_content = s_content;}
	public int getS_pop() {return s_pop;}
	public void setS_pop(int s_pop) {this.s_pop = s_pop;}
}
