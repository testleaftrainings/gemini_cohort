package Week2;

import org.testng.annotations.Test;

public class ArrangingCoins {
	
	
	@Test
	public void completeRows() {
		
		int n=8;
		int completedRows = coins(n);
		System.out.println("No.of rows completed:"+completedRows);
		
	}
	
	
	public int coins(int n) {
		int rows=0;// This will keep track of the total number of coins used in complete rows.
		for(int i=1;i<=n;i++) {
			rows =rows+i; // Add the number of coins required for the current row (i-th row) to the total used coins.
			
			if(rows>n) {// If the total coins used exceeds the number of available coins.
				return i-1;// Return the number of complete rows that can be formed with the available coins.
			}
			
			
		}
		return 0;// If the loop completes, it means we could not even form a single row with the given coins.
		
	}
	

}
