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
	private String s_serialnum;
	private String a_type;
	private String a_name;
	private String a_pnumber;
	private String a_location;
	private String a_checkin; // 숙소 운영하는 시간
	private String a_checkout;
	private String a_photo;
}