package org.ga2.buna.dao.tag;

import java.util.List;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.tag.TagDto;

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
@RequiredArgsConstructor
public class TagRepository {

	private JdbcTemplate jdbcTemplate;
	private final TagMapper tagMapper;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 태그들을 등록빈도순으로 정렬하여 조회
	 * @return 정렬된 태그 리스트
	 */
	public List<TagDto> listTag() {
		return tagMapper.findAll();
	}


	/**
	 * 태그 이름 변수를 통해 태그 DB에 해당 태그가 존재하는지 결과를 반환하는 메서드
	 *
	 * @param tagName 태그 이름
	 * @return count == 1이면 true, 아니면 false
	 *
	 */
	public boolean hasTag(String tagName) {
		String query = "SELECT COUNT(*) FROM TAGLIST WHERE T_NAME = ?";
		// integer로 쓰는게 더 나은지 찾아 보기
		int count = this.jdbcTemplate.queryForObject(query, Integer.class, tagName);

		log.info("tagName = {}인 태그 {}개 존재", tagName, count);
		return count == 1 ? true : false;
	}

	/**
	 * 태그 DB에 새롭게 입력된 태그 정보를 추가하는 메서드 새로운 태그가 추가되면서 태그 hit는 1로 초기화한다.
	 *
	 * @param tagName  태그 이름
	 *
	 */
	public void insert(String tagName) {
		String query = "INSERT INTO TAGLIST VALUES(?, 1)";
		int result = this.jdbcTemplate.update(query, tagName);

		log.info("tagName = {}인 태그 {}개 행 삽입 성공", tagName, result);
	}

	/**
	 * 태그 DB의 hit 컬럼을 업데이트하는 메서드
	 *
	 * @param tagName 태그 이름
	 * @param b 태그를 삭제했다면 false, 태그를 추가했다면 true
	 *
	 */
	public void update(String tagName, Boolean b) {
		String query;

		if (b == true) query = "update taglist set t_hit=t_hit+1 where t_name=?";
		else query = "update taglist set t_hit=t_hit-1 where t_name=?";

		int result = this.jdbcTemplate.update(query, tagName);

		log.info("tagName = {}인 태그 {}개 행 수정 성공", tagName, result);
	}
}