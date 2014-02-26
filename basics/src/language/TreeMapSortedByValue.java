package language;

import java.util.*;

public class TreeMapSortedByValue {

	public static void main(String[] args) {
		
		HashMap<String, Double> hashMap = new HashMap<String, Double>();

    hashMap.put("One", 5.0);
    hashMap.put("Two", 2.0);
    hashMap.put("Three", 3.0);
    hashMap.put("Four", 25.0);
    
    ValueComparator valueComparator = new ValueComparator(hashMap);
    
    TreeMap<String, Double> sortedHashMap = new TreeMap(valueComparator);
    
    sortedHashMap.putAll(hashMap);
    
    for(String key : sortedHashMap.keySet()) {
    	System.out.println(key + " => " + sortedHashMap.get(key));
    }
	}
}

class ValueComparator implements Comparator {
	
	HashMap<String, Double> hashMap;
	
	public ValueComparator(HashMap hashMap) {
		this.hashMap = hashMap;
	}
	
	public int compare(Object o1, Object o2) {
		
		if(hashMap.get(o1) > hashMap.get(o2)) {
			return 1;
		} else if(hashMap.get(o1) == hashMap.get(o2)) {
			return 0;
		} else {
			return -1;
		}
	}
}