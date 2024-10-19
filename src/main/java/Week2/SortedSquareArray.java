package Week2;

import java.util.Arrays;

import org.testng.annotations.Test;

public class SortedSquareArray {
	@Test
	
	public void test() {
		int[] nums= {-7,-3,2,3,11};
		System.out.println(Arrays.toString(sortedSquare(nums)));
		
		
	}
	
	
	public int[] sortedSquare(int[] nums) {
		int[] squares = new int[nums.length];// Creating a new array to store sqr of elems
		
		for(int i=0;i<nums.length;i++) {//iterate through each ele
			
			squares[i]=nums[i]*nums[i];// store the squared values in new array
				
		}
		Arrays.sort(squares);	//sort the new array and return
		return squares;
	}

}
