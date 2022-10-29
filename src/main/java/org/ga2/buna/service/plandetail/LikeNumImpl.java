package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeNumImpl implements LikeNum {

    private final LikeRepository likeRepository;

    @Override
    public int getLikeNum(int rownum) {

        Integer likeNum = likeRepository.getLikeNum(rownum);

        return likeNum;
    }
}
