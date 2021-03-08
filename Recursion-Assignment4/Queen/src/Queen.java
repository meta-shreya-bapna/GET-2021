import java.util.Scanner;

//column wise implementation
public class Queen 
{
	
	/**
	 * @param mSize is the size of 2-D array
	 * @return solution board of N queens in 2D array
	 * @throws Exception for n<=3
	 */
	public int[][] createMatrix(int mSize)throws Exception
	{
		if(mSize<=3)
		{
			throw new Exception("No Solution exist for N smaller than 3");
		}
		int board[][]=new int[mSize][mSize];
		for(int i=0;i<mSize;i++)
		{
			for( int j=0;j<mSize;j++)
			{
				board[i][j]=0;
			}
		}
		Boolean result = nQueen(board , 0, mSize);
		if(result==true)
		{
			return board;
		}
		else
		{
			System.out.println("No sulution exist for provided dimensions");
			System.exit(-1);
		}
		return null;
	}
	
	/**
	 * Prints the solution
	 * @param board : 2-D array to represent chess board
	 */
	public static void printResult(int[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for( int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * @param board: 2-D array to represent chess board 
	 * @param row
	 * @param col
	 * @param mSize
	 * @return true if queen is safe to place else false
	 */
	boolean isSafe(int board[][], int row, int col, int mSize)
    {
        int i, j;
        
        // Vertical checking for other queens before only
        for (i = 0; i < col; i++)
            {
        		if (board[row][i] == 1)
        			return false;
        		
        	}
        
        // Top Diagonal checking for other queens before only
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            {
        		if (board[i][j] == 1)
        			return false;
        		
            }
        
        // Bottom Diagonal checking for other queens before only
        for (i = row, j = col;i < mSize && j >= 0 ; i++, j--)
            {
        		if (board[i][j] == 1)
        			return false;
        		
            }
 
        return true;
    }
	
	/**
	 * @param board 2D array representing position of queens
	 * @param startCol Column at which queen has to be placed
	 * @param mSize
	 * @return boolean value i.e., true if all queens can be placed
	 */
	Boolean  nQueen(int[][] board, int startCol, int mSize)
	{
		//Only possible if all queens are placed
		if(startCol>=mSize)
		{
			return true;
		}
		
		for(int i=0;i<mSize;i++)
		{
			// Check for possible placement of queen in column
			if(isSafe(board, i, startCol, mSize))
			{
				// Placing queen
				board[i][startCol]=1;
				if(nQueen(board, startCol+1, mSize))
				{
					return true;
				}
				else
				{
				//If queen can't be placed safely
					board[i][startCol]=0; 
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc =new Scanner(System.in);
		Queen obj=new Queen();
		System.out.println("Enter the dimension of matrix : ");
		int mSize=sc.nextInt();
		int result[][]=obj.createMatrix(mSize);
		Queen.printResult(result);
		sc.close();
	}
	
}