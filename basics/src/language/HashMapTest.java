package language;

import java.util.HashMap;

public class HashMapTest {

  public static void main(String[] args) {
    
    HashMap<String, String> map = new HashMap<String, String>();
    
    map.put("1","One");
    map.put("2","Two");
    map.put("3","Three");
    System.out.println("1: " + map);
    
    // update a value in in hashmap; here's what javadoc says:
    // "If the map previously contained a mapping for the key, the old value is replaced by the specified value"
    map.put("2", "this replaces the previous value");
    System.out.println("2: " + map);
    
    // remove a key-value pair from a hashmap
    String removed = map.remove("2");
    System.out.println("3: " + map);
    System.out.println("removed: " + removed);
  }
}
