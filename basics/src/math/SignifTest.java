package math;

import org.apache.commons.math3.stat.inference.TestUtils;

public class SignifTest {

  public static void main(String[] args) {
    
    double[] sample1 = {1, 2, 3, 2, 1};
    double[] sample2 = {5, 6, 5, 6, 5};
    
    double pvalue = TestUtils.pairedTTest(sample1, sample2); 
    System.out.println(pvalue);
    
    // true iff p-value returned by TestUtils.pairedTTest(sample1, sample2) < .05
    boolean outcome = TestUtils.pairedTTest(sample1, sample2, 0.01); 
    System.out.println(outcome);
  }
}
