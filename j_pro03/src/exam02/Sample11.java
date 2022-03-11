package exam02;

import java.util.Random;

public class Sample11 {

	public static void main(String[] args) {
		/*
		 * 난수값(랜덤값) 생성
		 * 		import java.util.Random; 를 임포트한 후 다음의 코드 작성
		 */
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(10));	// 0 ~ 9 사이의 난수값 생성;
		}
	}

}
