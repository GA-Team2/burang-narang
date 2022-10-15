package org.ga2.buna.service;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.TagDao;
import org.ga2.buna.dto.TagDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularTagList implements PopularTag {
    private final TagDao tagDao;

    @Override
    public List<TagDto> findAll() {
        return tagDao.listTag();
    }
}
