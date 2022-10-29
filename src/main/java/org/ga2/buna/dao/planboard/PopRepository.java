package org.ga2.buna.dao.planboard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.planboard.PopDTO;
import org.ga2.buna.dto.tag.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Popularity 페이지에 select해주는 클래스
 *
 * @author 강승구
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class PopRepository {

    private JdbcTemplate jdbcTemplate;
    private final PopMapper popMapper;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 전체 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> topTotal() {
        return popMapper.topTotal();
    }


    /**
     * 남자가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> topMan() {

        return popMapper.topMan();
    }


    /**
     * 여자가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> topWoman() {

        return popMapper.topWoman();
    }


    /**
     * ~20대가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top20() {

        return popMapper.top20();
    }


    /**
     * 30대가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top30() {

        return popMapper.top30();
    }


    /**
     * 40대가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top40() {
//
        return popMapper.top40();
    }


    /**
     * 50대~ 가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top50() {

        return popMapper.top50();
    }


    /**
     * 인기 해시태그 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<TagDto> popTag() {

        return popMapper.popTag();
    }


    /**
     * 해시태그 서치 리스트 메서드
     *
     * @param searchTag 서치된 해시태그
     * @param page      페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> searchTag(String searchTag, int page) {

        return popMapper.searchTag(searchTag, page);
    }

    /**
     * 해시태그 서치 리스트 메서드 Ajax
     *
     * @param searchTag 서치된 해시태그
     * @param page      페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> searchTagAjax(String searchTag) {

        return popMapper.searchTagAjax(searchTag);
    }

    /**
     * 인기플랜공유 페이지 내 게시판 리스트 출력하는 메서드
     *
     * @param page 페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> popBoard(int page) {

        return popMapper.popBoard(page);
    }


    /**
     * 추천순으로 정렬하는 메서드
     *
     * @param page 페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> likeBoard(int page) {

        return popMapper.likeBoard(page);
    }


    /**
     * 총 게시물 개수 구하는 메서드
     *
     * @return 총 게시물 개수
     */
    public Integer countBoard() {

        return popMapper.countBoard();
    }


    /**
     * 서치된 게시물 개수 구하는 메서드
     *
     * @return 게시물 개수
     */
    public Integer countSerchBoard(String searchTag) {

        return popMapper.countSerchBoard(searchTag);
    }
}