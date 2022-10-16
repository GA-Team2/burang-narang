package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventlistDTO {
	private String spotSerialnum;
	private String eventName;
	private String eventVenue;
	private String eventLocation;
	private String eventPnumber;
	private Timestamp eventStartdate;
	private Timestamp eventEnddate;
	private String eventPhoto;
	private String eventUrl;
}



