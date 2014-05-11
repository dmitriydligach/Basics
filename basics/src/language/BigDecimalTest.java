package language;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest {

  public static void main(String[] args) {

    System.out.println("max value a double can take: " + Double.MAX_VALUE);
    double result = Math.pow(10, 309); // anything above 308 causes result = Infinity 
    System.out.println("larger than max: " + result);
    
    BigDecimal a = new BigDecimal(10);
    BigDecimal b = new BigDecimal(3);
    BigDecimal c = a.multiply(b);
    System.out.println("a * b = " + c);
    
    // big decimal = unscaled value * 10^-scale
    BigDecimal someNumber = new BigDecimal("23e-4");
    System.out.println("\nnumber: " + someNumber);
    System.out.println("unscaled value: " + someNumber.unscaledValue());
    System.out.println("scale: " + someNumber.scale());
    
    BigDecimal verySmall = new BigDecimal(BigInteger.valueOf(1), 800);
    BigDecimal evenSmaller = new BigDecimal(BigInteger.valueOf(1), 900);
    BigDecimal product = verySmall.multiply(evenSmaller);
    System.out.println("\nproduct: " + product);
    
    double log1 = log(new BigDecimal("4.5e-135"));
    System.out.println("\nlog1: " + log1);
    BigDecimal number = new BigDecimal("4.3820517742918041470545631455024704337120056152343750000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000026925420118198917229790367855457589030265808105468750E-1461");
    double log2 = log(number);
    System.out.println("log: " + log2);
    double log3 = log(number, 2);
    System.out.println("log: " + log3);
  }
  
  /**
   * Calculate log of a big decimal.
   * log10(unsc_val * 10^-scale) = log10(unsc_val) + log10(10^-scale) = log10(unsc_val) - scale
   */
  public static double log(BigDecimal argument) {
    BigInteger unscaledValue = argument.unscaledValue();
    int scale = argument.scale();
    return Math.log10(unscaledValue.doubleValue()) - scale;
  }
  
  public static double log(BigDecimal argument, int numDecimalPlaces) {
    // log10(unsc_val * 10^-scale) = log10(unsc_val) + log10(10^-scale) = log10(unsc_val) - scale
    BigInteger unscaledValue = argument.unscaledValue();
    double unscaledValueRounded = (double) Math.round(unscaledValue.doubleValue() * 10 * numDecimalPlaces) / (10 * numDecimalPlaces);
    int scale = argument.scale();
    return Math.log10(unscaledValueRounded) - scale;
  }
}
