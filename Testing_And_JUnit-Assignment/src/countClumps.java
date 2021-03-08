
public class countClumps {
		
		/**
		 * Finds no. of clumps in the input array
		 * @param arr: Input array
		 * @return clumps count value in array
		 * @throw Assertion error if array is empty
		 */
		public int countClump(int[] arr) {
			int i;
			int len =arr.length;
			
			//if array have no elements
			if(len == 0) {
				throw new AssertionError("Array is empty");
			}
			int clump=0,currentValue=-1;
			for(i = 0;i<len-1;i++) 
			{
				if(arr[i] == arr[i + 1] && arr[i]!=currentValue) 
				{
					currentValue = arr[i];
					clump++;
				} 
				else 
				{
					if(arr[i] != currentValue) 
					{
						currentValue = -1;
					}
				}
			}
		return clump;
		}
		
//		public static void main(String args[]) 
//		{ 
//			int []arr = new int[]{1,1,1,1,1,1}; 
//			System.out.println(countClump(arr));
//		} 

}
