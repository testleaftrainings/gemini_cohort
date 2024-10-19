package Week2;

import java.util.Arrays;

import org.testng.annotations.Test;

/*
 * Ex: 0, 1, 0, 3, 12 --> 1, 3, 12, 0, 0
 * 
 * 1. Initialize an index variable
 * 2. Iterate through each element in array
 * 3. Compare each element with 0
 * 4. If current is not 0,
 * 		a. take that element and put in the first index
 * 		b. increment current index
 * 5. Iterate from current index till end of array
 * 6. assign the current value with 0
 * 7. increment the current index
 * 
 * 
 * 
 * 1, 1, 0, 3, 12
 * 1, 3, 0, 3, 12
 * 1, 3, 12, 3, 12
 * 1, 3, 12, 0, 12
 * 1, 3, 12, 0, 0
 * 
 */

public class MovingZerosToEnd {

	@Test

	public void test1() {
		int[] nums = { 3, 0, 4, 1, 0, 0 };
		int[] zeroMove = zeroMove(nums);
		System.out.println(Arrays.toString(zeroMove));
	}

	public int[] zeroMove(int[] nums) {
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[a] = nums[i];
				a++;

			}

		}
		for (int i = a; i < nums.length; i++) {
			nums[i] = 0;
			
		}
	return nums;
	
	}

}
