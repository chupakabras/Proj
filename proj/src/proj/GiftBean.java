package proj;

//Bean class for storing GiftData
public class GiftBean {

	private String name;
	private String date;
	private int remaining;
	private int reserved;
	private int from;
	private int to;

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
		String[] split = date.split("-");
		from = Integer.parseInt(split[0]);
		to = Integer.parseInt(split[1]);
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public String toString() {
		return (getName() + " " + getDate() + " " + getRemaining() + " " + getReserved());
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
