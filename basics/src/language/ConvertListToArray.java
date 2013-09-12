package language;

import java.util.Arrays;
import java.util.List;

public class ConvertListToArray {

	public static void main(String[] args) {
		
		// strange -- does it instantiate List?
		List<String> list = Arrays.asList("one", "two", "three", "four");
		
		// toArray() will make a new array of size 4
		String[] array1 = list.toArray(new String[0]);
		System.out.println(Arrays.asList(array1));
		
		// toArray(...) will copy element of list to array created in <...> 
		String[] array2 = list.toArray(new String[list.size()]);
		System.out.println(Arrays.asList(array2));
		
		// create the output array first
		String[] array3 = new String[list.size()];
		list.toArray(array3);
		System.out.println(Arrays.asList(array3));
	}
}
