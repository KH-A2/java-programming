package exam06;

public class NormalCustomer extends Customer {
	private int count;
	private int coupon;
	
	@Override
	public void buy(String productName, int price) {		
		if(coupon >= 1) {
			price = _useCoupon(price);
		}
		
		count++;
		if(count == 10) {
			_addCoupon();
			count = 0;
		}
		
		super.buy(productName, price);
	}
	
	private void _addCoupon() {
		System.out.println("쿠폰을 발급합니다.");
		System.out.println("다음에 물품을 구입할 때 자동으로 해당 쿠폰이 사용됩니다.");
		coupon++;
	}
	
	private int _useCoupon(int price) {
		System.out.println("쿠폰을 사용합니다. 5% 할인이 적용된 금액으로 계산됨니다.");
		price = (int)(price * (1 - 0.05));
		coupon--;
		return price;
	}
}
