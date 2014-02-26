package language;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class nRandomElementsFromList {

  public static void main(String[] args) {
    
    List<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    
    Collections.shuffle(list);
    
    List<Integer> sample = list.subList(0, 5); // 5 random elements
    
    System.out.println(sample);
  }
}
