package language;

import java.util.HashSet;
import java.util.Set;

public class JavaSets {

  public static void main(String[] args) {
    // from http://www.java2s.com/Code/Java/Collections-Data-Structure/Showtheunionandinstersectionoftwosets.htm
    
    Set<Integer> s1 = new HashSet<Integer>();
    Set<Integer> s2 = new HashSet<Integer>();
    
    s1.add(1);
    s1.add(2);
    s1.add(3);
    
    s2.add(2);
    s2.add(3);
    s2.add(4);
    
    System.out.println("s2: " + s2);
    System.out.println("memberhsip: " + s2.contains(31));
    
    // need this to preserve s1 and s2
    Set<Integer> intersection = new HashSet<Integer>(s1);
    intersection.retainAll(s2);
    
    System.out.println(intersection);
    System.out.println(s1);
    System.out.println(s2);

    // if use s1.addAll(s2), s1 will change
    Set<Integer> union = new HashSet<Integer>(s1);
    union.addAll(s2);
    
    System.out.println("union: " + union);
    System.out.println(s1);
    System.out.println(s2);
  }

}
