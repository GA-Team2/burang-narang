package org.ga2.buna.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private String m_nickname;
	private String m_password;
	private int m_birthyear;
	private int m_gender;
	private Timestamp m_joindate;
	
}
