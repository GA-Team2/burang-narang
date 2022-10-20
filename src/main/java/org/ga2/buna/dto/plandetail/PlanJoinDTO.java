package org.ga2.buna.dto.plandetail;

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
	private int planRownum;
	private int planTripday;
	private String planSpotname;
	private String planTripdate;
	private String memberNickname;
	private String planTitle;
	private String tagNamelist;
	private int planLike;
	private String spotSerialnum;
	private String spotLocation;
	private int planSequence;
	private String spotNumber;
	private String eventVenue;
	private String eventName;
}