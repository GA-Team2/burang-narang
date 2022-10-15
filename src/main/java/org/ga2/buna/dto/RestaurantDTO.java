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
	private String spotSerialNum;
	private String restaurantType;
	private String restaurantName;
	private String restaurantPnumber;
	private String restaurantLocation;
	private String restaurantOpenTime;
	private String restaurantCloseTime;
	private String restaurantPhoto;
}