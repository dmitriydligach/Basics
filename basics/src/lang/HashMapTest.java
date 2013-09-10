package lang;

import java.util.HashMap;

public class HashMapTest {

  public static void main(String[] args) {
    
    HashMap<String, String> hMap = new HashMap<String, String>();
    
    hMap.put("1","One");
    hMap.put("2","Two");
    hMap.put("3","Three");
 
    System.out.println(hMap);
    
    // testing removing from a hashmap
    String removed = hMap.remove("2");
    
    System.out.println(hMap);
    System.out.println("removed: " + removed);
  }
}
