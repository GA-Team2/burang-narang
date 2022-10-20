package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.planboard.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanBoardList implements PlanBoard{

    private final PopDAO popDAO;

//    @Override
//    public List<PopDTO> boardList(boolean like, String searchTag) {
//
//        System.out.println("searchTag@@@@@@@@@@@@@@ = " + searchTag);
//
//        System.out.println("!@#!@#!@#!@#!@#!@#0 = " + popDAO.popTag().get(0).getTagName());
//
//        if (searchTag != null) {
//            switch (searchTag){
//                case "searchTag1" : searchTag = popDAO.popTag().get(0).getTagName();
//                    break;
//                case "searchTag2" : searchTag = popDAO.popTag().get(1).getTagName();
//                    break;
//                case "searchTag3" : searchTag = popDAO.popTag().get(2).getTagName();
//                    break;
//                case "searchTag4" : searchTag = popDAO.popTag().get(3).getTagName();
//                    break;
//                case "searchTag5" : searchTag = popDAO.popTag().get(4).getTagName();
//                    break;
//            }
//            return popDAO.searchTag(searchTag);
//        } else {
//            if (like == true) {
//                return popDAO.boardLike();
//            }
//        }
//        return popDAO.popBoard();
//    }

    @Override
    public List<PopDTO> boardList(String pageNumber, boolean like, String searchTag) {

        if (searchTag != null) {
            switch (searchTag){
                case "searchTag1" : searchTag = popDAO.popTag().get(0).getTagName();
                    break;
                case "searchTag2" : searchTag = popDAO.popTag().get(1).getTagName();
                    break;
                case "searchTag3" : searchTag = popDAO.popTag().get(2).getTagName();
                    break;
                case "searchTag4" : searchTag = popDAO.popTag().get(3).getTagName();
                    break;
                case "searchTag5" : searchTag = popDAO.popTag().get(4).getTagName();
                    break;
            }
            return popDAO.searchTag(searchTag);
        } else {
            if (like == true) {
                return popDAO.boardLike();
            }
        }
        return popDAO.popBoard();
    }
}
