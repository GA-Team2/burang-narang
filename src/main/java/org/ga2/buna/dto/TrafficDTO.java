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
	private String s_serialnum;
	private String tf_type;
	private String tf_name;
	private String tf_pnumber;
	private String tf_location; 
	private String tf_photo;
}