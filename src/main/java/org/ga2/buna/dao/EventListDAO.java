//package org.ga2.buna.dao;
//
//import lombok.extern.slf4j.Slf4j;
//import org.ga2.buna.dto.spot.event.EventDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.util.List;
//
///**
// *
// * @author 강승구
// *
// */
//@Slf4j
//@Repository
//public class EventListDAO {

	//	JdbcTemplate 객체 생성
//	private JdbcTemplate jdbcTemplate;

	//JdbcTemplate
	// 객체를 생성하려면
	//setDataSource로 세터를 이용해 주입하거나
	//DateSource를 생성자에 전달하면됨
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//
//	/**
//	 * 축제/이벤트 페이지 목록 출력 메서드
//	 * @return 쿼리 결과값을 EventListDTO에 넣고 List배열에 담아 리턴
//	 */
//	public List<EventDTO> listEvent(){
//		String sql = "SELECT S_SERIALNUM as spotSerialNumber, E_NAME as eventName,\n\t" +
//				"     		 E_LOCATION as eventLocation, E_STARTDATE as eventStartDate,\n" +
//				"		     E_ENDDATE as eventEndDate, E_PHOTO as eventPhoto,\n" +
//				"       	 E_URL as eventUrl FROM EVENT";
//
//		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<EventDTO>(EventDTO.class));
//
//	}
//}
