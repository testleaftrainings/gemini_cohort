package Week1;

import java.util.HashMap;
import java.util.Map;

public class hashmapPrac {

	public static void main(String[] args) {
		HashMap<Integer,String> map= new HashMap<>(); 
		map.put(1,"sing");
		map.put(2,"dance");
		
	System.out.println(map);
	int[] ar = {23,43,22};

	for(int i=0;i<ar.length;i++) {
		
				System.out.println(ar[i]);
	}
	
	for(int i:ar) {
		System.out.println(i);
		
		for(Map.Entry<Integer,String> e: map.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			
		}
	}
	
	}
	
	
}
