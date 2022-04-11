import java.util.Scanner;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.player.ComPlayer;
import game.player.UserPlayer;
import game.record.Record;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserPlayer uPlay;
		ComPlayer cPlay = new ComPlayer();
		Record uRecord = new Record();
		Record cRecord = new Record();
		
		System.out.println("가위 바위 보 게임 입니다.");
		System.out.println("플레이어 이름을 입력하세요.");
		System.out.print(">>> ");
		String name = sc.nextLine();
		uPlay = new UserPlayer(name);
		
		System.out.println("계속 진행하려면 Enter 키를 입력하세요.");
		sc.nextLine();
		
		while(true) {
			System.out.print("가위 바위 보 중 하나를 입력하세요.\n");
			System.out.print("아무 값도 입력하지 않고 Enter 키를 누르거나 입력 값이 틀린 경우\n");
			System.out.print("임의의 값으로 진행 됩니다.\n");
			System.out.print("종료를 원하는 경우 \"종료\"라고 입력하세요.\n");
			System.out.print(">>> ");
			String pInput = sc.nextLine();
			
			uPlay.setCardHand(pInput);
			cPlay.randomCardHand();
			
			String res = uPlay.versus(cPlay.getHand());
			System.out.printf("%s 님의 승부 결과 %s 했습니다.\n", uPlay.getName(), res);
			
			cPlay.versus(uPlay.getHand());
			
		}
	}

}
