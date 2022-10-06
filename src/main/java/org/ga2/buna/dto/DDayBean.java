package org.ga2.buna.dto;
public class DDayBean {
	//남은 일 수 필드
	private int dDay;
	//null포인터 에러 방지 필드
	private String empty;
	
	public String getEmpty() {
		return empty;
	}

	public void setEmpty(String empty) {
		this.empty = empty;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}
}