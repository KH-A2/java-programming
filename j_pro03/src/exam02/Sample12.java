package exam02;

import java.util.Scanner;
import java.util.Random;

public class Sample12 {

	public static void main(String[] args) {
		// 배열을 적용한다.
		// 		- 컴퓨터가 생성한 정수 값을 가위, 바위, 보로 치환하기 위한 배열
		//		- 전적 기록을 배열을 사용하여 관리할 수 있도록 한다.
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		String name, player, sCom = "";
		int computer;
		int result = 0;		// 지면 0, 비기면 1, 이기면 2
		int[] record = new int[3];
		
		System.out.print("당신의 이름을 입력하세요 : ");
		name = sc.nextLine();
		
		for(;;) {
			System.out.print("가위 바위 보 입력 : ");
			player = sc.nextLine();
			computer = random.nextInt(3);
			
			if(computer == 0) {
				sCom = "가위";
			} else if(computer == 1) {
				sCom = "바위";
			} else if(computer == 2) {
				sCom = "보";
			}
			
			if(player.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패", record[0] + record[1] + record[2]
						, record[2], record[1], record[0]);
				break;
			} else if(player.equals("가위")) {
				if(computer == 0) {
					result = 1;
				} else if(computer == 1) {
					result = 0;
				} else if(computer == 2) {
					result = 2;
				}
				record[result]++;
			} else if(player.equals("바위")) {
				if(computer == 0) {
					result = 2;
				} else if(computer == 1) {
					result = 1;
				} else if(computer == 2) {
					result = 0;
				}
				record[result]++;
			} else if(player.equals("보")) {
				if(computer == 0) {
					result = 0;
				} else if(computer == 1) {
					result = 2;
				} else if(computer == 2) {
					result = 1;
				}
				record[result]++;
			} else {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}
			
			System.out.printf("컴퓨터 : %s\n%s : %s\n", sCom, name, player);
			switch(result) {
				case 0:
					System.out.println("졌습니다.");
					break;
				case 1:
					System.out.println("비겼습니다.");
					break;
				case 2:
					System.out.println("이겼습니다.");
			}
		}
	}

}
