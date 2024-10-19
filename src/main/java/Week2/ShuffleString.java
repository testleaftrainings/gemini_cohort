package Week2;

import org.testng.annotations.Test;

public class ShuffleString {
	
	@Test
	public void Test() {
		
		int[] arr={4,5,6,7,0,2,1,3};
		String s="codeleet";
		System.out.println(shuffle(s, arr));
		
	}
	
	public String shuffle(String s, int[] arr) {
		
		String[] newarrar= new String[s.length()];
		String finalArr= "";
		
		for(int i=0;i<s.length();i++) {
			
			newarrar[arr[i]] = String.valueOf(s.charAt(i));
		}
		for(String fin:newarrar) {
			
			finalArr=finalArr+fin;
		}
		return finalArr;
		
	}

}
