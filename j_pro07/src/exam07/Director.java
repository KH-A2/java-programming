package exam07;

// 부장
public class Director extends Employee {
	
	private int corpCardTotal;
	private boolean teamManager;	// 팀장직을 가지고 있는지 true, false 로 구분
	private boolean headManager;	// 본부장직을 가지고 있는지 true, false 로 구분

	public Director(String name, int age) {
		super(name, age);
		this.setSalary(8000);
	}
	
	public void corpCard(int amount) {
		if((getSalary() * 0.015) * 10000 > corpCardTotal + amount) {
			System.out.printf("%,d 원을 법인카드로 지출하였습니다.\n", amount);
			corpCardTotal += amount;
		} else {
			System.out.println("법인 카드 한도를 초과하였습니다.");
			System.out.printf("현재까지 사용액은 %,d원 입니다.\n", corpCardTotal);
			System.out.printf("한도내에서 %,.0f원 만큼만 사용할 수 있습니다.\n", (getSalary() * 0.015) * 10000 - corpCardTotal);
		}
	}

}
