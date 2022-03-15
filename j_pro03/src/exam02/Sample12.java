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
		String[] data = {"가위", "바위", "보"};
		int[][] arrResult = new int[][] {
			{1, 0, 2},
			{2, 1, 0},
			{0, 2, 1}
		};
		int computer, ply = 0;
		int result = 0;		// 지면 0, 비기면 1, 이기면 2
		int[] record = new int[3];
		
		System.out.print("당신의 이름을 입력하세요 : ");
		name = sc.nextLine();
		
		for(;;) {
			System.out.print("가위 바위 보 입력 : ");
			player = sc.nextLine();
			computer = random.nextInt(3);
			
			sCom = data[computer];
			
			if(player.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패", record[0] + record[1] + record[2]
						, record[2], record[1], record[0]);
				break;
			} else if(player.equals("가위") || player.equals("바위") || player.equals("보")) {
				for(int i = 0; i < data.length; i++) {
					if(data[i].equals(player)) {
						ply = i;
						break;
					}
				}
				result = arrResult[ply][computer];
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
