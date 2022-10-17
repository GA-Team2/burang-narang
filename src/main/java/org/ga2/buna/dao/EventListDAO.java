package org.ga2.buna.dao;

import java.util.List;

import javax.sql.DataSource;

import org.ga2.buna.dto.EventlistDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 강승구
 *
 */
@Slf4j
public class EventListDAO {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate();
	}


	/**
	 * 축제/이벤트 페이지 목록 출력 메서드
	 * @return 쿼리 결과값을 EventListDTO에 넣고 List배열에 담아 리턴
	 */
	public List<EventlistDTO> listEvent(){

		String sql = "SELECT S_SERIALNUM, E_NAME, E_LOCATION, E_STARTDATE,\r\n" +
						"       E_ENDDATE, E_PHOTO, E_URL \r\n" +
						"       FROM EVENT WHERE E_STARTDATE IS NOT NULL \r\n" +
						"       AND E_ENDDATE IS NOT NULL";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<EventlistDTO>(EventlistDTO.class));

	}
}
