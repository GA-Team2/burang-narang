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
public class PlanSearchNickAjaxList implements PlanSearchNickAjax {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> boardNickListAjax(String nick) {
        return popRepository.searchNickAjax(nick);
    }
}

