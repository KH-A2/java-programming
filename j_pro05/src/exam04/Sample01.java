package exam04;

public class Sample01 {

	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		// static 예약어를 사용한 변수는 클래스 명으로 사용하는 것을 권장한다.
		StaticTest.share = 20;
		System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		
		StaticTest.share = 30;
		System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		
		StaticTest.share = 40;
		System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		
		FinalTest ft1 = new FinalTest();
		
		System.out.println(ft1.CONSTANT);
		// ft1.CONSTANT = 20;
		
		FinalStaticTest fst1 = new FinalStaticTest();
		FinalStaticTest fst2 = new FinalStaticTest();
		
		System.out.println(fst1.CONSTSHARE + "|" + fst2.CONSTSHARE);
		System.out.println(FinalStaticTest.CONSTSHARE);
		FinalStaticTest.CONSTSHARE = 30;
	}

}
