import static org.junit.Assert.*;

import org.junit.Test;


public class searchTest {
	
	int []array1 ={3,5,8,9};
	int []array2 ={100,214,542,123,213};
	int []array3 ={32,43,54};
	
	//testing for linear search
	@Test
	public void linearTestSearch() {
		Recursion r=new Recursion();
		assertEquals(0,r.linearSearch(array3,32));
		assertEquals(2,r.linearSearch(array1,8));
		assertEquals(-1,r.linearSearch(array1,10));
		assertEquals(4,r.linearSearch(array2,213));

	}
	
	//testing for binary search
	@Test
	public void binaryTestSearch(){
		Recursion b=new Recursion();
		assertEquals(0,b.binarySearch(array3, 32, 0, array3.length));
		assertEquals(2,b.binarySearch(array1,8, 0, array1.length));
		//assertEquals(-1,b.binarySearch(array1, 10, 0, array1.length));
		//assertEquals(4,b.binarySearch(array2, 213, 0, array2.length));
	}

}
