package exam04;

public class Sample05 {

	public static void main(String[] args) {
		// 복합 대입 연산
		// 		대입(할당) 연산자와 산술연산이 결합되어 사용되는 연산자.
		// 		산술 연산을 수행 후 대입 연산이 수행하는 형태로 실행된다.
		int num1 = 1;
		
		num1 += 1;	//	++num1;		num1 = num1 + 1;
		System.out.println(num1);
		
		num1 += 2;	// num1 = num1 + 2;
		System.out.println(num1);
		
		num1 -= 3;	// num1 = num1 - 3;
		System.out.println(num1);
		
		num1 *= 4;	// num1 = num1 * 4;
		System.out.println(num1);
		
		num1 /= 2;	// num1 = num1 / 2;
		System.out.println(num1);
		
		num1 %= 2;	// num1 = num1 % 2;
		System.out.println(num1);
		
		// 삼항 연산
		// 		삼항 연산 대신 조건문을 사용하면 되지만, 코드의 길이를 줄이기 위해 가끔씩 사용된다.
		
		/*
		 * 삼항 연산 형식
		 * 		조건식 ? 식1 : 식2;
		 * 
		 * 조건식 : true, false 가 나올 수 있는 식을 작성하면 된다.
		 * 식1 : 조건식의 결과가 참(true)일 때 수행할 식을 작성.
		 * 식2 : 조건식의 결과가 거짓(false)일 때 수행할 식을 작성.
		 */
		
		int age = 19;

		String result = age >= 20 ? "성인 입니다." : "미성년자 입니다.";
		
		System.out.println(result);
		
		
		int num2 = 15;
		
		result = num2 % 2 == 0 ? "짝수" : "홀수";
		
		System.out.printf("%d 는 %s 입니다.", num2, result);
	}

}
