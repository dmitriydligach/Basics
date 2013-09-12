package language;

public class Assignment {

	public static void main(String[] args) {
		
		int a;
		int b;
		
		a = b = 3;
		
		System.out.println(a + "\t" + b + "\t" + (a = b));
	}
}
