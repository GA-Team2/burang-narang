package org.ga2.buna.dto.plandetail;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PlanWithSpotDTO {
    private int planTripDay;
    private Timestamp planTripDate;
    private int planSequence;
    private String spotSerialNumber;
    private String spotType;
    private String spotName;
    private String spotLocation;
    private String spotPhoto;
}
