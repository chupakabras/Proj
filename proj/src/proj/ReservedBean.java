package proj;

//Bean class for storing ReservedData
public class ReservedBean {
	private String name;
	private String date;
	private String bdate;
	private String state;
	private String ordDate;
	private int from;
	private int to;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBDate() {
		return bdate;
	}

	public void setBDate(String bdate) {
		this.bdate = bdate;
	}

	public int getRemaining() {
		return 0;
	}

	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
		String[] splitStr = ordDate.split("/");
		int[] split = { Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[1]) };
		from = split[0];
		to = split[1];
	}

	public String getOrdDate() {
		return ordDate;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
