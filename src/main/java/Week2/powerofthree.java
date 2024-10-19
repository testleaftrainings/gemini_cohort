package Week2;

import org.testng.annotations.Test;

public class powerofthree {

	@Test
	public void testdata() {
		int n = 27;
		boolean powerof3 = powerof3(n);
		System.out.println("Is "+n+" a power of three:"+ powerof3);

	}

	public boolean powerof3(int n) {

		if (n == 0)
			return false;
		while (n != 1) {
			int r = n % 3; // get the remainder
			n = n / 3;// 2nd-Set to 9-to divide with 3 until the remainder is 0; 3rd-Set to 3-to divide with 3 until the remainder is 0
			if (r != 0)//check if remainder is finally 0, else again divide
				return false;

		}

		return true;

	}

}
