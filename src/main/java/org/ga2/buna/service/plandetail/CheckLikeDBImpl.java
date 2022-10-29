package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckLikeDBImpl implements CheckLikeDB {

    private final LikeRepository likeDAO;

    @Override
    public int getDB(String nick, int rownum) {

        Integer re = likeDAO.checkLike(rownum, nick);
        log.debug("CheckLikeDB checkLike() 조회 => {}", re);

        return re;
    }
}
