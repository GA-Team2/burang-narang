package org.ga2.buna.dao.dateCheck;
import java.util.List;
import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DateCheckDAO {

//	private JdbcTemplate jdbcTemplate;

	private final DateCheckMapper dateCheckMapper;

	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}

	/**
	 * DB로부터 일정 날짜와 날짜별 일정 수를 가져오는 메소드
	 * @return ArrayList배열 획득
	 */
//	public List<DateCheckDTO> getDate() {
//		//DATECOUNT VIEW의 모든 데이터를 가져오는 쿼리문
//		String sql = "SELECT * FROM DATECOUNT";
//		//DTO 객체를 타입으로 갖는 ArrayList 선언
//		List<DateCheckDTO> gd = this.jdbcTemplate.query(sql, (resultSet, rowNum) -> {
//			DateCheckDTO dateCheckDTO = new DateCheckDTO();
//			dateCheckDTO.setPlanTripdate(resultSet.getString(1));
//			dateCheckDTO.setDatecount(resultSet.getInt(2));
//			return dateCheckDTO;
//		});
//
//		//ArrayList 배열 리턴
//		return gd;
//	}

	public List<DateCheckDTO> getDate() {return dateCheckMapper.getDate();}
}