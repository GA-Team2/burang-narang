package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeDAO;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeImpl implements Like{

    private final LikeDAO likeDAO;
    private final MemberDAO memberDAO;

    @Override
    public Integer likeInsert(HttpSession session, int rownum) {

        log.info("ajax에서 받아온 rownum값 => {}", rownum);
        String nick = (String) session.getAttribute("nick_s");
        log.info("세션에 저장된 nick값 => ", nick);
        MemberDTO member = memberDAO.getMember(nick);

        //추천 여부 확인하는 메서드 호출
        int checkResult = likeDAO.checkLike(rownum, nick);
        log.info("LikeImple checkLike() 조회 => {}", checkResult);

        //추천할 경우 컬럼에 추가될 세대(20대=2,30대=3,...)를 변수 age에 저장
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int age = (year - member.getMemberBirthyear()) / 10;

        //planinfo 테이블의 p_like 컬럼에 추가할 변수 n 지정
        int n = 0;
        //checkResult가 1이면 이미 추천했으므로 deleteLike 메서드 실행
        if (checkResult == 1) {
            likeDAO.deleteLikeInfo(rownum, nick);
            n = -1;
        } else if (checkResult == 0) {
            likeDAO.insertLike(member, rownum, age);
            n = 1;
        }

        //planinfo의 p_like 컬럼 업데이트
        likeDAO.updateLike(rownum, n);

        //planinfo의 p_like 컬럼 값 얻어오기
        return likeDAO.getLikeNum(rownum);
    }
}
