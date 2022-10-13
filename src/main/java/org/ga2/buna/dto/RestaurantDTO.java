package org.ga2.buna.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * 맛집 정보 클래스
 * @author 한애채
 *
 */
@Getter
@Setter
public class RestaurantDTO {
	private String s_serialnum;
	private String r_type;
	private String r_name;
	private String r_pnumber;
	private String r_location;
	private String r_opentime;
	private String r_closetime; 
	private String r_photo;
}