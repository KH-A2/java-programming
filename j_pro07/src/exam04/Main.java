package exam04;

public class Main {

	public static void main(String[] args) {
		NormalCustomer c1 = new NormalCustomer();
		
		PremiumCustomer p1 = new PremiumCustomer();
		
		c1.buy("루이비통", 5000000);
		p1.buy("루이비통", 5000000);
	}

}
