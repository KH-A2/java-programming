package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher {
	private String name;
	private String password;
	private Date loginDate;	// 로그인 시간
	
	public Teacher(String name) {
		this.name = name;
		this.password = "1111"; // 초기 비밀번호
	}
	
	public Teacher(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginDate() {
		return loginDate;
	}
	
	public String getLoginDateFormat() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		return sFormat.format(loginDate);
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
}
