package lang;

public class JavaStrings {

	public static void main(String[] args) {

		String str = "one_two_three_four_five";
		String result = str.replaceAll("_", " ");
		System.out.println(result);
	}

}
