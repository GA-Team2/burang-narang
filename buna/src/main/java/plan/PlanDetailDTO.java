package plan;

import java.sql.Timestamp;

public class PlanDetailDTO {
	private int p_rownum;
	private int p_tripday;
	private String s_serialnum;
	private String p_spotname;
	private Timestamp p_tripdate;
	private String t_namelist;
	
	public int getP_rownum() {
		return p_rownum;
	}
	public void setP_rownum(int p_rownum) {
		this.p_rownum = p_rownum;
	}
	public int getP_tripday() {
		return p_tripday;
	}
	public void setP_tripday(int p_tripday) {
		this.p_tripday = p_tripday;
	}
	public String getS_serialnum() {
		return s_serialnum;
	}
	public void setS_serialnum(String s_serialnum) {
		this.s_serialnum = s_serialnum;
	}
	public String getP_spotname() {
		return p_spotname;
	}
	public void setP_spotname(String p_spotname) {
		this.p_spotname = p_spotname;
	}
	public Timestamp getP_tripdate() {
		return p_tripdate;
	}
	public void setP_tripdate(Timestamp p_tripdate) {
		this.p_tripdate = p_tripdate;
	}
	public String getT_namelist() {
		return t_namelist;
	}
	public void setT_namelist(String t_namelist) {
		this.t_namelist = t_namelist;
	}
}
