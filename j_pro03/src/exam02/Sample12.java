package exam02;

import java.util.Scanner;
import java.util.Random;

public class Sample12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		String name, player;
		int computer;
		
		System.out.print("당신의 이름을 입력하세요 : ");
		name = sc.nextLine();
		
		for(;;) {
			System.out.print("가위 바위 보 입력 : ");
			player = sc.nextLine();
			computer = random.nextInt(3);
			
			System.out.println(computer);
			
			if(player.equals("exit")) {
				break;
			} else if(player.equals("가위")) {
				if(computer == 0) {
					System.out.println("비겼습니다.");
				} else if(computer == 1) {
					System.out.println("졌습니다.");
				} else if(computer == 2) {
					System.out.println("이겼습니다.");
				}
			} else if(player.equals("바위")) {
				if(computer == 0) {
					System.out.println("이겼습니다.");
				} else if(computer == 1) {
					System.out.println("비겼습니다.");
				} else if(computer == 2) {
					System.out.println("졌습니다.");
				}
			} else if(player.equals("보")) {
				if(computer == 0) {
					System.out.println("졌습니다.");
				} else if(computer == 1) {
					System.out.println("이겼습니다.");
				} else if(computer == 2) {
					System.out.println("비겼습니다.");
				}
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

}
