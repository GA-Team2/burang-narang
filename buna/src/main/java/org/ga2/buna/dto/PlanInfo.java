package org.ga2.buna.dto;

import java.sql.Timestamp;

public class PlanInfo {
	private int p_rownum;
	private String m_nickname;
	private String p_title;
	private Timestamp p_firstdate;
	private Timestamp p_lastdate;
	private String t_namelist; // nullable
	private Timestamp p_regdate;
	private int p_like;
	
	
	public int getP_rownum() {return p_rownum;}
	public void setP_rownum(int p_rownum) {this.p_rownum = p_rownum;}
	public String getM_nickname() {return m_nickname;}
	public void setM_nickname(String m_nickname) {this.m_nickname = m_nickname;}
	public String getP_title() {return p_title;}
	public void setP_title(String p_title) {this.p_title = p_title;}
	public Timestamp getP_firstdate() {return p_firstdate;}
	public void setP_firstdate(Timestamp p_firstdate) {this.p_firstdate = p_firstdate;}
	public Timestamp getP_lastdate() {return p_lastdate;}
	public void setP_lastdate(Timestamp p_lastdate) {this.p_lastdate = p_lastdate;}
	public String getT_namelist() {return t_namelist;}
	public void setT_namelist(String t_namelist) {this.t_namelist = t_namelist;}
	public Timestamp getP_regdate() {return p_regdate;}
	public void setP_regdate(Timestamp p_regdate) {this.p_regdate = p_regdate;}
	public int getP_like() {return p_like;}
	public void setP_like(int p_like) {this.p_like = p_like;}
}
