package language;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class JavaPropertiesTest {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		
		properties.setProperty("name", "dima");
		properties.setProperty("color", "green");
		properties.setProperty("temperature", "hot");
		
		FileOutputStream xmlFileOutputStream = new FileOutputStream("/tmp/configuration.properties.xml");
		FileOutputStream textFileOutputStream = new FileOutputStream("/tmp/configuration.properties.txt");
		
		properties.storeToXML(xmlFileOutputStream, "comment goes here");
		properties.store(textFileOutputStream, "some comment here");
		
		Properties oldProperties = new Properties();
		oldProperties.load(new FileInputStream("/tmp/configuration.properties.txt"));
		System.out.println(oldProperties);
	}
}
