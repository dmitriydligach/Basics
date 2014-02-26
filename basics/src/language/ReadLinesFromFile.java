package language;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLinesFromFile {

	public static final String featureFile = "/home/dima/features.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
    File file = new File(featureFile);
    Scanner scan = new Scanner(file);

    while(scan.hasNextLine()) {
      String line = scan.nextLine();
      System.out.println(line);
      String[] elements = line.split(",");
    }
	}
}
