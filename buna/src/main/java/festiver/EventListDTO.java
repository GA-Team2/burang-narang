package festiver;

import java.sql.Timestamp;

public class EventListDTO {
	private String s_serialnum;
	private String e_name;
	private String e_venue;
	private String e_location;
	private String e_pnumber;
	private Timestamp e_startdate;
	private Timestamp e_enddate;
	private String e_photo;
	private String e_url;
	
	public String getS_serialnum() {
		return s_serialnum;
	}
	public void setS_serialnum(String s_serialnum) {
		this.s_serialnum = s_serialnum;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_location() {
		return e_location;
	}
	public void setE_location(String e_location) {
		this.e_location = e_location;
	}
	public Timestamp getE_startdate() {
		return e_startdate;
	}
	public void setE_startdate(Timestamp e_startdate) {
		this.e_startdate = e_startdate;
	}
	public Timestamp getE_enddate() {
		return e_enddate;
	}
	public void setE_enddate(Timestamp e_enddate) {
		this.e_enddate = e_enddate;
	}
	public String getE_photo() {
		return e_photo;
	}
	public void setE_photo(String e_photo) {
		this.e_photo = e_photo;
	}
	public String getE_url() {
		return e_url;
	}
	public void setE_url(String e_url) {
		this.e_url = e_url;
	}
	public String getE_venue() {
		return e_venue;
	}
	public void setE_venue(String e_venue) {
		this.e_venue = e_venue;
	}
	public String getE_pnumber() {
		return e_pnumber;
	}
	public void setE_pnumber(String e_pnumber) {
		this.e_pnumber = e_pnumber;
	}
	
}
