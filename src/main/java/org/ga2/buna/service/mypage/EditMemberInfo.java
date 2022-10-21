package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.ui.Model;


public interface EditMemberInfo {
    void updateMember(MemberDTO memberDTO, Model model);
}
