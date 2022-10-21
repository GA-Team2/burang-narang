package org.ga2.buna.dao.dDay;


import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.DDayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * 
 * D-day 기능을위한 클래스
 * @author 한병태
 * 
 */
@Slf4j
@Repository
public class DdayDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	* 
	* D-day를 표시하기위한 일정 첫번째 날짜를 가져오기위한 메소드
	* @return DDayBean객체 획득
	*
	*/
	public DDayBean getDday(String nick){
		String sql = "SELECT CEIL(MIN(P_FIRSTDATE)-curdate()) AS D_DAY FROM PLANINFO WHERE M_NICKNAME=?";
		DDayBean dDay = jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
			DDayBean newBean = new DDayBean();

			newBean.setDDay(resultSet.getInt(1));
			newBean.setEmpty(resultSet.getString(1));
			return newBean;
		}, nick);
		return dDay;
	}
}