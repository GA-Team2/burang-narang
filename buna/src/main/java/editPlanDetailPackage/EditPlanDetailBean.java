package editPlanDetailPackage;

import java.sql.Timestamp;

public class EditPlanDetailBean {
	private int p_rownum;
	private int p_tripday;
	private Timestamp p_tripdate;
	private int p_sequence;
	private String p_serialnum;
	private String p_spotname;
	
	public int getP_rownum() {
		return p_rownum;
	}
	public void setP_rownum(int p_rownum) {
		this.p_rownum = p_rownum;
	}
	public int getP_tripday() {
		return p_tripday;
	}
	public void setP_tripday(int p_tripday) {
		this.p_tripday = p_tripday;
	}
	public Timestamp getP_tripdate() {
		return p_tripdate;
	}
	public void setP_tripdate(Timestamp tripdate) {
		this.p_tripdate = tripdate;
	}
	public int getP_sequence() {
		return p_sequence;
	}
	public void setP_sequence(int p_sequence) {
		this.p_sequence = p_sequence;
	}
	public String getP_serialnum() {
		return p_serialnum;
	}
	public void setP_serialnum(String p_serialnum) {
		this.p_serialnum = p_serialnum;
	}
	public String getP_spotname() {
		return p_spotname;
	}
	public void setP_spotname(String p_spotname) {
		this.p_spotname = p_spotname;
	}
	
	
}
