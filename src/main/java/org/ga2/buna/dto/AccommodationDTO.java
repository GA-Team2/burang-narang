package org.ga2.buna.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 숙소 정보 클래스
 * @author 한애채
 *
 */
@Getter
@Setter
public class AccommodationDTO {
	private String spotSerialNum;
	private String accommodationType;
	private String accommodationName;
	private String accommodationPnumber;
	private String accommodationLocation;
	private String accommodationCheckIn; // 숙소 운영하는 시간
	private String accommodationCheckOut;
	private String accommodationPhoto;
}