package model.vo;

import java.util.Random;

// 학생 정보를 가지는 클래스
public class Student extends Account {
	private Grade[] grades;
	
	public Student(String name) {
		setName(name);
		setPassword("a1111");
	}

	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	@Override
	public String resetPassword() {
		String prefix = "STD_";
		String newPass = super.resetPassword();
		setPassword(prefix + newPass);
		return newPass;
	}
	
}
