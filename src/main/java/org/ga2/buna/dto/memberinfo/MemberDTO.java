package org.ga2.buna.dto.memberinfo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class MemberDTO {
	private String memberNickname;
	private String memberPassword;
	private int memberBirthyear;
	private int memberGender;
	private Timestamp memberJoindate;
}
