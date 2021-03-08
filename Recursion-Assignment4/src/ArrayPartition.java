
class ArrayPartition 
{ 
	/**
	 * Finds index of the array where the sum of one side is equal to other
	 * @param arr: Input array
	 * @return index of partition
	 */
	int partition(int []arr)
	{
		int lSum = 0, rSum=0;
		
		//if array have no elements
		if(arr.length == 0) 
			throw new AssertionError("Array is empty");
				
		for (int i = 0; i < arr.length; i++){
		    lSum += arr[i];
		    for (int j = i+1; j < arr.length; j++){
		        rSum += arr[j];
		        }
		    if (lSum == rSum)
		        return i+1;
		    rSum = 0;
		  }
		  return -1;
	}
	

//	public static void main(String args[]) 
//	{ 
//		int []arr = new int[]{ 2,1,1,2,1}; 
//		System.out.println(partition(arr));
//	} 
}

