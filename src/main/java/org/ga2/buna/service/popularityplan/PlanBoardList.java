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

        //페이지마다 나타낼 게시물
        if (page != 0) {
            page *= 10;
        }

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
            }
            //태그 검색 결과 출력
            return popRepository.searchTag(searchTag, page);
        } else {
            //추천순이 아닐때 정렬
            if (like == null) {
                return popRepository.popBoard(page);
            } else if (like.equals("true")) {
                //추천순 정렬
                return popRepository.likeBoard(page);
            }
        }
        return popRepository.popBoard(page);
    }
}

