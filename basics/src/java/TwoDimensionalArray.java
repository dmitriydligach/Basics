package java;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		// each row can be a different size
		int[][] twoDimArray = new int[3][];
		
		twoDimArray[0] = new int[] {1,2,3};
		twoDimArray[1] = new int[] {10};
		twoDimArray[2] = new int[] {12,11,10,9,8,7,6};
		
		for(int[] array : twoDimArray) {
			for(int element : array) {
				System.out.println(element);
			}
			System.out.println();
		}
	}
}
