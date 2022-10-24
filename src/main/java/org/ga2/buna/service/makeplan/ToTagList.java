package org.ga2.buna.service.makeplan;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class ToTagList {
    public List<String> toTagList(String tagNameList) {
        StringTokenizer stringTokenizer = new StringTokenizer(tagNameList);
        List<String> tagList = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            tagList.add(stringTokenizer.nextToken());
        }
        return tagList;
    }
}
