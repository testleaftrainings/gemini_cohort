package Week2;

import java.util.Arrays;
import java.util.HashMap;

import org.testng.annotations.Test;

public class TwoSums {
	
	@Test(groups = "group2")
	public void testdata() {
		int[] num= {2,7,11,15};
		int target=9;
		int[] twoSumIndicesHashMap = twoSumIndicesHashMap(num, target);
		System.out.println("Target present at the indices:"+ Arrays.toString(twoSumIndicesHashMap));
	}
	
	@Test(groups = "group1")
	public void testdata2() {
		int[] num= {2,7,11,15};
		int target=9;
		int[] twoSumIndices = twoSumIndices(num, target);
		System.out.println("Target present at the indices:"+ Arrays.toString(twoSumIndices));
	}
	
	
	public int[] twoSumIndices(int[] num, int target) {
		int l=num.length;
		for(int i=0; i<l;i++) {
			for(int j=i+1;i<l;i++) {
				
			if(num[i]+num[j]==target) {
				return new int[] {i,j};
			}
				
			}
			
		}
		return null;

	}

	public int[] twoSumIndicesHashMap(int[] num, int target) {
		
		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		
		for(int i=0;i<num.length;i++) {
			int req_num= target- num[i];
			if(map.containsKey(req_num)) {
				int[] arry= {map.get(req_num),i};
				return arry;
				
			}
			map.put(num[i], i);
		}
		
		
		return num;

	}

	
	
}
