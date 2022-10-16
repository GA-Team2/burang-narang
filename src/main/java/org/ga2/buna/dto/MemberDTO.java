package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private String memberNickname;
	private String memberPassword;
	private int memberBirthyear;
	private int memberGender;
	private Timestamp memberJoindate;
	
}
