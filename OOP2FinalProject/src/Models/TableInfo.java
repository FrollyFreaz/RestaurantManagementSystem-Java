package Models;

public class TableInfo {
	int number;
	String branch;
	int numPeople;
	float price;
	String availability;
	
	public TableInfo(String branch, int numPeople,float price, String availability) {
		super();
		this.branch = branch;
		this.price = price;
		this.numPeople = numPeople;
		this.availability = availability;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	public int getNumPeople() {
		return numPeople;
	}


	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
