package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

/**
 * 플랜 인포 수정 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class EditInfo {
    private final PlanInfoRepository planInfoRepository;

    /**
     * 플랜 인포 수정 메서드
     *
     * @param planInfoDTO 플랜 인포 객체
     */
    public void update(PlanInfoDTO planInfoDTO) {
        planInfoRepository.update(planInfoDTO);
    }
}
