
public class Fixxy {

	/**
	 * returns a rearranged array in which X immediately follows Y
	 * @param arr: Input array
	 * @return rearranged array
	 */
	
	public int[] fix(int[] arr) {
		int len=arr.length;
		int x = 4;
		int y = 5;
		int temp;
		
		//if array have no elements
		if(len == 0) 
			throw new AssertionError("Array is empty");
			
		for (int i = 0; i < len; i++) {
			if (arr[i] == x && i!=arr.length-1) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[j]==y && (j==0||arr[j-1]!=x)){
						temp=arr[i+1];
						arr[i+1]=y;
						arr[j]=temp;
                  }
				}
			}
		}
		return arr;
	}
	
//	public static void main(String args[]) 
//	{ 
//		int []arr = new int[]{1,5,4,6,5,4,7};
//		int[] result;
//		result=fix(arr);
//		for (int i = 0; i < result.length; i++) 
//		     System.out.println(result[i]);
//	} 
}