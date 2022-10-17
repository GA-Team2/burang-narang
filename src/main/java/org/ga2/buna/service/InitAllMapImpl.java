package org.ga2.buna.service;

import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dao.TagDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitAllMapImpl {
    private final TagDao tagDao;

    public String get() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(tagDao.listTag());
    }
}
