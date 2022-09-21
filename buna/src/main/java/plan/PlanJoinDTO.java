package plan;

import java.sql.Timestamp;

public class PlanJoinDTO {
	private int p_rownum;
	private int p_tripday;
	private String p_spotname;
	private Timestamp p_tripdate;
	private String m_nickname;
	private String p_title;
	private String t_namelist;
	private int p_like;
	private String s_serialnum;
	private String s_location;
	
	
	public String getS_serialnum() {
		return s_serialnum;
	}
	public void setS_serialnum(String s_serialnum) {
		this.s_serialnum = s_serialnum;
	}
	public String getS_location() {
		return s_location;
	}
	public void setS_location(String s_location) {
		this.s_location = s_location;
	}
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
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
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
	public int getP_like() {
		return p_like;
	}
	public void setP_like(int p_like) {
		this.p_like = p_like;
	}
}
