package ConvertToUmple;

public class Order {
	int orderNum;
	String dateCreated;
	String itemName;
	
	public void setOrderNum(int n) {
		orderNum = n;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public void setDateCreated(String n) {
		dateCreated = n;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public void setItemName(String s) {
		itemName = s;
	}
	
	public String getItemName() {
		return itemName;
	}
}
