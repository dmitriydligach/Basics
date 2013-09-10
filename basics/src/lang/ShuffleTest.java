package lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(list);
		
		Collections.shuffle(list, new Random(0));
		System.out.println(list);
	}
}
