package exam07;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Staff("김사원", 28);
		Employee e2 = new AssistantManager("박대리", 32);
		Employee e3 = new DepartmentManager("이과장", 38);
		Employee e4 = new DeputyGeneralManager("차차장", 43);
		Employee e5 = new Director("곽부장", 48);
		
		e1.payMonth();	e1.bonus();
		e2.payMonth();	e2.bonus();	((AssistantManager)e2).corpCard(460000);
		e3.payMonth();	e3.bonus();	((DepartmentManager)e3).corpCard(610000);
		e4.payMonth();	e4.bonus();	((DeputyGeneralManager)e4).corpCard(826000);
		e5.payMonth();	e5.bonus();	((Director)e5).corpCard(1300000);
	}

}
