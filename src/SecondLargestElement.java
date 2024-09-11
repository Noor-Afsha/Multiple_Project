import java.util.Arrays;

public class SecondLargestElement {
	public static void main(String[] args) {
		int[] arr = { 5, 10, 15, 20, 25 };
		Arrays.sort(arr);
		int secondLargest = arr[arr.length - 3];
		System.out.println("Second largest element in the array is: " + secondLargest);
	}
}
