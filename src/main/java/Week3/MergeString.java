package Week3;

import org.testng.annotations.Test;

public class MergeString {
	/*
	 * 1) Did I understand the problem? -> If yes, go to next step !!
	 * 
	 * What is the input(s) type? String word1, String word2 What is the expected
	 * output? String Do I have constraints to solve the problem? word1 and word2
	 * consist of lowercase Do I have all informations to go to next step!! yes How
	 * big is your test data set will be?
	 * 
	 * 2) Test data set
	 * 
	 * Minimum of 3 data set !! Positive, Edge, Negative- word1 = "ab", word2 =
	 * "pqrs" word1 = "abcd", word2 = "pq" Validate with the interviewer if the data
	 * set is fine by his/her assumptions
	 * 
	 * 3) Do I know how to solve it?
	 * 
	 * Yes - great, is there an alternate?
	 * 
	 * 4) Ask for hint (If you do not know how to solve)
	 * 
	 * 5) Do I know alternate solutions as well?
	 * 
	 * No - That is still fine, proceed to solve by what you know !!
	 * 
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 * 
	 * Then, explain either both or the best (depends on the time)
	 * 
	 * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
	 * Approach 2: Write down the options and benefits and code the best
	 * 
	 * 7) Start always with Psuedo code // Bruteforce
	 * 
	 * iterate the words with for() get single word with for() check if the work is
	 * palindrome if yes, return and break; else return empty string
	 * 
	 * 8) Implement them in the code (editor)
	 * 
	 * 9) Test against the different data set
	 * 
	 * 10) If it fails, debug them to solve it !!
	 * 
	 * Pseudo get the length of both the String and store if() both the eql then
	 * Iterate through first string and append " " and if i is divisible by 2 then
	 * replace it with ith char in Second string if() length is greater then add
	 * substring(lengthof2ndString)
	 * 
	 */
	@Test
	public void test1() {
		String word1 = "abc";
		String word2 = "pqr";
		System.out.println(mergeAlternately(word1, word2));

	}
	@Test
	public void test2() {
		String word1 = "ab";
		String word2 = "pqrs";
		System.out.println(mergeAlternately(word1, word2));

	}
	@Test
	public void test3() {
		String word1 = "abcd";
		String word2 = "pq";
		System.out.println(mergeAlternately(word1, word2));

	}
	public String mergeAlternately(String word1, String word2) {

		int str1 = word1.length();
		int str2 = word2.length();// get the length of both String
		int minLen;
		String finWord = "";
		if(str1>str2) 
			minLen=str2;
		else
			minLen=str1;// initalize a variable to set the lenght as the one which as the minimum letters
			for (int i = 0; i < minLen; i++) {	
				finWord = finWord + word1.charAt(i) + word2.charAt(i); //adding letters at the position i 1)pq 2)bq and so on..
			}
			if (str1 > minLen) {
		        finWord += word1.substring(minLen);// adding the remaining letter from the word which has noof letter greater than the min
		    } else if (str2 > minLen) {
		        finWord += word2.substring(minLen);
		    }
		
		return finWord;
		

	}}
