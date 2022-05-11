package com.join.view;

import java.util.Scanner;

import com.join.controller.JoinController;
import com.join.vo.JoinVO;

/*
 * CLI 화면에 회원 가입, 탈퇴, 정보 수정 등과 같은
 * 정보를 보여주기 위한 객체로 활용
 */
public class JoinView {
	private Scanner sc = new Scanner(System.in);
	private JoinController jc = new JoinController();
	
	public void show() {
		System.out.println("    회원가입 프로그램    ");
		System.out.println("┌───────────────────────┐");
		System.out.println("│ 1. 회원 가입          │");
		System.out.println("│ 2. 로그인             │");
		System.out.println("└───────────────────────┘");
		
		// 회원 가입 및 로그인 요청에 맞추어 적절한 메서드를 호출한다.
		while(true) {
			System.out.print(">>> ");
			String input = sc.nextLine();

			switch(input) {
				case "1":
					this.joinMenu();	break;
				case "2":
					this.loginMenu();	break;
				default:
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}
	
	private void joinMenu() {
		JoinVO data = new JoinVO();
		// 회원 가입을 위한 화면과 기능 제공
		System.out.print("         아이디 : ");
		data.setUserid(sc.nextLine());
		System.out.print("       패스워드 : ");
		data.setUserpw(sc.nextLine());
		System.out.print("      본인 이름 : ");
		data.setUsername(sc.nextLine());
		System.out.print("    성별(남/여) : ");
		data.setGender(sc.nextLine());
		System.out.print("나이(15세 이상) : ");
		data.setAge(sc.nextLine());
		
		boolean result = jc.join(data);
		
		if(result) {
			System.out.println("회원 가입을 축하합니다.");
		} else {
			System.out.println("회원 가입을 할 수 없습니다.(중복된 아이디가 있습니다.)");
		}
	}
	
	private void loginMenu() {
		// 로그인을 위한 화면과 기능 제공
		System.out.print("  아이디 : ");
		String userid = sc.nextLine();
		
		System.out.print("패스워드 : ");
		String userpw = sc.nextLine();
		
		JoinVO account = jc.login(userid, userpw);
		
		if(account != null) {
			System.out.printf("%s 님이 로그인을 하였습니다.\n", account.getUserid());
		} else {
			System.out.println("로그인에 실패하였습니다.");
		}
	}

}
