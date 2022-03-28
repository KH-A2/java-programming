package exam02;

public class Main {

	public static void main(String[] args) {
		Student s = new Student();
		s.setName("홍길동");
		s.setAge(16);
		s.setGender('M');
		s.setClassLevel(1);
		s.setClassRoom(5);
		
		Teacher t = new Teacher();
		t.setName("박주성");
		t.setAge(30);
		t.setGender('M');
		t.setClassLevel(1);
		t.setClassRoom(5);
		t.setSubject("영어");
	}

}
