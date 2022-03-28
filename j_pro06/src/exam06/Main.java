package exam06;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		GradeList gList1 = new GradeList();
		GradeList gList2 = new GradeList(5);
		
		GradeList gList3 = new GradeList("국어", "영어", "수학", "과학");
		for(int i = 0; i < gList3.length(); i++) {
			System.out.println(gList3.getName(i) + ":" + gList3.getScore(i));
		}
		
		System.out.println("==============================");
		
		Grade[] gArr = new Grade[2];
		gArr[0] = new Grade("과학");
		gArr[1] = new Grade("영어");
		
		GradeList gList4 = new GradeList(gArr);
		gArr[0].setName("국어");
		gList4.get(1).setName("수학");
		gList4.add("역사");
		gList4.add("영어", 89.4);
		gList4.add(new Grade("과학", 78.8));
		
		for(int i = 0; i < gList4.length(); i++) {
			System.out.println(gList4.getName(i) + ":" + gList4.getScore(i));
		}
		
		GradeList gList5 = new GradeList();
		gList5.add("과학", 83.6);
		gList5.add("국어", 67.8);
		gList5.add("수학", 82.8);
		gList5.add("영어", 78.4);
		gList5.add("사회", 93.2);
		
		System.out.println(Arrays.toString(gList5.getTop(3)));
		System.out.println(Arrays.toString(gList5.getBottom(3)));
	}

}
