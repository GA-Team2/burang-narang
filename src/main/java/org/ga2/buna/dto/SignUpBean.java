package org.ga2.buna.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class SignUpBean {
	//닉네임 필드	
	private String mNickname;
	//패스워드 필드
	private String mPassword;
	//탄생년도 필드
	private int mBirthday;
	//성별 필드
	private int mGender;
	//가입 날짜 필드
	private Timestamp mJoindate;
}
