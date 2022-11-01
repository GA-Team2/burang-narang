package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

/**
 * 플랜 인포 정보 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class PlanInfo {
    private final PlanInfoRepository planInfoRepository;
    private final PlanDetailRepository planDetailRepository;

    /**
     * 해당 게시물 번호를 가지는 플랜 인포 정보 반환하는 메서드
     *
     * @param rowNumber 게시물 번호
     * @return 플랜 인포 객체
     */
    public PlanInfoDTO findInByRowNumber(int rowNumber) {
        return planInfoRepository.selectByRowNumber(rowNumber);
    }

    /**
     * 해당 게시물 번호를 가지는 플랜의 전체 여행 날짜 반환하는 메서드
     *
     * @param rownNumber 게시물 번호
     * @return 해당하는 플랜의 전체 여행 날짜
     */
    public int getTotalTipDay(int rownNumber) {
        return planDetailRepository.getPlanDay(rownNumber);
    }
}
