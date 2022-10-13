package org.ga2.buna.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 플랜 Info 클래스 -> PlanInfoDTO 클래스와 병합 필요!
 * @author 한애채
 *
 */
@Getter
@Setter
public class PlanInfo {
	private int p_rownum; 
	private String m_nickname;
	private String p_title;
	private Timestamp p_firstdate;
	private Timestamp p_lastdate;
	private String t_namelist; // nullable
	private Timestamp p_regdate; // 글 작성 시간
	private int p_like;
	private int p_public; // 공개 유무
}
