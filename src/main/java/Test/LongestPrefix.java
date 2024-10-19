package Test;

import java.util.Arrays;

import org.junit.Test;

public class LongestPrefix {

	@Test
	public void prefix() {

		String[] strs = { "flower", "flow", "flight" };
		System.out.println(longestPrefix(strs));

	}

	public String longestPrefix(String[] strs) {

		Arrays.sort(strs);
		char[] FirstWord = strs[0].toCharArray();
		char[] lastWord = strs[strs.length - 1].toCharArray();

		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {

			if (FirstWord[i] != lastWord[i])
				break;
			stb.append(FirstWord[i]);

		}

		return stb.toString();

	}

	public String longPrefix(String[] strs) {

		String minLetterStr = "";
		String longestPrfx = "";
		for (int i = 0; i < strs.length; i++) {

			for (int j = i + 1; j < strs.length; j++) {
				int length1 = strs[i].length();
				int length2 = strs[j].length();
				if (length1 > length2) {
					minLetterStr = strs[j];// to find the word with least letters which is -flow
					length2 = length1;
				}
				char[] letters = minLetterStr.toCharArray();// get each letter and check if it contains in the other two
															// words
				for (int k = 0; k < letters.length; k++) {
					String subprefix = minLetterStr.substring(0, k + 1); // use substring to add each consecutive
																			// letters and check if it contains
					if (subprefix.contains(strs[i])) {
						longestPrfx = subprefix.toString() + minLetterStr;

					}

				}

			}

		}
		return longestPrfx;
	}
}
