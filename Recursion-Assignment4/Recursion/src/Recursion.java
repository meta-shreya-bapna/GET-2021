import java.util.Scanner;
public class Recursion {
	static int start=0;

	/**
	 * Linear search of an element in an array
	 * @param arr: Input array
	 * @param x: Element to be searched in array
	 * @return index on which element is found else -1
	 */
	int linearSearch(int arr[], int x)
	{    
		 int last=arr.length-1;
	     if (last < start)
	        return -1;
	     if (arr[start] == x)
	        return start;
	     start++;
	     return linearSearch(arr, x);
	}
	
	/**
	 * Binary search of an element in an array
	 * @param arr: Input array
	 * @param x: Element to be searched in array
	 * @return index on which element is found else -1
	 */
	int binarySearch(int array[], int x, int low, int high) {

	    if (high >= low) 
	    {
	    	int mid = low + (high - low) / 2;
	    	if (array[mid] == x)
	    		return mid;

	    	if (array[mid] > x)
	    		return binarySearch(array, x, low, mid - 1);

	    	return binarySearch(array, x, mid + 1, high);
	     }
	    return -1;
	  }
	
	
      public static void main(String args[])
      {   
    	  int i,len, key;
    	  Recursion obj=new Recursion();
	      Scanner sc = new Scanner(System.in);
      	  System.out.println("Enter Array length:");
      	  len = sc.nextInt(); 
 
      	  int[] array = new int[len]; 
      	  System.out.println("Enter " + len + " elements");
      	   for (i = 0; i < len; i++)
      	  {
        	array[i] = sc.nextInt();
      	  }
      	   
      	  System.out.println("Enter the key value to search :");
	      key = sc.nextInt();
	      
	      System.out.println("Enter your choice to do searching with:\n"+"1. Linear Search\n"+"2. Binary Search");
	      int choice=sc.nextInt();
	      if(choice==1)
	      {
	    	  int index= obj.linearSearch(array,key);
	    	  if (index!=-1) 
	    	  {
	    		  System.out.println(key+" is found at location "+(index+1));
	    	  }
	    	  else
	    	  {
	    		  System.out.println(key + " doesn't exist in array.");
	    	  }
	      }
	      else if(choice==2)
	      {
	    	 int index=obj.binarySearch(array, key, 0, array.length-1); 
	    	 if (index!=-1) 
	    	  {
	    		  System.out.println(key+" is found at location "+(index+1));
	    	  }
	    	  else
	    	  {
	    		  System.out.println(key + " doesn't exist in array.");
	    	  }
	      }
	      else
	      {
	    	  System.out.println("Invalid input!");
	      }
	      sc.close();
      }
}
