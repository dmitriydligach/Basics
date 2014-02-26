package java;

import java.util.HashMap;
import java.util.Map;

public class MapEntry {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		
		hashMap.put("dima", 0);
		hashMap.put("tim", 2);
		hashMap.put("lena", 4);
		hashMap.put("vita", 5);
		
		for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}
}
