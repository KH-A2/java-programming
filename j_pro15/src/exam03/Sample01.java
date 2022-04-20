package exam03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Map 계열 컬렉션
		 */
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		aMap.put("a", 100); aMap.put("b", 200); aMap.put("c", 300);
		aMap.put("d", 100); aMap.put("b", 400); aMap.put("e", 500);
		aMap.put("f", 600); aMap.put("g", 700); aMap.put("h", 800);
		
		
		Integer result1 = aMap.put("h", 900);
		System.out.println(result1 + " " + aMap);
		
		result1 = aMap.put("i", 900);
		System.out.println(result1 + " " + aMap);
		
		boolean result2;
		result2 = aMap.containsValue(Integer.valueOf(900));
		System.out.println(result2);
		
		result2 = aMap.containsKey("a");
		System.out.println(result2);
		
		Set<Entry<String, Integer>> entrys = aMap.entrySet();
		Iterator<Entry<String, Integer>> iter = entrys.iterator();
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		for(Entry<String, Integer> entry: aMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		for(String s: aMap.keySet()) {
			System.out.print(s + "\t");
		}
		System.out.println();
		
		for(Integer i: aMap.values()) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		result1 = aMap.get("a");
		System.out.println(result1);
		
		result1 = aMap.get("k");
		System.out.println(result1);
		
		result1 = aMap.getOrDefault("k", Integer.valueOf(-1));
		System.out.println(result1);
		
		result1 = aMap.remove("a");
		System.out.println(result1 + " " + aMap);
		
		aMap.remove("b", Integer.valueOf(300));
		System.out.println(aMap);
		aMap.remove("b", Integer.valueOf(400));
		System.out.println(aMap);
		
	}

}
