package lang;

import java.util.*;

public class JavaClassObject {

	public static void main(String[] args) {
		
		ArrayList obj = new ArrayList();
		
		System.out.println("class: " + obj.getClass().getName());
		System.out.println(ArrayList.class.getName());
	}
}
