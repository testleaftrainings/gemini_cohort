package Week3;

import org.testng.annotations.Test;

public class AddedChar1 {

    public char findTheDifference(String s, String t) {
        for (char tChar : t.toCharArray()) {
            // Check if tChar is not in s
            if (s.indexOf(tChar) == -1 ){
                return tChar; // Return the extra character
            }
        }
        return ' '; // Default return (not expected to reach here with valid input)
    }

    @Test
    public void test1() {
        String s = "abcd";
        String t = "abcde";
        char result = findTheDifference(s, t);
        System.out.println("Test 1 Result: " + result); // Should print 'e'
    }
    @Test
    public void test2() {
        String s = "";
        String t = "y";
        char result = findTheDifference(s, t);
        System.out.println("Test 1 Result: " + result); // Should print 'e'
    }
}