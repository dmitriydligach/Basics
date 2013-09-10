package lang;

import java.util.Iterator;

public class MyIterable implements Iterable<Integer> {

	private MyIterator myIterator;
	
	public MyIterable(Integer[] array) {
		myIterator = new MyIterator(array);
	}
	
	@Override
  public Iterator<Integer> iterator() {
		return myIterator;
  }

	public static void main(String[] args) {

		MyIterable myIterable = new MyIterable(new Integer[] {2, 4, 6, 8, 10});
		
		for(Integer integer : myIterable) {
			System.out.println(integer);
		}
	}
}
