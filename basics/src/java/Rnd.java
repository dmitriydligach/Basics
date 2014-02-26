package java;

import java.util.Random;

public class Rnd {
	
	public static void main(String[] args) {
		
		double pi = 0.2; // probability of 0
		
		Random rnd = new Random();
		
		for(int i = 0; i < 10; i++) {
			if (rnd.nextDouble() < pi) {
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
		}
		
	}
}
