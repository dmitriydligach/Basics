package guava;

import java.util.Arrays;

import com.google.common.collect.ObjectArrays;

public class GuavaArrays {

	public static void main(String[] args) {
		
		String[] array1 = new String[] {"one", "two"};
		String[] array2 = new String[] {"three", "four"};

		// concatenate two arrays into a third
		String[] array3 = ObjectArrays.concat(array1, array2, String.class);
		System.out.println(Arrays.asList(array3));
		
		// add something at the end (or front)
		String[] array4 = ObjectArrays.concat(array3, "five");
		System.out.println(Arrays.asList(array4));
	}

}
