package guava;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class WriteToFile {

  public static void main(String[] args) throws IOException {
    
    Files.write("one two\n", new File("/home/dima/temp/out.txt"), Charsets.UTF_8);
    Files.append("three four\n", new File("/home/dima/temp/out.txt"), Charsets.UTF_8);
    Files.append("five six\n", new File("/home/dima/temp/out.txt"), Charsets.UTF_8);
  }
}

