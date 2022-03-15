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
		
		String name, strPly, strCom = "";
		int idxCom, idxPly = 0;
		int result = 0;		// 지면 0, 비기면 1, 이기면 2
		
		String[] data = {"가위", "바위", "보"};
		String[] resMessage = {"졌습니다.", "비겼습니다.", "이겼습니다."};
		int[][] arrResult = new int[][] {
			{1, 0, 2},
			{2, 1, 0},
			{0, 2, 1}
		};
		int[] record = new int[3];
		
		System.out.print("당신의 이름을 입력하세요 : ");
		name = sc.nextLine();
		
		for(;;) {
			System.out.print("가위 바위 보 입력 : ");
			strPly = sc.nextLine();
			
			// exit 입력 되면 바로 전적 출력 후 종료
			if(strPly.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패", record[0] + record[1] + record[2]
						, record[2], record[1], record[0]);
				break;
			}
			
			idxCom = random.nextInt(3);	// 컴퓨터가 생성하는 가위바위보
			strCom = data[idxCom];	// 컴퓨터가 생성한 가위바위보를 문자열로 치환
			
			// 플레이어가 가위바위보를 올바르게 입력한 경우에만 비교 진행.
			if(strPly.equals("가위") || strPly.equals("바위") || strPly.equals("보")) {
				// 플레이어가 입력한 가위바위보를 정수코드로 치환
				for(int i = 0; i < data.length; i++) {
					if(data[i].equals(strPly)) {
						idxPly = i;
						break;
					}
				}
				// 플레이어 코드와 컴퓨터 코드를 배열의 인덱스로 적용하여 승패무 판별
				result = arrResult[idxPly][idxCom];
				
				// 판별된 승패무로 전적 기록
				record[result]++;
				
				System.out.printf("컴퓨터 : %s\n%s : %s\n", strCom, name, strPly);
				System.out.println(resMessage[result]);	// 미리 배열에 만들어 둔 메시지 출력
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
	}

}
