package guava;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class GuavaSets {

  public static void main(String[] args) {

    // initialize sets 
    Set<String> set1 = Sets.newHashSet("a", "b", "c");
    Set<String> set2  = Sets.newHashSet("d", "e");
    Set<List<String>> cartesianProduct = Sets.cartesianProduct(set1, set2);
    
    System.out.println(set1);
    System.out.println(set2);
    System.out.println(cartesianProduct);
  }

}
