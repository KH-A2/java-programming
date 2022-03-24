package exam03;

public class Main {

	public static void main(String[] args) {
		Student std = new Student("빠른홍길동", 13);
		
		std.nextYear();
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getClassLevel());
		System.out.println(std);
	}

}
