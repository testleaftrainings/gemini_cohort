package Week3;

import org.testng.annotations.Test;

public class NoOfSeniors {

	public class Week3Day2_NoOfSeniors {
		
		/*
	     * 1) Did I understand the problem? -> If yes, go to next step !!
	     *
	     * What is the input(s) type?
	     * string of array
	     * What is the expected output?
	     * int
	     * Do I have constraints to solve the problem?
	     * no constraints
	     * Do I have all informations to go to next step!!
	     * How big is your test data set will be?
	     * 2) Test data set
	     *
	     * Minimum of 3 data set !!
	     * Positive,
	     * 7868190130M6122
	     *
	     * Edge,
	     * 7868190130M6022
	     *
	     * Negative
	     * 7868190130M5822
	     *
	     *
	     * Validate with the interviewer if the data set is fine by his/her assumptions
	     *
	     * 3) Do I know how to solve it?
	     *
	     * Yes - great, is t
	     * */

		@Test
		public void testOne() {
			String[] inpurStrArray = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
			int noOfSeniors = findtheNoOfSeniors(inpurStrArray);
			System.out.println("No of Seniors--->" + noOfSeniors);
		}

		@Test
		public void testTwo() {
			String[] inpurStrArray = { "1313579440F2036", "2921522980M5644" };
			int noOfSeniors = findtheNoOfSeniors(inpurStrArray);
			System.out.println("No of Seniors--->" + noOfSeniors);
		}

		@Test
		public void testThree() {
			String[] inpurStrArray = { "2921522980M6044" };
			int noOfSeniors = findtheNoOfSeniors(inpurStrArray);
			System.out.println("No of Seniors--->" + noOfSeniors);
		}
		
		

		public int findtheNoOfSeniors(String[] inpurStrArray) {
	        int seniorsCount = 0;
	        for(String myStringVal:inpurStrArray)//iterating thru each string
	        {
	           if( Integer.parseInt(myStringVal.substring(11,13))>60)// checking if chat at 13 and 11 position is greater than 60
	           
	               seniorsCount++; //if yes increase the count
	           }
	        
	        return seniorsCount;
	}

	}
	
	
}
