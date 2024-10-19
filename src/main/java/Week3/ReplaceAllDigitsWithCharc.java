package Week3;

import org.testng.annotations.Test;

public class ReplaceAllDigitsWithCharc {

	@Test
	public void replaced() {

		String s = "a1b2c3d4e";

		System.out.println(replaceDigits2(s));
	}

	
	public String replaceDigits2(String s) {

		String FinalVal = "";
	    
	    for (int i = 0; i < s.length(); i++) {
	    	if(!Character.isDigit(s.charAt(i))){
	    		  FinalVal += s.charAt(i);  // Always add the current character
	    	}
	      
	       
	        // Check if the index is even and not the last character
	        if (i % 2 == 0 && i< s.length()) {
	            char charAti = s.charAt(i);
	            int ascii = (int) charAti + 1; // Increment ASCII value
	            char charValue = (char) ascii;  // Convert back to char
	            FinalVal += charValue; // Append the new char
	        }
	    }
	    
	    return FinalVal;
	}
}
