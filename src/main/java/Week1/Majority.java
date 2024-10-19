package Week1;

import java.util.HashMap;
import java.util.Map;

public class Majority {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		Majority mj = new Majority();
		int result = mj.majorityEle(nums);
		if (result != 0) {
			System.out.println("Majority element: " + result);
		} else {
			System.out.println("No majority element");
		}
	}

	public int majorityEle(int[] nums) {
		int l = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();

		// Count occurrences of each number
		for (int i = 0; i < l; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		// Check for the majority element
		for (Integer key : map.keySet()) {
			if (map.get(key) > l / 2) {
				return key;

				// alternate
//              if (map.get(nums[i]) > l/2) {
//      			return nums[i];
			}
		}

		// no majority element is found
		return 0;
	}
}