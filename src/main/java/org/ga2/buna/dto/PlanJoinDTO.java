package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 장희정
 */
@Getter
@Setter
public class PlanJoinDTO {
	private int p_rownum;
	private int p_tripday;
	private String p_spotname;
	private String p_tripdate;
	private String m_nickname;
	private String p_title;
	private String t_namelist;
	private int p_like;
	private String s_serialnum;
	private String s_location;
	private int p_sequence;
	private String s_pnumber;
	private String e_venue;
	private String e_name;
}