package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeNumImpl implements LikeNum {

    private final LikeDAO likeDAO;

    @Override
    public int getLikeNum(int rownum) {

        Integer likeNum = likeDAO.getLikeNum(rownum);

        return likeNum;
    }
}
