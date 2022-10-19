package org.ga2.buna.service.makeplan;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.ga2.buna.dao.tag.TagDao;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InitAllMapImpl {
    private final TagDao tagDao;
    private final ObjectMapper mapper;

    public String get() throws Exception {
        return mapper.writeValueAsString(tagDao.listTag());
    }
}