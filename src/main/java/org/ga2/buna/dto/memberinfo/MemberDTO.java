package org.ga2.buna.dto.memberinfo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * 회원정보 DTO
 *
 * @author 한병태 validtion 추가
 */
@Getter
@Setter
public class MemberDTO {

    //Null 비허용, size(1~12)
    @NotNull
    @Size(min = 1, max = 6)
    private String memberNickname;

    //Null 비허용, password pattern 숫자, 문자, 특수문자 포함, size(8~49)
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    @Size(min = 8, max = 49)
    private String memberPassword;

    //Null 비허용, 최소 숫자 1922, 최대 숫자 2022
    @NotNull
    @Min(1922)
    @Max(2022)
    private int memberBirthyear;

    //Null 비허용
    @NotNull
    private int memberGender;

    //입력값이 아닌 시스템 자체에서 설정되는 회원정보는 validation 제외
    private Timestamp memberJoindate;
}
