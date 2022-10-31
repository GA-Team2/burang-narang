package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dao.tag.TagRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.service.makeplan.ToTagList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
@RequiredArgsConstructor
public class EditTag {

    private final ToTagList toTagList;
    private final PlanInfoRepository planInfoRepository;
    private final TagRepository tagRepository;

    public void delete(PlanInfoDTO planInfoDTO) {
        PlanInfoDTO originInfo = planInfoRepository.selectByRowNumber(planInfoDTO.getPlanRowNumber());
        List<String> tagList = toTagList.toTagList(originInfo.getTagNameList());

        for (String tag : tagList) {
            tagRepository.update(tag, false);
        }
    }

    public void update(PlanInfoDTO planInfoDTO) {
        List<String> tagList = toTagList.toTagList(planInfoDTO.getTagNameList());

        for (String tagName : tagList) {
            if (tagRepository.hasTag(tagName) == 1) tagRepository.update(tagName, true);
            else tagRepository.insert(tagName);
        }
    }

}
