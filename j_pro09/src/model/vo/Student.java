package model.vo;

// 학생 정보를 가지는 클래스
public class Student {
	/*
	 * 이름(name)과 성적배열(Grade) 를 정의
	 * getter/setter 도 작성
	 */
	private String name;
	private Grade[] grades;
	private String password;
	
	public Student(String name) {
		this.name = name;
		this.password = "1111";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
