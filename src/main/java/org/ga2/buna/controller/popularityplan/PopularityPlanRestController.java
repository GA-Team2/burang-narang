package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.planboard.PopDTO;
import org.ga2.buna.service.popularityplan.*;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/popularity")
public class PopularityPlanRestController {

    private final PlanBoard planBoard;


    @GetMapping(value = "/board",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PopDTO> searchBoardList(String like,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                     String searchTag, Model model) {

        //게시판
//        model.addAttribute("popBoard", planBoard.boardList(like, searchTag, page));

        return planBoard.boardList(like, searchTag, page);
    }
}

