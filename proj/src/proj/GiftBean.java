package proj;

public class GiftBean {
	
	private String name;
	private String date;
	private String owner;
	
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String toString() {
		return (getName() + " " + getDate() + " " + getOwner());
	}
	//
}
