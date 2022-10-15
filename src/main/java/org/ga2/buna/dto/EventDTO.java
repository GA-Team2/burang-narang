package org.ga2.buna.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 이벤트 정보 클래스 -> eventListDTO 와 병합 필요, Event.java 파일 삭제 해야할거 같은데 확인 요망
 * @author 한애채
 *
 */
@Getter
@Setter
public class EventDTO {
	private String s_serialnum;
	private String e_name;
	private String e_venue;
	private String e_location;
	private String e_pnumber;
	private Timestamp e_startdate;
	private Timestamp e_enddate;
	private String e_photo;
	private String e_url;
}