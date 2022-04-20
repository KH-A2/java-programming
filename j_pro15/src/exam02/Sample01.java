package exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Set 컬렉션
		 */
		Set<Integer> aSet = new HashSet<Integer>();
		
		boolean result1;
		result1 = aSet.add(100);
		System.out.println(result1 + " " + aSet);
		result1 = aSet.add(200);
		System.out.println(result1 + " " + aSet);
		result1 = aSet.add(200);
		System.out.println(result1 + " " + aSet);
		
		Set<Integer> bSet = new HashSet<Integer>();
		bSet.add(300); bSet.add(400);
		
		result1 = aSet.addAll(bSet);
		System.out.println(result1 + " " + aSet);
		
		List<Integer> cList = new ArrayList<Integer>();
		cList.add(500); cList.add(600); cList.add(100);
		
		result1 = aSet.addAll(cList);
		System.out.println(result1 + " " + aSet);
		
		result1 = aSet.contains(Integer.valueOf(100));
		System.out.println(result1);
		result1 = aSet.contains(Integer.valueOf(150));
		System.out.println(result1);
		
		result1 = aSet.isEmpty();
		System.out.println(result1);
		
		bSet.clear();
		result1 = bSet.isEmpty();
		System.out.println(result1);
		
		int len = aSet.size();
		System.out.println(len + " " + aSet);
		
		result1 = aSet.remove(Integer.valueOf(100));
		System.out.println(result1 + " " + aSet);
		
		result1 = aSet.remove(Integer.valueOf(150));
		System.out.println(result1 + " " + aSet);
		
		Iterator<Integer> iter =  aSet.iterator();
		while(iter.hasNext()) {
			Integer i1 = iter.next();
			System.out.print(i1 + "\t");
		}
		System.out.println();
		
		for(Integer i1: aSet) {
			System.out.print(i1 + "\t");
		}
		System.out.println();
		
		// Set 을 List 로 변경
		List<Integer> aList = new ArrayList<Integer>(aSet);
		System.out.println(aList);
		
		// List 를 Set 으로 변경
		Set<Integer> cSet = new HashSet<Integer>(aList);
		System.out.println(cSet);
		
		// 배열로 변경
		Integer[] iArr = aList.toArray(new Integer[aList.size()]);
		System.out.println(Arrays.toString(iArr));
		iArr = cSet.toArray(new Integer[cSet.size()]);
	}

}
