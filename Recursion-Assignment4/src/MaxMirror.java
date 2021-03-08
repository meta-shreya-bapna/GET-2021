
public class MaxMirror {

	/**
	 * Finds the size of largest mirror section found
	 * @param arr: Input array
	 * @count of largest mirror in array
	 */
	public int maxMirror(int[] arr) {
		int count = 0;
		int max = 0;
		int i,j,temp;
		int len=arr.length;
		
		//if array have no elements
		if(len == 0) 
			throw new AssertionError("Array is empty");
		
		for(i=0;i<len-1;i++)
		{
			temp=i;
			for(j=len-1; j>=0;j--)
			{
				while(temp<len && j>=0 && arr[temp]==arr[j] )
				{
					temp++;
					j--;
					count++;
				}
				if(count>max)
					max=count;
				
				count=0;
			}
		}
		return max;
	}
	
//	public static void main(String args[]) 
//	{ 
//		int []arr = new int[]{1,4,5,3,5,4,1}; 
//		System.out.println(maxMirror(arr));
//	}

}


	