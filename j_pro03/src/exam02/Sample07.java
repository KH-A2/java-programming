package exam02;

public class Sample07 {

	public static void main(String[] args) {
		/*
		 * 중첩 반복문
		 */
		for(int i = 1; i <= 3; i++) {
			System.out.println("i 가 1번 반복할 때마다");
			for(int j = 1; j <= 3; j++) {
				System.out.println("j 의 반복은 3번씩 총 9번 이루어진다.");
			}
		}
		
		/*
		 * 구구단.
		 */
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d x %d = %d\t", i, j, i * j);
			}
			System.out.print("\n");
		}
		
		/*
		 * 다음의 결과가 나올수 있도록 중첩반복문을 사용하시오.(띄어쓰기는 \t 를 사용하도록 한다.)
		 * 
		 * 1
		 * 2    3
		 * 4    5    6
		 * 7    8    9    10
		 * 11   12   13   14   15
		 */
		int n = 0;
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(++n + "\t");
			}
			System.out.print("\n");
		}
	}

}
