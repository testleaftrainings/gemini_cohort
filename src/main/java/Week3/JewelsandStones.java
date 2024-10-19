package Week3;

import org.junit.Test;

public class JewelsandStones {

    /*
     * 1) Did I understand the problem? -> If yes, go to next step !!
     *
     * What is the input(s) type?
     * 2 strings
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
     * jewels = "aA", stones = "aAAbbbb"
     *
     * Edge,
     *
     *
     * Negative
     * jewels = "z", stones = "ZZ"
     *
     *
     * Validate with the interviewer if the data set is fine by his/her assumptions
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
     * 6) If you know alternate solutions -> find out the O Notations
     * (Performance)
     *
     * Then, explain either both or the best (depends on the time)
     *
     * Approach 1: Start with worst -> Improve (Optimize) -> End up with the best
     * Approach 2: Write down the options and benefits and code the best
     *
     * 7) Start always with Psuedo code // Bruteforce
     *
     * 8) Implement them in the code (editor)
     *
     * 9) Test against the different data set
     *
     * 10) If it fails, debug t

     * Psudo Code

     *  initialize the counter
     *
     */

    @Test
    public void testOne()
    {
        String jewels ="aA";
        String stones="aAAbbbb";
        int noOfStones= findTheStones(jewels, stones);
        System.out.println(noOfStones);
    }

    @Test
    public void testTwo()
    {
        String jewels ="z";
        String stones="ZZ";
        
        int noOfStones= findTheStones(jewels, stones);
        System.out.println(noOfStones);
    }


    private int findTheStones(String jewels, String stones) {
        int myStoneCount=0;
        /*char[] stoneChar=stones.toCharArray();
        char[] jewelsChar=jewels.toCharArray();
        for(char myStoneChar:stoneChar)
        {
            for(char myjewelsChar:jewelsChar)
            {
                if(myStoneChar==myjewelsChar)
                {
                    myStoneCount++;
                }
            }
        }*/

        for (char stone : stones.toCharArray()) {

            if (jewels.indexOf(stone) != -1) {
                myStoneCount++;
            }

        }
return myStoneCount;
    }
}