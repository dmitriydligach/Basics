package language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSlice {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> sub = list.subList(2, 4);
		System.out.println(sub);
	}
}
