package language;

import java.math.BigDecimal;

public class BigDecimalTest {

  public static void main(String[] args) {

    System.out.println("max value a double can take: " + Double.MAX_VALUE);
    double result = Math.pow(10, 309); // anything above 308 causes result = Infinity 
    System.out.println(result);
    
    BigDecimal a = new BigDecimal(10);
    BigDecimal b = new BigDecimal(3);
    
    BigDecimal c = a.multiply(b);
    System.out.println(c);
    
    BigDecimal veryLargeNumber = a.pow(1000);
    System.out.println(veryLargeNumber.toEngineeringString());
  }
}
