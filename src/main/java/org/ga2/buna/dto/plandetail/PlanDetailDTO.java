package org.ga2.buna.dto.plandetail;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanDetailDTO {
	private int planRowNumber;
	private int planTripDay;
	private Timestamp planTripDate;
	private int planSequence;
	private String spotSerialNumber;
	private String planSpotName;
}
