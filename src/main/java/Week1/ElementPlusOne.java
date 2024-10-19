package Week1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class ElementPlusOne {
	
	public static void main(String[] args) {
		int[] arr= {1,3,2,3,5,0};
		ElementPlusOne ep=new ElementPlusOne();
		int xplusone = ep.xplusone(arr);
		 System.out.println("Count of elements where (element + 1) is in the array: " + xplusone);
		
	}
	
	public int xplusone(int[] arr) {
		
		//List<Integer> li= new ArrayList<>();
		
		Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
		int count=0;
		for(int i:arr) {
			if(set.contains(i+1)){
				count++;	
			} 
			}
		return count;

	}
	
	@Test
	public void ele() {
		int[] arr= {1,3,2,3,5,0};
		int xplus = xplusone(arr);
		System.out.println("Count of element (x+1): "+xplus);
	}

}
