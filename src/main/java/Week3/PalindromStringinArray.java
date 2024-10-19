
package Week3;

import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;



public class PalindromStringinArray {

	@Test
	public void test1() {

		String[] words = { "abc", "car", "ada", "racecar", "cool" };
		System.out.println(firstPalindrome(words));

	}

	@Test
	public void test2() {

		String[] words = { "notapalindrome", "racecar" };
		System.out.println(firstPalindrome(words));

	}

	@Test
	public void test3() {

		String[] words = { "def", "ghi" };
		System.out.println(firstPalindrome(words));

	}

	public String firstPalindrome(String[] words) {

		for (int i = 0; i < words.length; i++) {

			String currWord = words[i];
			String finalWord = "";

			for (int j = currWord.length() - 1; j >= 0; j--) {
				finalWord = finalWord + currWord.charAt(j);
				if (currWord.equals(finalWord)) {
					return finalWord;
				}

			}

		}
		return "";

	}

}
