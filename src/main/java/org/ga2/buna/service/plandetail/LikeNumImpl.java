package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeRepository;
import org.springframework.stereotype.Service;

/**
 * 추천수를 얻어오기 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LikeNumImpl implements LikeNum {

    private final LikeRepository likeRepository;

    @Override
    public int getLikeNum(int rownum) {
        //추천수 컬럼의 데이터값 얻어오기
        int likeNum = likeRepository.getLikeNum(rownum);

        return likeNum;
    }
}
