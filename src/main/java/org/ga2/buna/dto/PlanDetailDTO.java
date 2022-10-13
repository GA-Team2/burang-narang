package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDetailDTO {
	private int p_rownum;
	private int p_tripday;
	private String s_serialnum;
	private String p_spotname;
	private Timestamp p_tripdate;
	private int p_sequence;
}
