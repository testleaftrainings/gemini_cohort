package Week3;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Candies {
	
	
	@Test
	public void candy() {
		
		int[] candyType = {6,6,6,6};
		System.out.println(distributeCandies(candyType));
		
	}
	
	
	
public int distributeCandies(int[] candyType) {
	
      Set<Integer> Sett = new HashSet<>();	// to keep only unquie set of candies
      int n=candyType.length/2;
      
      for(int candy:candyType) {
    	  
    	  Sett.add(candy);
    	
      }
      int sizee = Sett.size();
      
      if(sizee >= n) return n;   // check if size is greater/eql than halfno  of which has to returned
      else
	return sizee;
    }

}
