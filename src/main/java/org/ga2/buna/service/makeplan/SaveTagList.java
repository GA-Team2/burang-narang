package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.tag.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveTagList {
    private final TagRepository tagRepository;
    private final ToTagList toTagList;

    public void saveAll(String tagNames) {
        List<String> tagList = toTagList.toTagList(tagNames);

        for (String tagName: tagList) {
            if (tagRepository.hasTag(tagName) == true) tagRepository.update(tagName, true);
            else tagRepository.insert(tagName);
        }
    }
}
