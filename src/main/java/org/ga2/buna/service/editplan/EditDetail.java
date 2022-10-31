package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditDetail {
    private final PlanDetailRepository planDetailRepository;

    public void update(PlanDetailDTO planDetailDTO) {
        int result = planDetailRepository.hasSequence(planDetailDTO);
        PlanDetailDTO origin;

        if(result == 1) {
            origin = planDetailRepository.selectByRowNumberAndTripDayAndSequence(planDetailDTO);
        } else {
            planDetailRepository.insert(planDetailDTO, planDetailDTO.getPlanRowNumber());
            return;
        }

        if(!origin.getSpotSerialNumber().equals(planDetailDTO.getSpotSerialNumber())) {
            planDetailRepository.delete(origin);
            planDetailRepository.update(planDetailDTO);
        }
    }
}
