package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.springframework.stereotype.Service;

/**
 * 플랜 공유를 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SharePlanImpl implements SharePlan {

    private final PlanInfoRepository planInfoRepository;

    @Override
    public int publicUpdate(int rownum, int publicCheck) {
        log.debug("rownum => {}", rownum);
        log.debug("publicCheck => {}", publicCheck);

        //플랜 공개여부 다시 세팅하기 위한 변수 선언
        int n = 0;

        if (publicCheck == 0) {
            n = 1;
        } else if (publicCheck == 1) {
            n = 0;
        }

        planInfoRepository.publicUpdateInfo(rownum, publicCheck, n);

        return n;
    }
}
