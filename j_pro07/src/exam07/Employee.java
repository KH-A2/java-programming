package exam07;

// 직원
public class Employee {
	private String name;
	private int age;
	private char gender;
	private int salary;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void payMonth() {
		System.out.println("급여를 지급하였습니다.");
		System.out.printf("지급액 : %.1f\n", (double)getSalary() / 12);
	}
	
	public void bonus() {
		System.out.println("보너스를 지급하였습니다.");
		System.out.printf("지급액 : %.1f\n", getSalary() * 0.25);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
