package festiver;

import java.sql.Timestamp;

public class eventDTObean {
	private String S_SERIALNUM;
	private String E_NAME;
	private String E_LOCATION;
	private Timestamp E_STARTDATE;
	private Timestamp E_ENDDATE;
	public String E_PHOTO;
	
	public String getS_SERIALNUM() {
		return S_SERIALNUM;
	}
	public void setS_SERIALNUM(String s_SERIALNUM) {
		S_SERIALNUM = s_SERIALNUM;
	}
	public String getE_NAME() {
		return E_NAME;
	}
	public void setE_NAME(String e_NAME) {
		E_NAME = e_NAME;
	}
	public String getE_LOCATION() {
		return E_LOCATION;
	}
	public void setE_LOCATION(String e_LOCATION) {
		E_LOCATION = e_LOCATION;
	}
	public Timestamp getE_STARTDATE() {
		return E_STARTDATE;
	}
	public void setE_STARTDATE(Timestamp e_STARTDATE) {
		E_STARTDATE = e_STARTDATE;
	}
	public Timestamp getE_ENDDATE() {
		return E_ENDDATE;
	}
	public void setE_ENDDATE(Timestamp e_ENDDATE) {
		E_ENDDATE = e_ENDDATE;
	}
	public String getE_PHOTO() {
		return E_PHOTO;
	}
	public void setE_PHOTO(String e_PHOTO) {
		E_PHOTO = e_PHOTO;
	}
	
	

	

	
}



