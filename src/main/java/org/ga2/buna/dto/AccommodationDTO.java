package org.ga2.buna.dto;

/**
 * 숙소 정보 클래스
 * @author 한애채
 *
 */
public class AccommodationDTO {
	private String s_serialnum;
	private String a_type;
	private String a_name;
	private String a_pnumber;
	private String a_location;
	private String a_checkin; // 숙소 운영하는 시간
	private String a_checkout;
	private String a_photo;
	
	
	public String getS_serialnum() {return s_serialnum;}
	public void setS_serialnum(String s_serialnum) {this.s_serialnum = s_serialnum;}
	public String getA_type() {return a_type;}
	public void setA_type(String a_type) {this.a_type = a_type;}
	public String getA_name() {return a_name;}
	public void setA_name(String a_name) {this.a_name = a_name;}
	public String getA_pnumber() {return a_pnumber;}
	public void setA_pnumber(String a_pnumber) {this.a_pnumber = a_pnumber;}
	public String getA_location() {return a_location;}
	public void setA_location(String a_location) {this.a_location = a_location;}
	public String getA_checkin() {return a_checkin;}
	public void setA_checkin(String a_checkin) {this.a_checkin = a_checkin;}
	public String getA_checkout() {return a_checkout;}
	public void setA_checkout(String a_checkout) {this.a_checkout = a_checkout;}
	public String getA_photo() {return a_photo;}
	public void setA_photo(String a_photo) {this.a_photo = a_photo;}
}