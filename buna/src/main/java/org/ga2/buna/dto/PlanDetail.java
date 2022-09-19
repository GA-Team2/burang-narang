package org.ga2.buna.dto;

import java.sql.Timestamp;

public class PlanDetail {
	private int p_rownum;
	private String s_serialnum;
	private int p_tripday;
	private String p_spotname;
	private Timestamp p_tripdate;
	private String t_namelist; //nullable
	
	
	public int getP_rownum() {return p_rownum;}
	public void setP_rownum(int p_rownum) {this.p_rownum = p_rownum;}
	public String getS_serialnum() {return s_serialnum;}
	public void setS_serialnum(String s_serialnum) {this.s_serialnum = s_serialnum;}
	public int getP_tripday() {return p_tripday;}
	public void setP_tripday(int p_tripday) {this.p_tripday = p_tripday;}
	public String getP_spotname() {return p_spotname;}
	public void setP_spotname(String p_spotname) {this.p_spotname = p_spotname;}
	public Timestamp getP_tripdate() {return p_tripdate;}
	public void setP_tripdate(Timestamp p_tripdate) {this.p_tripdate = p_tripdate;}
	public String getT_namelist() {return t_namelist;}
	public void setT_namelist(String t_namelist) {this.t_namelist = t_namelist;}
}
