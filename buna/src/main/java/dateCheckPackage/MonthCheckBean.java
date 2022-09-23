package dateCheckPackage;

public class MonthCheckBean {
	private int month;
	private String year;
	public int getMonth() {
		return month;
	}
	public void setMonth(String month) {
		if (month.equals("January")) {
			this.month = 1;
		} else if (month.equals("February")) {
			this.month = 2;
		} else if (month.equals("March")) {
			this.month = 3;
		} else if (month.equals("April")) {
			this.month = 4;
		} else if (month.equals("May")) {
			this.month = 5;
		} else if (month.equals("June")) {
			this.month = 6;
		} else if (month.equals("July")) {
			this.month = 7;
		} else if (month.equals("August")) {
			this.month = 8;
		} else if (month.equals("September")) {
			this.month = 9;
		} else if (month.equals("October")) {
			this.month = 10;
		} else if (month.equals("November")) {
			this.month = 11;
		} else if (month.equals("December")) {
			this.month = 12;
		}
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
