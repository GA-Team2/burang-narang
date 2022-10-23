package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.planboard.PopDTO;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlanBoardList implements PlanBoard{

	private final PopDAO popDAO;

    @Override
    public List<PopDTO> boardList(String like, String searchTag, int startNum) {

            if (startNum != 0){ startNum *= 10; }

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
                return popDAO.searchTag(searchTag, startNum);
            } else {
                if (like == null){
                    return popDAO.popBoard(startNum);
                } else if (like.equals("true")) {
                    return popDAO.boardLike(startNum);
                }
            }
            return popDAO.popBoard(startNum);
        }
    }

