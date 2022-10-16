package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDetailDTO {
	private int planRowNum;
	private int planTripDay;
	private String spotSerialNum;
	private String planSpotName;
	private Timestamp planTripDate;
	private int planSequence;
}
