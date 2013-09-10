package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class GuavaMultiset {

	public static void main(String[] args) {
		
		Multiset<String> multiset = HashMultiset.create();
		
		multiset.add("one");
		multiset.add("two");
		multiset.add("three");
		multiset.add("two");
		multiset.add("two");
		multiset.add("one");
    
		multiset.add("one", 10);
		multiset.add("four", 2); 
    multiset.add("four", 3);
    
		System.out.println("entire multiset: " + multiset);
		System.out.println("unique elements: " + multiset.elementSet());
		
		multiset.setCount("three", 10);
		
		System.out.println("one: " + multiset.count("one"));
		System.out.println("two: " + multiset.count("two"));
 		System.out.println(multiset);
		
		multiset.retainAll(Lists.newArrayList("one", "two"));
		System.out.println(multiset);
	}
}
