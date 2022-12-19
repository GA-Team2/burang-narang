package org.ga2.buna.dto.spot.traffic;

import lombok.Getter;
import lombok.Setter;

/**
 * 교통 정보 클래스
 *
 * @author 한애채
 */
@Getter
@Setter
public class TrafficDTO {
    private String spotSerialNumber;
    private String trafficType;
    private String trafficName;
    private String trafficPhoneNumber;
    private String trafficLocation;
    private String trafficPhoto;
}