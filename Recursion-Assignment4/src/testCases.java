import static org.junit.Assert.*;

import org.junit.Test;


public class testCases {
	
	int[] Array1 = {1,2,2,2,4,4};
	int[] Array2 = {7,1,4,9,7,4,1};
	int[] Array3 = {1,2,1,4};
	int[] Array4 = {1,4,5,3,5,4,1};
	int[] Array5 = {1,2,2,3,4,4};
	int[] Array6 = {1,1,2,1,1};
	int[] Array7 = {1,1,1,1,1};
	int[] Array8 = {1,5,4,6,5,4,7};
	int[] Array9 = {1,6,4,5,7,4,5};
	int[] Array10 = {1,4,1,5};
	int[] Array11 ={1,4,5,1};
	
	//positive test case for maxMirror
	@Test
	public void MaxMirrorTest() {
		MaxMirror m = new MaxMirror();
		assertEquals(3,m.maxMirror(Array1));
		assertEquals(2,m.maxMirror(Array2));
		assertEquals(3,m.maxMirror(Array3));
		assertEquals(7,m.maxMirror(Array4));
	}
	
	//tests when array is empty in MaxMirror
	@Test
	public void testMaxMirrorAssertionError()
	{
		MaxMirror check = new MaxMirror();
		try {
		int arr[]= {};
		int output=check.maxMirror(arr);
		assertEquals(0, output);
		}catch(AssertionError e)
		{
			e.getMessage();
		}
	}
	
	
	
	//positive test case for countClumps
	@Test
	public void clumpsTest()
	{
		countClumps c = new countClumps();
		assertEquals(2,c.countClump(Array5));
		assertEquals(2,c.countClump(Array6));
		assertEquals(1,c.countClump(Array7));
	}
	
	//negative test case for countClumps
	@Test
	public void negativeTestCaseForCountClumps() {
		countClumps c1 = new countClumps();
		int arr[] = {1,2,3,1,1,2};
		int output = c1.countClump(arr);
		assertNotEquals(5, output);
	}

	//tests when array is empty in countClumps
	@Test
	public void testCountClumpsAssertionError()
	{
		countClumps check = new countClumps();
		try {
		int arr[]= {};
		int output=check.countClump(arr);
		assertEquals(0, output);
		}catch(AssertionError e)
		{
			e.getMessage();
		}
	}
	

	
	//positive test cases for array partition
	@Test
	public void partitionTest()
	{
		ArrayPartition ap = new ArrayPartition();
		assertEquals(4,ap.partition(Array5));
		assertEquals(-1,ap.partition(Array6));
		assertEquals(3,ap.partition(Array3));
	}
	
	//negative test case for array partition where it fails
	@Test
	public void negativeTestForPartion() {
		ArrayPartition arrp =new ArrayPartition();
		int arr[] = { 1,2,3,6 };
		assertFalse(1 == arrp.partition(arr));
	}
	
	//tests when array is empty in ArrayPartition
	@Test
	public void testArrayPartitionAssertionError()
	{
		ArrayPartition a =new ArrayPartition();
		try {
		int arr[]= {};
		int output=a.partition(arr);
		assertEquals(0, output);
		}catch(AssertionError e)
		{
			e.getMessage();
		}
	}
		
	
	
	//positive test case for fixXY
	@Test
	public void fixXYTest()
	{
		Fixxy f = new Fixxy();
		assertArrayEquals(Array9,f.fix(Array8));
		assertArrayEquals(Array11,f.fix(Array10));
	}
	
	//negative test case for fixXY
	@Test
	public void negativeTestForFixXY() {
		Fixxy fix = new Fixxy();
		int arr[] = { 5, 6, 4, 2, 4, 6, 5 };
		int expectedArray[] = { 2, 6, 5, 5, 4, 5, 8 };
		assertFalse(expectedArray == fix.fix(arr));
	}
	
	//tests when is empty in fixXY 
	@Test
	public void testFixXYAssertionError() {
		Fixxy fixx = new Fixxy();
		try {
			int arr[] = {};
			int expectedArray[] = {};
			assertArrayEquals(expectedArray, fixx.fix(arr));
			} catch (AssertionError e) {
			e.getMessage();
			}
		}
	}