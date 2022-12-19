package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.springframework.stereotype.Service;

/**
 * 마이페이지 플랜 삭제를 위한 클래스
 * @author 장희정
 */
@Service
@RequiredArgsConstructor
public class DeletePlanInfoImpl implements DeletePlanInfo {

    private final PlanInfoRepository planInfoRepository;

    @Override
    public void deletePlan(int rownum) {
        planInfoRepository.deletePlan(rownum);
    }
}
