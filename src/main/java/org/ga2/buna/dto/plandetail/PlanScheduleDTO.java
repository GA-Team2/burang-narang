package org.ga2.buna.dto.plandetail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 일자별 일정 정보를 담기 위한 DTO
 * @author 장희정
 */
@Getter
@Setter
@ToString
public class PlanScheduleDTO {
    private String planSpotname;
    private String spotSerialnum;
    private int planSequence;
    private String spotLocation;
    private String eventName;
}
