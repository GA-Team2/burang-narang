package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.like.LikeDAO;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class LikeImpl implements Like{

    private final LikeDAO likeDAO;
    private final MemberDAO memberDAO;

    @Override
    public Integer likeInsert(HttpSession session, int rownum) {

        String nick = (String) session.getAttribute("nick_s");
        MemberDTO member = memberDAO.getMember(nick);

        //추천 여부 확인하는 메서드 호출
        int checkResult = likeDAO.checkLike(rownum, nick);


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int age = (year - member.getMemberBirthyear()) / 10;
        likeDAO.insertLike(member, rownum, age);

        int n = 0;
        //플랜이 공개일 때
        if (checkResult == 1) {
            n = -1;
        //플랜이 비공개일 때
        } else if (checkResult == 0) {
            n = 1;
        }

        likeDAO.updateLike(rownum, n);

        return likeDAO.getLikeNum(rownum);
    }

    @Override
    public void likeDelete(Model model) {

    }
}
