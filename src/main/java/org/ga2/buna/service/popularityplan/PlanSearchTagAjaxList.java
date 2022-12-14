package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planboard.PopRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlanSearchTagAjaxList implements PlanSearchTagAjax {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> boardListAjax(String searchTag) {

        //태그 검색을 했을때 이름 재정의
        if (searchTag != null) {
            switch (searchTag) {
                case "searchTag1":
                    searchTag = popRepository.popTag().get(0).getTagName();
                    break;
                case "searchTag2":
                    searchTag = popRepository.popTag().get(1).getTagName();
                    break;
                case "searchTag3":
                    searchTag = popRepository.popTag().get(2).getTagName();
                    break;
                case "searchTag4":
                    searchTag = popRepository.popTag().get(3).getTagName();
                    break;
                case "searchTag5":
                    searchTag = popRepository.popTag().get(4).getTagName();
                    break;
                case "searchTag6":
                    searchTag = popRepository.popTag().get(5).getTagName();
                    break;
                case "searchTag7":
                    searchTag = popRepository.popTag().get(6).getTagName();
                    break;
                case "searchTag8":
                    searchTag = popRepository.popTag().get(7).getTagName();
                    break;
                case "searchTag9":
                    searchTag = popRepository.popTag().get(8).getTagName();
                    break;
                case "searchTag10":
                    searchTag = popRepository.popTag().get(9).getTagName();
                    break;
            }
            log.debug("searchTag : " + searchTag);
        }
        return popRepository.searchTagAjax(searchTag);
    }
}

