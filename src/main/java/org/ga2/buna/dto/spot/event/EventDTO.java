package org.ga2.buna.dto.spot.event;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventDTO {
	private String spotSerialNumber;
	private String eventName;
	private String eventVenue;
	private String eventLocation;
	private String eventPhoneNumber;
	private Timestamp eventStartDate;
	private Timestamp eventEndDate;
	private String eventPhoto;
	private String eventUrl;
}



