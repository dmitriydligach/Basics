package guava;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

public class ReadLineByLineWithCallback {

  public static void main(String[] args) throws IOException {
    
    File file = new File("/home/dima/temp/data.txt");
    Set<String> valuesFromFile = Files.readLines(file, Charsets.UTF_8, new Callback());
    System.out.println(valuesFromFile);
  }
  
  public static class Callback implements LineProcessor <Set<String>> {
    
    public Set<String> values = new HashSet<String>();
    
    public boolean processLine(String line) {
      
      String[] elements = line.split(",");
      for(String element : elements) {
        values.add(element);
      }
      
      return true;
    }
    
    public Set<String> getResult() {
      
      return values;
    }
  }
  
}
