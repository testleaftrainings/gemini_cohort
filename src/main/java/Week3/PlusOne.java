package Week3;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

public class PlusOne {
	@Test
	public void plus() {
		int[] digits = {9
				};
		System.out.println(Arrays.toString(plusOne1(digits))); // Print the resulting array
	}

	public int[] plusOne1(int[] digits) {

		String result = "";

		for (int digit : digits) {
			result += digit; // Concatenate digits as a string
		}

		int int1 = Integer.parseInt(result) + 1;

		String numbers = String.valueOf(int1);
		int[] values = new int[numbers.length()];// Convert the incremented integer back to a string

		for (int j = 0; j < numbers.length(); j++) {// Convert the string back to an array of digits
			char charAt = numbers.charAt(j);
			values[j] = Integer.parseInt(String.valueOf(charAt));
		}

		return values; // Return the array of digits
	}
}