package guava;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class ReadLineByLine {

  public static void main(String[] args) throws IOException {

    File file = new File("/home/dima/temp/data.txt");
    List<String> lines = Files.readLines(file, Charsets.UTF_8);

    for (String line : lines) {
      System.out.println(line);
    }
  }
}
