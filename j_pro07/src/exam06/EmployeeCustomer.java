package exam06;

public class EmployeeCustomer extends Customer {
	
	@Override
	public void buy(String productName, int price) {
		price = (int)(price * (1 - 0.1));
		super.buy(productName, price);
	}
}
