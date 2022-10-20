package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckLikeDBImpl implements CheckLikeDB {

    private final LikeDAO likeDAO;

    @Override
    public Integer getDB(Model model) {

        String nick = (String) model.getAttribute("nick");
        int rownum = Integer.parseInt(String.valueOf(model.getAttribute("rownum")));
        Integer re = likeDAO.checkLike(rownum, nick);

        return re;
    }
}
