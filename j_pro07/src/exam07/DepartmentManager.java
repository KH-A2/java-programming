package exam07;

// 과장
public class DepartmentManager extends Employee {

	private boolean teamManager;	// 팀장직을 가지고 있는지 true, false 로 구분
	
	public DepartmentManager(String name, int age) {
		super(name, age);
		this.setSalary(4000);
	}

}
