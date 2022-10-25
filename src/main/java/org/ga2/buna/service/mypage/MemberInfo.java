package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.memberinfo.MemberDTO;

public interface MemberInfo {
    MemberDTO list(String nick);
}
