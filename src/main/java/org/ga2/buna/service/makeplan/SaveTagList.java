package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.tag.TagDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveTagList {
    private final TagDao tagDao;
    private final ToTagList toTagList;

    public void saveAll(String tagNames) {
        List<String> tagList = toTagList.toTagList(tagNames);

        for (String tagName: tagList) {
            if (tagDao.hasTag(tagName) == true) tagDao.update(tagName, true);
            else tagDao.insert(tagName);
        }
    }
}
