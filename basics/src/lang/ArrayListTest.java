package lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		List<String> arrayList1 = new ArrayList<String>(Arrays.asList("one", "two", "three"));
		List<String> arrayList2 = new ArrayList<String>(Arrays.asList("four", "five", "six"));

		// merge two lists 
		List<String> arrayList3 = new ArrayList<String>(arrayList1);
		arrayList3.addAll(arrayList2); 
		System.out.println(arrayList3);
		
		String removed = arrayList3.remove(0);
		System.out.println("removed: " + removed);
		System.out.println(arrayList3);
	}
}
