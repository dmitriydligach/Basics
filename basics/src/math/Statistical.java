package math;

import org.apache.commons.math3.stat.StatUtils;

public class Statistical {

  /**
   * Apache Commons Math examples.
   * http://commons.apache.org/proper/commons-math/userguide/stat.html
   */
  public static void main(String[] args) {
    
    double[] values = {1, 2, 2, 3, 2, 1, 1, 1};
    double mean = StatUtils.mean(values);
    double std = StatUtils.variance(values);
    System.out.println("mean = " + mean);
    System.out.println("std = " + std);
  }
}
