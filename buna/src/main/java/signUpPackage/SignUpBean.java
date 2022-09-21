package signUpPackage;

import java.sql.Timestamp;

public class SignUpBean {
	//닉네임 필드	
	private String m_nickname;
	//패스워드 필드
	private String m_password;
	//탄생년도 필드
	private int m_birthyear;
	//성별 필드
	private int m_gender;
	//가입 날짜 필드
	private Timestamp m_joindate;
	
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public int getM_birthyear() {
		return m_birthyear;
	}
	public void setM_birthyear(int m_birthyear) {
		this.m_birthyear = m_birthyear;
	}
	public int getM_gender() {
		return m_gender;
	}
	public void setM_gender(int m_gender) {
		this.m_gender = m_gender;
	}
	public Timestamp getM_joindate() {
		return m_joindate;
	}
	public void setM_joindate(Timestamp m_joindate) {
		this.m_joindate = m_joindate;
	}
}
