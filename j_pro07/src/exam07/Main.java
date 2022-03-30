package exam07;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Staff("김사원", 28);
		Employee e2 = new AssistantManager("박대리", 32);
		Employee e3 = new DepartmentManager("이과장", 38);
		Employee e4 = new DeputyGeneralManager("차차장", 43);
		Employee e5 = new Director("곽부장", 48);
		
		e1.payMonth();	e1.bonus();
		e2.payMonth();	e2.bonus();
		e3.payMonth();	e3.bonus();
		e4.payMonth();	e4.bonus();
		e5.payMonth();	e5.bonus();
	}

}
