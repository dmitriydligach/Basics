package lang;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		
    try {
    	FileWriter fileWriter = new FileWriter("/home/dima/temp/temp.txt");
    	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    	bufferedWriter.write("something to write" + "\n");
    	bufferedWriter.close(); // nothing written if this is not done
    } catch (IOException e) {
	    e.printStackTrace();
    }
	}
}
