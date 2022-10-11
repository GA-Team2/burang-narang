package org.ga2.buna.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 플랜 디테일 클래스 -> PlanDetailDTO와 병합 필요!
 * @author 한애채
 *
 */
@Getter
@Setter
public class PlanDetail {
	private int p_rownum;
	private int p_tripday;
	private Timestamp p_tripdate;
	private int p_sequence;
	private String s_serialnum;
	private String p_spotname;
}
