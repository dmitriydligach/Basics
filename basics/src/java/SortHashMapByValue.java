package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortHashMapByValue {
	
	@SuppressWarnings("unchecked")
  public static ArrayList<String> sortByValue(final HashMap<String, Double> hashMap) {
		
		ArrayList<String> keys = new ArrayList<String>();
		
		keys.addAll(hashMap.keySet());
		Collections.sort(keys, new Comparator() {
			public int compare(Object key1, Object key2) {
				Double value1 = hashMap.get((String)key1);
				Double value2 = hashMap.get((String)key2);
				return value1.compareTo(value2);
			}
		});
		
		return keys;
	}
	
	
	public static void main(String[] args) {
		
    HashMap<String, Double> hashMap = new HashMap<String, Double>();
    
    hashMap.put("One", 5.0);
    hashMap.put("Two", 2.0);
    hashMap.put("Three", 3.0);
    hashMap.put("Four", 25.0);
 
    for(String key : sortByValue(hashMap)) {
    	System.out.println(key);
    }
	}
}