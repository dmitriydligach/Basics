package guava;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

public class GuavaJoiner {

  public static void main(String[] args) {
    
    List<String> elements = Arrays.asList("one", "two", "three");
    Joiner joiner = Joiner.on(',').skipNulls();
    String string = joiner.join(elements);
    System.out.println(string);
  }

}
