package guava;

import java.util.*;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class GuavaSorting {

	public static void main(String[] args) {
		
		HashMap<String, Double> hashMap = new HashMap<String, Double>();

    hashMap.put("One", 5.0);
    hashMap.put("Two", 2.0);
    hashMap.put("Three", 3.0);
    hashMap.put("Four", 25.0);
    
    List<String> list = new ArrayList<String>(hashMap.keySet());
    Function<String, Double> getValue = Functions.forMap(hashMap);
    Collections.sort(list, Ordering.natural().onResultOf(getValue));
    System.out.println("order:" + list);
    
    Collections.sort(list, Ordering.natural().reverse().onResultOf(getValue));
    System.out.println("reverse: " + list);
    
    List<String> keys = Lists.newArrayList("One", "Three");
    Collection<Double> values = Collections2.transform(keys, getValue);
    System.out.println("values: " + values);
	}

}
