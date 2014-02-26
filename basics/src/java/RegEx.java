package java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String args[]) {

	  String text = "for two minutes every days";
    Pattern pattern = Pattern.compile("(second|min|hour|day)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()) {
      System.out.println("matched: " + matcher.group());
    }
    
		String[] strings = {"12345", "A12345", "12345B", "12345a" , "abcd"};
		for(String string : strings) {
			 System.out.println(string + ": " + string.matches(".*[a-z].*"));
		}
	}
}
