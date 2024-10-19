package Week2;

import java.util.Arrays;

import org.testng.annotations.Test;

public class MissingValue {
/*1. Get the length of the array 
2. Sort the array  == [0,1,3] 
3. Iterate through till end 
Array[0]==0; 
1. Array[1]=1 
Array[2]=2 but  3!=2 
  
Return the Array[i] as a missing number right?*/
	@Test
	public void foundMissing() {

		int[] nums = {0,1,2};
		int missingVal = missingVal(nums);
		System.out.println(missingVal);
	}

	public int missingVal(int[] nums) {

		int length = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i < length; i++) {
			if (i != nums[i]) {

				return i;
			}

		}
// Return the total lenght as the value missing is at the position of total lenght-2
		return length;
	}

}
