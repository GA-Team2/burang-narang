package org.ga2.buna.dao.tag;

import org.apache.ibatis.annotations.*;
import org.ga2.buna.dto.tag.TagDto;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("SELECT T_NAME as tag_name FROM taglist ORDER BY T_HIT DESC")
    List<TagDto> findAll();

    /**
     * 태그 이름 변수를 통해 태그 DB에 해당 태그가 존재하는지 결과를 반환하는 메서드
     */
    @Select("SELECT COUNT(*) FROM taglist WHERE T_NAME = #{tagName}")
    Integer hasTag(String tagName);

    /**
     * 태그 DB에 새롭게 입력된 태그 정보를 추가하는 메서드 새로운 태그가 추가되면서 태그 hit는 1로 초기화한다.
     */
    @Insert("INSERT INTO taglist VALUES(#{tagName}, 1)")
    void insert(String tagName);

    /**
     * 태그 DB의 hit 컬럼을 업데이트하는 메서드
     */
    void update(@Param("tagName") String tagName, @Param("b") Boolean b);
}