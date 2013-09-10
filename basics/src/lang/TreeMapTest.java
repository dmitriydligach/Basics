package lang;

import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		treeMap.put(10, "dima");
		treeMap.put(2, "lena");
		treeMap.put(0, "buba");
		treeMap.put(5, "masha");
		treeMap.put(3, "trol");
		
		for(Integer key : treeMap.keySet()) {
			System.out.println(key + ": " + treeMap.get(key));
		}
	}
}
