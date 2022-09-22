package org.ga2.buna.dto;

import java.sql.Timestamp;

public class Restaurant {
	private String s_serialnum;
	private String r_type;
	private String r_name;
	private String r_location;
	private Timestamp r_opentime;
	private Timestamp r_closetime; 
	private String r_photo;
	
	
	public String getS_serialnum() {return s_serialnum;}
	public void setS_serialnum(String s_serialnum) {this.s_serialnum = s_serialnum;}
	public String getR_type() {return r_type;}
	public void setR_type(String r_type) {this.r_type = r_type;}
	public String getR_name() {return r_name;}
	public void setR_name(String r_name) {this.r_name = r_name;}
	public String getR_location() {return r_location;}
	public void setR_location(String r_location) {this.r_location = r_location;}
	public Timestamp getR_opentime() {return r_opentime;}
	public void setR_opentime(Timestamp r_opentime) {this.r_opentime = r_opentime;}
	public Timestamp getR_closetime() {return r_closetime;}
	public void setR_closetime(Timestamp r_closetime) {this.r_closetime = r_closetime;}
	public String getR_photo() {return r_photo;}
	public void setR_photo(String r_photo) {this.r_photo = r_photo;}
}
