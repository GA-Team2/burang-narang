package org.ga2.buna.dao.tag;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.tag.TagDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 새 플랜 추가 페이지의 추천 태그 기능을 위한 DAO 클래스
 *
 * @author 김규빈
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class TagRepository {

    private final TagMapper tagMapper;

    /**
     * 태그들을 등록빈도순으로 정렬하여 조회
     *
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
     */
    public Integer hasTag(String tagName) {
        return tagMapper.hasTag(tagName);
    }

    /**
     * 태그 DB에 새롭게 입력된 태그 정보를 추가하는 메서드 새로운 태그가 추가되면서 태그 hit는 1로 초기화한다.
     *
     * @param tagName 태그 이름
     */
    public void insert(String tagName) {
        tagMapper.insert(tagName);
    }

    /**
     * 태그 DB의 hit 컬럼을 업데이트하는 메서드
     *
     * @param tagName 태그 이름
     * @param b       태그를 삭제했다면 false, 태그를 추가했다면 true
     */
    public void update(String tagName, Boolean b) {
        tagMapper.update(tagName, b);
    }
}