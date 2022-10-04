package org.ga2.buna.dto;

import java.sql.Timestamp;

public class PlanDetail {
	private int p_rownum;
	private int p_tripday;
	private Timestamp p_tripdate;
	private int p_sequence;
	private String s_serialnum;
	private String p_spotname;
	
	
	public int getP_rownum() {return p_rownum;}
	public void setP_rownum(int p_rownum) {this.p_rownum = p_rownum;}
	public int getP_tripday() {return p_tripday;}
	public void setP_tripday(int p_tripday) {this.p_tripday = p_tripday;}
	public Timestamp getP_tripdate() {return p_tripdate;}
	public void setP_tripdate(Timestamp p_tripdate) {this.p_tripdate = p_tripdate;}
	public int getP_sequence() {return p_sequence;}
	public void setP_sequence(int p_sequence) {this.p_sequence = p_sequence;}
	public String getS_serialnum() {return s_serialnum;}
	public void setS_serialnum(String s_serialnum) {this.s_serialnum = s_serialnum;}
	public String getP_spotname() {return p_spotname;}
	public void setP_spotname(String p_spotname) {this.p_spotname = p_spotname;}
}
