package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface MemberInfo {
    MemberDTO list(String nick);
}
