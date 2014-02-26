package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator<Integer> {

	private List<Integer> list;
	private int currentPosition;
	
	public MyIterator(Integer[] array) {
		
		currentPosition = 0;
		list = new ArrayList<Integer>();
		list = Arrays.asList(array);
	}
	
	@Override
  public boolean hasNext() {

		if(currentPosition < list.size()) {
			return true;
		} else {
			return false;
		}
  }

	@Override
  public Integer next() {

		return list.get(currentPosition++); 
  }

	@Override
  public void remove() {
	  
  }

	public static void main(String[] args) {
		
		Integer[] array = {1, 10, 100, 1000, 10000};
		MyIterator iteratorStuff = new MyIterator(array);
		
		System.out.println(iteratorStuff.next());
		System.out.println(iteratorStuff.next());
		System.out.println(iteratorStuff.next());
	}
}
