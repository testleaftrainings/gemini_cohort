package Week2;

import java.lang.reflect.Array;

import org.testng.annotations.Test;

public class ClimbingStairs {
	/*
	 * we can step only 1 and 2 steps at a time so removing 1 and 2 steps from total
	 * and adding both the totals we can get the no of ways
	 */
	@Test
	public void climbing() {
		int n = 6;
		System.out.println("No of Ways to climb:"+climbingStair1(n));
	}
	
	public int climbingStair1(int n) {
	    if (n == 0 || n == 1) {
	        return 1;
	    } else {
	        int step1 = 1; // Ways to climb to step 1
	        int step2 = 1; // Ways to climb to step 2
	        int finalStep = 0;
	        
	        for (int i = 2; i <= n; i++) {
	            finalStep = step1 + step2;
	            step1 = step2;
	            step2 = finalStep;
	        }
	        
	        return finalStep;
	    }
	}
		
	

	public int climbingStair(int n) {
// similar to fibonacci series  0 1 1 2 3 5 8 13..
		
		int[] arr = new int[n+1];// to store all ways , so the array needs to be one element larger than
		arr[0] = 1;// only one way to reach 0 step
		arr[1] = 1;// only one way to reach 1 step
		for (int i = 2; i <=n; i++) {//For each step i, the number of ways to get to step i is the sum of the number of ways to get to step i - 1 and step i - 2.
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[n];//Return the number of ways to reach step n from the array arr

	}

//	public int climb(int n) {
//		int nofways = 0;
//		if (n == 0 || n == 1) {
//			return 1;
//		}
//		nofways = climb(n - 1) + climb(n - 2);
//		return nofways;
//	}

}
