package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.ga2.buna.dto.TagDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 새 플랜 추가 페이지의 추천 태그 기능을 위한 DAO 클래스
 * @author 김규빈
 *
 */
@Slf4j
@Repository
public class TagDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 태그들을 등록빈도순으로 정렬하여 조회
	 * @return 정렬된 태그 리스트
	 */
	public List<TagDto> listTag() {
		String query = "SELECT T_NAME FROM TAGLIST ORDER BY T_HIT DESC";
		List<TagDto> list = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			TagDto tagDto = new TagDto();
			tagDto.setTagName(resultSet.getString(1));
			return tagDto;
		});
		
		log.debug(list.toString());
		return list;
	}


	/**
	 * 태그 이름 변수를 통해 태그 DB에 해당 태그가 존재하는지 결과를 반환하는 메서드
	 *
	 * @param 태그 이름
	 * @return count == 1이면 true, 아니면 false
	 *
	 */
	public boolean hasTag(String tagName) {
		String query = "SELECT COUNT(*) FROM TAGLIST WHERE T_NAME = ?";
		// integer로 쓰는게 더 나은지 찾아 보기
		int count = this.jdbcTemplate.queryForObject(query, Integer.class, tagName);

		log.debug(((Integer) count).toString());
		return count == 1 ? true : false;
	}

	/**
	 * 태그 DB에 새롭게 입력된 태그 정보를 추가하는 메서드 새로운 태그가 추가되면서 태그 hit는 1로 초기화한다.
	 *
	 * @param 태그 이름
	 * @return 삽입 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public void insertTag(String tagName) throws Exception {
		String query = "INSERT INTO TAGLIST VALUES(?, 1)";
		int result = this.jdbcTemplate.update(query, tagName);

		log.debug(((Integer) result).toString());
	}

	/**
	 * 태그 DB의 hit 컬럼을 업데이트하는 메서드
	 *
	 * @param 태그 이름, 참거짓 태그를 삭제했다면 false, 태그를 추가했다면 true
	 * @return 갱신 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public int updateTag(String tag, Boolean b) throws Exception {
	}
}