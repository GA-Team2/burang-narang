package org.ga2.buna.dto;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanInfoDTO {
	private int p_rownum;
	private String m_nickname;
	private String p_title;
	private Timestamp p_firstdate;
	private Timestamp p_lastdate;
	private String t_namelist;
	private Timestamp p_regdate;
	private int p_like;
	private int p_public;
}
