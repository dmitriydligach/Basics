package language;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String args[]) {

	  String string = "for two hours every days";
    Pattern pattern = Pattern.compile("(second|minute|hour|day)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(string);
    while(matcher.find()) {
      System.out.println("matched: " + matcher.group());
    }
    
		String[] alphabets = {"12345", "A12345", "12345B", "12345a" , "abcd" , "aa343"};
		for(String alphabet : alphabets) {
			System.out.println(alphabet + ": " + alphabet.matches(".*[a-z].*"));
		}
		String[] numbers = {"1234" , "+1234", "234a"};
		for(String number : numbers) {
			System.out.println(number + ": " + number.matches(".*[1-9].*"));
		}
	}
}
