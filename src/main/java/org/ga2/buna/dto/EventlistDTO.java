package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventlistDTO {
	private String s_serialnum;
	private String e_name;
	private String e_location;
	private Timestamp e_startdate;
	private Timestamp e_enddate;
	private String e_photo;
	private String e_url;
}



