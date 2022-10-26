package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.tag.TagDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanBoardHashtagList implements PlanBoardHashtag {

    private final PopDAO popDAO;

    @Override
    public List<TagDto> findAll() {
        return popDAO.popTag();
    }
}
