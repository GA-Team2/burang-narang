package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditDetail {
    private final PlanDetailRepository planDetailRepository;

    public void updateAll(List<PlanDetailDTO> planDetailDTOList) {
        List<PlanDetailDTO> originDetailList = planDetailRepository.selectByRowNumber(planDetailDTOList.get(0).getPlanRowNumber());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String originFirstDate = simpleDateFormat.format(originDetailList.get(0).getPlanTripDate());
        String originLastDate = simpleDateFormat.format(originDetailList.get(originDetailList.size() - 1).getPlanTripDate());
        String editFirstDate = simpleDateFormat.format(planDetailDTOList.get(0).getPlanTripDate());
        String editLastDate = simpleDateFormat.format(planDetailDTOList.get(planDetailDTOList.size() - 1).getPlanTripDate());

        // 날짜 변경 시
        if(!originFirstDate.equals(editFirstDate) || !originLastDate.equals(editLastDate)) {
            deleteAll(originDetailList);
            saveAll(planDetailDTOList);
        } else {
            isSeq(planDetailDTOList);
        }
    }

    public void saveAll(List<PlanDetailDTO> planDetailDTOList) {
        for (PlanDetailDTO planDetailDTO: planDetailDTOList) {
            save(planDetailDTO);
        }
    }

    public void deleteAll(List<PlanDetailDTO> planDetailDTOList) {
        for (PlanDetailDTO planDetailDTO: planDetailDTOList) {
            delete(planDetailDTO);
        }
    }

    public void isSeq(List<PlanDetailDTO> planDetailDTOList) {

        for (PlanDetailDTO planDetailDTO: planDetailDTOList) {
            int result = planDetailRepository.hasSequence(planDetailDTO);
            PlanDetailDTO origin;

            if(result == 1) {
                origin = planDetailRepository.selectByRowNumberAndTripDayAndSequence(planDetailDTO);
                equalSerialNumber(origin, planDetailDTO);
            } else {
                save(planDetailDTO);
            }
        }
    }

    public void save(PlanDetailDTO planDetailDTO) {
        planDetailRepository.insert(planDetailDTO, planDetailDTO.getPlanRowNumber());
    }

    public void delete(PlanDetailDTO planDetailDTO) {
        planDetailRepository.delete(planDetailDTO);
    }

    public void equalSerialNumber(PlanDetailDTO planDetailDTO1, PlanDetailDTO planDetailDTO2) {
        if(!planDetailDTO1.getSpotSerialNumber().equals(planDetailDTO2.getSpotSerialNumber())) {
            delete(planDetailDTO1);
            save(planDetailDTO2);
        }
    }
}
