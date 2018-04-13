package proj;
//
public class GiftBean {
	
	private String name;
	private String date;
	private int remaining;
	private int reserved;
	
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
}
