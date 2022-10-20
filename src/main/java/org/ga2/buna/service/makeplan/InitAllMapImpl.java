package org.ga2.buna.service.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.tag.TagDao;
import org.ga2.buna.dto.tag.TagDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InitAllMapImpl {
    private final TagDao tagDao;

    public List<TagDto> get() throws Exception {
        return tagDao.listTag();
    }
}
