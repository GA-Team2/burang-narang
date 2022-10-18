package org.ga2.buna.dao;
import java.util.List;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.DateCheckBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class DateCheckDBBean {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * DB로부터 일정 날짜와 날짜별 일정 수를 가져오는 메소드
	 * @return ArrayList배열 획득
	 */
	public List<DateCheckBean> getDate() {
		//DATECOUNT VIEW의 모든 데이터를 가져오는 쿼리문
		String sql = "SELECT * FROM DATECOUNT";
		//DTO 객체를 타입으로 갖는 ArrayList 선언
		List<DateCheckBean> gd = this.jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			DateCheckBean dateCheckBean = new DateCheckBean();
			dateCheckBean.setPlanTripdate(resultSet.getString(1));
			dateCheckBean.setDatecount(resultSet.getInt(2));
			return dateCheckBean;
		});

		//ArrayList 배열 리턴
		return gd;
	}
}