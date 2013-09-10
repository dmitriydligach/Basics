package guava;

import java.util.*;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class GuavaFunction {

  public static void main(String[] args) {

    ArrayList<Integer> oldList = Lists.newArrayList(1, 2, 3);
    
    // first arg is input; second arg is output
    Function<Integer, Double> function = new Function<Integer, Double>() {

			@Override
      public Double apply(Integer input) {
	      return input * 2.0;
      }};
    
    List<Double> newList = Lists.transform(oldList, function);
    
    System.out.println(newList);
	}
}
