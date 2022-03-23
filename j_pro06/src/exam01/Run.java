package exam01;

public class Run {

	public static void main(String[] args) {
		Grade g = new Grade("국어");
		g.setScore(73.4);
		System.out.println(g.getName());
		System.out.println(g.getScore());
		System.out.println(g.getRank());
		
		Grade g1 = new Grade("수학", 85.7);
		System.out.println(g1.getName());
		System.out.println(g1.getScore());
		System.out.println(g1.getRank());
	}

}
