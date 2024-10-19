package Week3;

import org.testng.annotations.Test;

public class SecondLargestDigitInString {
	@Test
	public void secondlarge() {
		String s="dfa12321afd";
		System.out.println(secondHighest(s));
		
	}
	
	 public int secondHighest(String s) {
		 
		 String withoutNumbers=s.replaceAll("[a-z,A-Z]","");
		 String numberwithNoDuplic="";
		 for(int i=0;i<=withoutNumbers.length();i++) {
			 String currVal = String.valueOf(withoutNumbers.charAt(i));
			 if (!numberwithNoDuplic.contains(currVal)) {
				 numberwithNoDuplic=numberwithNoDuplic+currVal;
			 } 
			 
			 return numberwithNoDuplic.charAt(1);
		 }
 
		 
		return -1;  
	    }

}
