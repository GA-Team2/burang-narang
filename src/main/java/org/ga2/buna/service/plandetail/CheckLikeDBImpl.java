package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckLikeDBImpl implements CheckLikeDB {

    private final LikeDAO likeDAO;

    @Override
    public int getDB(String nick, int rownum) {

        Integer re = likeDAO.checkLike(rownum, nick);
        log.debug("CheckLikeDB checkLike() 조회 => {}", re);

        return re;
    }
}
