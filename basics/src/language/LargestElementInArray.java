package language;

public class LargestElementInArray {

	public static void main(String[] args) {
		
		int[] array = {10,9,80,20,700,25,6,5,4};
		
		int index = -1;
		int largest = array[0];

		for(int i = 0; i < array.length; i++) {
			if(array[i] > largest) {
				largest = array[i];
				index = i;
			}
		}
		
		System.out.println("largest element: " + largest);
		System.out.println("its index: " + index);
	}

}
