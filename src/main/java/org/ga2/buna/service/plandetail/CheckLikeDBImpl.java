package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeRepository;
import org.springframework.stereotype.Service;

/**
 * 추천여부 확인을 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CheckLikeDBImpl implements CheckLikeDB {

    private final LikeRepository likeRepository;

    @Override
    public int getDB(String nick, int rownum) {

        //likeinfo 테이블을 조회해서 추천여부 확인
        int re = likeRepository.checkLike(rownum, nick);
        log.debug("CheckLikeDB checkLike() 조회 => {}", re);

        return re;
    }
}
