package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 플랜 디테일 수정 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class EditDetail {
    private final PlanDetailRepository planDetailRepository;

    /**
     * 플랜 디테일 수정 클래스
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     */
    public void updateAll(List<PlanDetailDTO> planDetailDTOList) {
        List<PlanDetailDTO> originDetailList = planDetailRepository.selectByRowNumber(planDetailDTOList.get(0).getPlanRowNumber());

        deleteAll(originDetailList);
        saveAll(planDetailDTOList);
    }

    /**
     * 플랜 디테일 객체 저장하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     */
    public void save(PlanDetailDTO planDetailDTO) {
        planDetailRepository.insert(planDetailDTO, planDetailDTO.getPlanRowNumber());
    }

    /**
     * 플랜 디테일 객체 리스트 저장하는 메서드
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     */
    public void saveAll(List<PlanDetailDTO> planDetailDTOList) {
        for (PlanDetailDTO planDetailDTO : planDetailDTOList) {
            save(planDetailDTO);
        }
    }

    /**
     * 플랜 디테일 객체 삭제하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     */
    public void delete(PlanDetailDTO planDetailDTO) {
        planDetailRepository.delete(planDetailDTO);
    }

    /**
     * 플랜 디테일 객체 리스트 삭제하는 메서드
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     */
    public void deleteAll(List<PlanDetailDTO> planDetailDTOList) {
        for (PlanDetailDTO planDetailDTO : planDetailDTOList) {
            delete(planDetailDTO);
        }
    }
}
