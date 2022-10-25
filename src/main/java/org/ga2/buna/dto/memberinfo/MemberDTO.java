package org.ga2.buna.dto.memberinfo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
public class MemberDTO {

	@NotEmpty
	@Size(min = 1, max = 6)
	private String memberNickname;
	@NotEmpty
	private String memberPassword;
	@NotEmpty
	@Min(1922)
	@Max(2022)
	private int memberBirthyear;
	@NotEmpty
	private int memberGender;
	@NotEmpty
	private Timestamp memberJoindate;
}
