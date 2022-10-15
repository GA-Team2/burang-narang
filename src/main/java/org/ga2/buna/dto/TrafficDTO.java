package org.ga2.buna.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 교통 정보 클래스
 * @author 한애채
 *
 */
@Getter
@Setter
public class TrafficDTO {
	private String spotSerialNum;
	private String trafficType;
	private String trafficName;
	private String trafficPnumber;
	private String trafficLocation;
	private String trafficPhoto;
}