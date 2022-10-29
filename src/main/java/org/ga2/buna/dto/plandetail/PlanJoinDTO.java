package org.ga2.buna.dto.plandetail;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author 장희정
 */
@Getter
@Setter
@ToString
public class PlanJoinDTO {
	private int planTripday;
	private String planTripdate;
	private String memberNickname;
	private String planTitle;
	private String tagNamelist;
	private int planLike;
	private List<PlanScheduleDTO> planScheduleDTO;
}