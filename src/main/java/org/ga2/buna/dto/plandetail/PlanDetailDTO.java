package org.ga2.buna.dto.plandetail;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 플랜 디테일 정보 클래스
 *
 * @author 한애채
 */
@Getter
@Setter
public class PlanDetailDTO {
    private int planRowNumber;
    private int planTripDay;
    private Timestamp planTripDate;
    private int planSequence;
    private String spotSerialNumber;
    private String planSpotName;
}
