package Week3;

import java.util.Arrays;

import org.testng.annotations.Test;

public class MissingNumber {
	
	@Test
	
	public void missednum() {
	    int[] nums = {9,6,4,2,3,5,7,0,1};
	    System.out.println(missingNumber(nums)); // Output should be 2
	}

	public int missingNumber(int[] nums) {
	    Arrays.sort(nums);
	    
	    // Check for missing number
	    for (int i = 0; i < nums.length; i++) {
	        // The expected number should match the index
	        if (nums[i] != i) {
	            return i; // Return the first missing number
	        }
	    }
	    
	    // If no number is missing in the range, it must be nums.length
	    return 0;
	}
    }


