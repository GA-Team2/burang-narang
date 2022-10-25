package org.ga2.buna.dto.memberinfo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
public class MemberDTO {

	@NotEmpty
	@Size(min = 1, max = 6)
	private String memberNickname;

	@NotEmpty
	@Pattern(regexp = "[0-9]")
	@Pattern(regexp = "[a-zA-Z]")
	@Pattern(regexp = "[~!@\\#$%<>^&*]")
	@Size(min = 8, max = 49)
	private String memberPassword;

	@NotEmpty
	@Min(1922)
	@Max(2022)
	@PositiveOrZero
	private int memberBirthyear;

	@NotEmpty
	private int memberGender;

	@NotEmpty
	private Timestamp memberJoindate;
}
