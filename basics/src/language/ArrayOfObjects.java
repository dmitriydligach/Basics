package language;

import java.util.Arrays;

public class ArrayOfObjects {

	public static void main(String[] args) {
		
		Object[] array = new Object[] {"one", "two", 3, 4, true, false};
		
		System.out.println(Arrays.asList(array));
	}

}
