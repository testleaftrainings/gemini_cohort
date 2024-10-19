package Week1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class OccurrenceCounter {

	public Map<Integer, Integer> occurence(int[] input) {
		// Define the input array

		// Create a HashMap to store the occurrences of each integer
		Map<Integer, Integer> output = new HashMap<>();

		// Iterate through the input array
		for (int i = 0; i < input.length; i++) {
			// Check if the current number is already in the map
			if (output.containsKey(input[i])) {
				// Get the current value (count) of this number and increment it by 1
				int curValue = output.get(input[i]);
				output.put(input[i], curValue + 1);
			} else {
				// If the number is not in the map, add it with a count of 1
				output.put(input[i], 1);
			}

		}

		for (Map.Entry<Integer, Integer> entry : output.entrySet()) {
			Integer k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println("Key: " + k + "Value:" + v);
		}
		return output;
	}

	public void majorityElement(int[] input) {
		OccurrenceCounter oc = new OccurrenceCounter();
		Map<Integer, Integer> val = oc.occurence(input);
		
		for(int s: val.keySet()) {		
			if(val.get(s) > (input.length / 2)) 
				System.out.println("Majority Element i:"+s);
			}
		
	}
	

	public static void main(String[] args) {
		int[] input = { 1, 1, 2, 3, 3, 1 };
		OccurrenceCounter oc = new OccurrenceCounter();
		//oc.occurence(input);
		oc.majorityElement(input);

	}

}