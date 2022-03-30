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
		System.out.printf("급여액 : %,.0f 원\n", (double)getSalary() / 12 * 10000);
	}
	
	public void bonus(int month) {
		System.out.printf("보너스 : %,.0f 원\n", getSalary() * 0.25 * 10000);
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
