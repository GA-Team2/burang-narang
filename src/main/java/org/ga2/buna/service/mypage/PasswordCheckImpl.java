package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordCheckImpl implements PasswordCheck {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public int checkpw(Map<String, Object> map) {

        int re = 0;
        String input_pw = (String) map.get("memberPw");
        log.debug("입력받은 비밀번호 => {}", input_pw);
        String nick = (String) map.get("nick");
        log.debug("map에서 꺼낸 nick => {}", nick);
        String db_pw = memberInfoRepository.getPw(nick);
        log.debug("getPw() 호출로 얻은 db_pw => {}", db_pw);

        if (db_pw.equals(input_pw)) {
            //비밀번호 일치
            re = 1;
        } else {
            //비밀번호 불일치
            re = 0;
        }

        return re;
    }

}
