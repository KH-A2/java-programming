package exam04;

public class Main {

	public static void main(String[] args) {
		Page p = new Page(100);
		
		for(int i = 0; i < 101; i++) {
			p.nextPage(5);
			System.out.println(p.getPageNumber() + " 번째 페이지");
		}
		
		for(int i = 0; i < 30; i++) {
			p.prevPage(3);
			System.out.println(p.getPageNumber() + " 번째 페이지");
		}
	}

}
