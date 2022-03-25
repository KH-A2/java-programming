package exam06;

import java.util.Arrays;

import exam05.Person;

public class GradeList {
	/*
	 * Grade 객체를 배열로 만들어서 다루기 위한 객체
	 * 이 객체를 통해 데이터를 추가, 수정, 삭제, 조회
	 * 할 수 있게 한다.
	 */
	private Grade[] gArr = new Grade[0];
	
	public GradeList() {}
	
	public GradeList(int size) {
		this.gArr = new Grade[size];
	}
	
	public GradeList(String ... subjects) {
		// new GradeList("과목1", "과목2", ...)
		this.gArr = new Grade[subjects.length];
		for(int i = 0; i < subjects.length; i++) {
			this.gArr[i] = new Grade(subjects[i]);
		}
	}
	
	public GradeList(Grade[] grade) {
		this.gArr = new Grade[grade.length];
		for(int i = 0; i < grade.length; i++) {
			this.gArr[i] = new Grade(grade[i].getName(), grade[i].getScore());
		}
	}
	
	public Grade get(int index) {
		return this.gArr[index];
	}
	
	public String getName(int index) {
		return this.gArr[index].getName();
	}
	
	public double getScore(int index) {
		return this.gArr[index].getScore();
	}
	
	public int length() {
		return this.gArr.length;
	}
	
	// 추가
	public void add(String name) {
		this.gArr = Arrays.copyOf(this.gArr, length() + 1);
		this.gArr[length() - 1] = new Grade(name);
	}
	
	public void add(String name, double score) {
		this.gArr = Arrays.copyOf(this.gArr, length() + 1);
		this.gArr[length() - 1] = new Grade(name, score);
	}
	
	public void add(Grade grade) {
		this.gArr = Arrays.copyOf(this.gArr, length() + 1);
		this.gArr[length() - 1] = grade;
	}
	
	
	// 수정
	//     1. 수정 할 자료를 찾는다.
	//     2. 찾은 자료에 대해 수정을 한다.
	public void update(String search, String change) {
		
	}
	
	public void update(String search, double change) {
		
	}
	
	public void update(String search, String changeName, double changeScore) {
		
	}
	
	public void update(String search, Grade change) {
		
	}
	
	public void update(int index, String change) {
		
	}
	
	public void update(int index, double change) {
		
	}
	
	public void update(int index, String changeName, double changeScore) {
		
	}
	
	public void update(int index, Grade change) {
		
	}
	
	// 삭제
	
	
	// 조회
	
}
