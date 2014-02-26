package language;

/**
 * Generic method example.
 */
public class GenericMethod {

  public static <TYPE> void printArray(TYPE[] input) {

    for(TYPE element : input) {        
      System.out.println(element);
    }
  }

  public static void main(String args[]) {
    
    Integer[] array1 = {1, 2, 3};
    String[] array2 = {"one", "two", "three"};
    Character[] array3 = {'o', 't', 't'};
    
    printArray(array1);
    printArray(array2);
    printArray(array3);
  }
}
