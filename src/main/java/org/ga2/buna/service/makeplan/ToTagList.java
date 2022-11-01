package org.ga2.buna.service.makeplan;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 플랜 인포에서 받아온 태그 리스트를 토크나이저로 분리하는 클래스
 *
 * @author 한애채
 */
@Service
public class ToTagList {
    /**
     * 받아온 태그 리스트를 토크나이저로 분리해 문자열 리스트를 반환하는 메서드
     *
     * @param tagNameList 태그 이름 리스트 문자열
     * @return 태그 이름 리스트
     */
    public List<String> toTagList(String tagNameList) {
        StringTokenizer stringTokenizer = new StringTokenizer(tagNameList);
        List<String> tagList = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            tagList.add(stringTokenizer.nextToken());
        }
        return tagList;
    }
}
