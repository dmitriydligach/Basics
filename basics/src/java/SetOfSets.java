package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOfSets {

  public static void main(String[] args) {

    Set<Set<String>> set = new HashSet<Set<String>>();
    
    set.add(new HashSet<String>(Arrays.asList("one", "two")));
    set.add(new HashSet<String>(Arrays.asList("three", "two")));
    set.add(new HashSet<String>(Arrays.asList("two", "one")));
    set.add(new HashSet<String>(Arrays.asList("two", "three")));
    
    System.out.println(set);
  }
}
