package lang;

public class Enumeration {

	public enum Day {MONDAY, TUESDAY, WEDNESDAY};
	
	public static void main(String[] args) {
		
		Day day = Day.TUESDAY;
		System.out.println("day: " + day);
	}

}
