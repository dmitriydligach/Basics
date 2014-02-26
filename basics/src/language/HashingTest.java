package language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HashingTest {

	/**
	 * Testing various @Hashing things.
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("dima", 1);
		map.put("lena", 2);
		map.put("vita", 3);
		
		System.out.println(map);
		map.remove("lena");
		System.out.println(map);
		System.out.println();
		
		// *******************************************
		
		HashMap<HashSet<String>, ArrayList<String>> hash = new HashMap<HashSet<String>, ArrayList<String>>();
		
		HashSet<String> set = new HashSet<String>();
		set.add("gorod");
		set.add("kiev");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("lena");
		list.add("dima");
		
		hash.put(set, list);
		
		System.out.println(hash);
		System.out.println(set.hashCode());
		System.out.println(hash.get(set));
		System.out.println();
		
		// *******************************************
		
		HashSet<String> s = new HashSet<String>(Arrays.asList("numbers", "strings", "small"));
		hash.put(s, new ArrayList<String>(Arrays.asList("one", "two", "three")));
		System.out.println(hash);
	}
}
