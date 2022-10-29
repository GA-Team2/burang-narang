package org.ga2.buna.dao.spot.event;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.sql.DataSource;

/**
 * 이벤트에 접근하는 클래스 => eventListDAO와 병합 필요!!
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
public class EventRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

	/**
	 * 이벤트 정보 리스트를 반환하는 메서드
	 * 
	 * @return 이벤트 객체 리스트
	 *
	 */
	public List<EventDTO> selectAll() {
		String query = "SELECT * FROM EVENT";

		List<EventDTO> eventDTOList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			EventDTO eventDTO = new EventDTO();
			eventDTO.setSpotSerialNumber(resultSet.getString(1));
			eventDTO.setEventName(resultSet.getString(2));
			eventDTO.setEventVenue(resultSet.getString(3));
			eventDTO.setEventPhoneNumber(resultSet.getString(4));
			eventDTO.setEventLocation(resultSet.getString(5));
			eventDTO.setEventStartDate(resultSet.getTimestamp(6));
			eventDTO.setEventEndDate(resultSet.getTimestamp(7));
			eventDTO.setEventPhoto(resultSet.getString(8));
			eventDTO.setEventUrl(resultSet.getString(9));

			return eventDTO;
		});

		log.debug(eventDTOList.toString());
		return eventDTOList;
	}

	/**
	 * 시리얼 넘버를 변수로 받아 이벤트 정보 반환하는 메서드
	 * 
	 * @param serialNumber 고유 번호
	 * @return 이벤트의 객체
	 *
	 */
	public EventDTO selectBySerialNumber(String serialNumber) {
		String query = "SELECT * FROM EVENT WHERE S_SERIALNUM = ?";

		EventDTO eventDTO = this.jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			EventDTO newEventDTO = new EventDTO();
			newEventDTO.setSpotSerialNumber(resultSet.getString(1));
			newEventDTO.setEventName(resultSet.getString(2));
			newEventDTO.setEventVenue(resultSet.getString(3));
			newEventDTO.setEventPhoneNumber(resultSet.getString(4));
			newEventDTO.setEventLocation(resultSet.getString(5));
			newEventDTO.setEventStartDate(resultSet.getTimestamp(6));
			newEventDTO.setEventEndDate(resultSet.getTimestamp(7));
			newEventDTO.setEventPhoto(resultSet.getString(8));
			newEventDTO.setEventUrl(resultSet.getString(9));

			return newEventDTO;
		}, serialNumber);

		log.debug(eventDTO.toString());
		return eventDTO;
	}
}