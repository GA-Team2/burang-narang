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
public class PlanBoardList implements PlanBoard {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> boardList(String like, String searchTag, int page) {

        if (page != 0) {
            page *= 10;
        }

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
            }
            return popRepository.searchTag(searchTag, page);
        } else {
            if (like == null) {
                return popRepository.popBoard(page);
            } else if (like.equals("true")) {
                return popRepository.likeBoard(page);
            }
        }
        return popRepository.popBoard(page);
    }
}

