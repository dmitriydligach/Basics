package language;

public class ConstructorInMain {

	public ConstructorInMain() {
		System.out.println("constructor called");
	}

	public static void main(String[] args) {
		
		new ConstructorInMain();
	}

}
