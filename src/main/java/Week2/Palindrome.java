package Week2;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Palindrome {

	@Test
	public void testdata1() {
		int org = 12721;
		System.out.println(rev2(org));
	//	System.out.println(rev(x));

	}

	public boolean rev(int x) {

		String temp = String.valueOf(x);
		int len = temp.length();
		String reversed = "";

		for (int i = len - 1; i >= 0; i--) {
			reversed = reversed + temp.charAt(i);
			if (reversed.equals(temp)) {
				return true;

			}
		}

		return false;
	}

	public boolean rev2(int org) {
int rev=0;
int temp=org;
		while(org>0)
		{
			int lastval=org%10; //getting the last digit %
			rev= (rev*10)+lastval;//to get final revered value * and +
			org=org/10;//to remove last digit every time /
		}
		if(rev==temp)
		{
			return true;
		}
		
		return false;

	}
}
