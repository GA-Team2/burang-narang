package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.tag.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 태그 리스트 저장하는 클래스
 *
 * @author 한애채
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SaveTagList {
    private final TagRepository tagRepository;
    private final ToTagList toTagList;

    /**
     * 태그 리스트 저장하는 메서드
     *
     * @param tagNames 태그 이름
     */
    public void saveAll(String tagNames) {
        List<String> tagList = toTagList.toTagList(tagNames);

        for (String tagName : tagList) {
            if (tagRepository.hasTag(tagName) == 1) tagRepository.update(tagName, true);
            else tagRepository.insert(tagName);
        }
    }
}
