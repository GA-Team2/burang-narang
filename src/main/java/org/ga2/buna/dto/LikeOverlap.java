package org.ga2.buna.dto;

public class LikeOverlap {
	private int p_rownum;
	private String m_nick;
	private int l_age;	// 1번째 자리만
	private int m_gender; // 0: 여자, 1: 남자
	
	public int getP_rownum() {return p_rownum;}
	public void setP_rownum(int p_rownum) {this.p_rownum = p_rownum;}
	public String getM_nick() {return m_nick;}
	public void setM_nick(String m_nick) {this.m_nick = m_nick;}
	public int getL_age() {return l_age;}
	public void setL_age(int l_age) {this.l_age = l_age;}
	public int getM_gender() {return m_gender;}
	public void setM_gender(int m_gender) {this.m_gender = m_gender;}
}
