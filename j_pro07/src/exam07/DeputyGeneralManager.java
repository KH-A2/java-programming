package exam07;

// 차장
public class DeputyGeneralManager extends AssistantManager {
	
	private boolean teamManager;	// 팀장직을 가지고 있는지 true, false 로 구분
	private boolean headManager;	// 본부장직을 가지고 있는지 true, false 로 구분
	
	public DeputyGeneralManager(String name, int age) {
		super(name, age);
		this.setSalary(5500);
	}
	
	@Override
	public void bonus(int month) {
		switch(month) {
			case 4: case 8: case 12:
				super.bonus(month);
		}
	}

}
