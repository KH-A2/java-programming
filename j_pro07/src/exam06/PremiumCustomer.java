package exam06;

public class PremiumCustomer extends Customer {
	private double discount;
	private int priceTotal;
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) {
		this.priceTotal = priceTotal;
	}

	@Override
	public void buy(String productName, int price) {
		priceTotal += price;
		double p = _calcDiscount(price);
		System.out.printf("%s 상품을 %.2f 할인율 적용하여 %,.1f 원에 구입하였습니다.\n", productName, discount, p);
	}
	
	private double _calcDiscount(int price) {
		if(priceTotal >= 10000000) {
			discount = 0.1;
			return price * (1 - 0.1);
		} else if(priceTotal >= 5000000) {
			discount = 0.05;
			return price * (1 - 0.05);
		} else if(priceTotal >= 3000000) {
			discount = 0.02;
			return price * (1 - 0.02);
		} else {
			return price;
		}
	}
}
