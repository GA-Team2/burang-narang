package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckLikeDBImpl implements CheckLikeDB {

    private final LikeRepository likeRepository;

    @Override
    public int getDB(String nick, int rownum) {

        Integer re = likeRepository.checkLike(rownum, nick);
        log.debug("CheckLikeDB checkLike() 조회 => {}", re);

        return re;
    }
}
