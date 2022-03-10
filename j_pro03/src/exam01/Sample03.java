package exam01;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * 환율 계산 프로그램
		 *		원달러 환율 값 입력 : 1235.00
		 *
		 *		달러를 원화로 계산하겠습니까? 아니면 원화를 달러로 계산하겠습니까?
		 *		(1:달러->원화, 2:원화->달러)
		 *
		 *		달러값 입력 : 100
		 *		100 달러는 123500 원 입니다.
		 *
		 *		원화값 입력 : 100000
		 *		100000 원은 약 80.97 달러 입니다.
		 */
		double rate, doller;
		int menuNumber;
		int won;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원달러 환율 값 입력 : ");
		rate = sc.nextDouble();
		
		System.out.println("달러를 원화로 계산하겠습니가? 아니면 원화를 달러로 계산하겠습니까?");
		System.out.print("(1:달러->원화, 2:원화->달러) -> ");
		menuNumber = sc.nextInt();
		
		if(menuNumber == 1) {
			// 달러 -> 원화
			System.out.print("달러값 입력 : ");
			doller = sc.nextInt();
			won = (int)(doller * rate);
			System.out.printf("%d 달러는 %d 원 입니다.", doller, won);
		} else if(menuNumber == 2) {
			// 원화 -> 달러
			System.out.print("원화값 입력 : ");
			won = sc.nextInt();
			doller = won / rate;
			System.out.printf("%d 원은 약 %.2f 달러 입니다.", won, doller);
		}
	}

}
