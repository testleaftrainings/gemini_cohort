package Week3;

import java.util.Arrays;

import org.testng.annotations.Test;

public class LenghtOfLastWord {
	
	
	@Test
	public void test1() {
		
		String s="   fly me   to   the moon  " ;
		System.out.println(lengthOfLastWord(s));
		
	}
	
	
	 public int lengthOfLastWord(String s) {
		 String trimmed = s.trim();
	
		 int finVal=0;
	
	for(int i=trimmed.length()-1;i>0;i--) {
		char val = s.charAt(i);
		
		if(val!=' ') {
			finVal++;
			return finVal;
	}
		
	    }
	return 0;
	

}
	 
//	 public int findLenghtoftheLastWord(String inputString) {
//
//	        String[] wordList=inputString.trim().split(" ");
//	        System.out.println(Arrays.toString(wordList));
//	        return  wordList[wordList.length-1].length();
//	    }
}
