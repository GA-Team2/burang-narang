package org.ga2.buna.dao.tag;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.tag.TagDto;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("SELECT T_NAME as tag_name FROM TAGLIST ORDER BY T_HIT DESC")
    List<TagDto> findAll();
}