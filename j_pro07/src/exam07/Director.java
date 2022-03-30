package exam07;

// 부장
public class Director extends Employee {
	
	private boolean teamManager;	// 팀장직을 가지고 있는지 true, false 로 구분
	private boolean headManager;	// 본부장직을 가지고 있는지 true, false 로 구분

	public Director(String name, int age) {
		super(name, age);
		this.setSalary(8000);
	}

}
