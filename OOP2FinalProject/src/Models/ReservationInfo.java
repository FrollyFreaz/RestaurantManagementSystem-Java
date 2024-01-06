package Models;

public class ReservationInfo {
	int number,tableID,clientID,menuN;
	String date;//date of res from java YYYY:MM:DD:HH:MM
	String type;//Birthday
	float finalPrice;
	
	public ReservationInfo(int tableID, int clientID, int menuN, String date, float finalPrice, String type) {
		super();
		this.tableID = tableID;
		this.clientID = clientID;
		this.date = date;
		this.type = type;
		this.menuN=menuN;
		this.finalPrice=finalPrice;
	}
	
	
	public float getFinalPrice() {
		return finalPrice;
	}


	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}


	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getTableID() {
		return tableID;
	}
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMenuN(int menuN) {
		this.menuN=menuN;
	}
	public int getMenuN() {
		return menuN;
	}
	
}
