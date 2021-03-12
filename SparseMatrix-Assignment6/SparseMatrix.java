import java.util.*;

class SparseMatrix { 
	
	private SparseMatrixInitial[] sparse;	//to store all sparse elements
	private int row, col; 
	int len; 	// total number of elements in matrix 

	/**
	 * Constructor initializes the Sparse matrix
	 * @param matrix
	 */
	public SparseMatrix(int[][] matrix,int r,int c) 
	{ 
 
		row = r; 
		col = c; 

		int count = 0,index = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(matrix[i][j] !=0){
					count++;
				}
			}
		}
		
		len = count;
		sparse = new SparseMatrixInitial[count];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(matrix[i][j] !=0){
					SparseMatrixInitial sm = new SparseMatrixInitial(i, j, matrix[i][j]);
					sparse[index++] = sm;
				}
			}
		}

	} 


	/**
	 * Function to add Two sparse matrix
	 * @param sparseMatrix: another sparse matrix
	 * @return AdditionMatrix
	 */
	public int[][] addMatrix(SparseMatrix sparseMatrix) throws ArithmeticException{
		if(this.row != sparseMatrix.row 
				|| this.col != sparseMatrix.col){
			throw new ArithmeticException("Dimension are different");
		}
		int[][] addMat = new int[this.row][this.col];
		
		//initialize addMat with first matrix values
		for (int i = 0; i < this.len; i++) {
			addMat[this.sparse[i].getRow()][this.sparse[i].getCol()]
					= this.sparse[i].getValue();
		}
		
		//add 2nd matrix to addMat
		for (int i = 0; i < sparseMatrix.len; i++) {
			addMat[sparseMatrix.sparse[i].getRow()][sparseMatrix.sparse[i].getCol()]
					+= sparseMatrix.sparse[i].getValue();
		}
		return addMat;
	}
	
	/**
	 * Method to perform transpose of sparse matrix
	 * @return transpose matrix
	 */
	public int[][] transposeMatrix(){
		int[][] transpose = new int[row][col]; 
		for (int i = 0; i < len; i++) {
			transpose[this.sparse[i].getCol()][this.sparse[i].getRow()]
					= this.sparse[i].getValue();
		}
		return transpose;
	}
	

	/**
	 * Method for multiplication of two sparse matrix
	 * @param b second matrix
	 * @return multiplication matrix
	 */
	public int[][] multiplyMatrix(SparseMatrix sparseMatrix) throws ArithmeticException{
		if(this.col != sparseMatrix.row){
			throw new ArithmeticException("Dimension mismatch: this.column != sparsematrix.row");
		}
		int[][] mulMat = new int[this.row][sparseMatrix.col];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < sparseMatrix.len; j++) {
				if(this.sparse[i].getCol() == sparseMatrix.sparse[j].getRow())
				mulMat[sparseMatrix.sparse[j].getRow()][this.sparse[i].getCol()]
						+=this.sparse[i].getValue() * sparseMatrix.sparse[j].getValue();
			}
		}
		return mulMat;
	}
	
	 /**
     * To check whether given sparse matrix is symmetric or not, symmetric matrix a matrix that is equal to its transpose
     * @return, true if the matrix is symmetric otherwise false
     */
	public boolean isSymmetric(){
		int[][] transposed = this.transposeMatrix();
		
		for(int i=0;i<len;i++){
			int rowCheck = sparse[i].getRow();
			int colCheck = sparse[i].getCol();
			if(transposed[rowCheck][colCheck] != sparse[i].getValue())
				return false;
		}
		return true;
	}

	
	//main method
	 public static void main(String args[]) 
		{ 
		 	int R1,C1,i,j;
	    	Scanner sc = new Scanner(System.in);
	    	
//	    	matrix1 = {{5,0,3},{0,0,2},{0,1,0}};
//	    	matrix2= {{1,0,0},{0,2,0},{0,0,1}};
			System.out.println("enter dimensions i.e., R and C of 1st sparse matrix to create");
			R1 =sc.nextInt();
			C1=sc.nextInt();
			int[][] matrix1=new int[R1][C1];
			System.out.println("enter "+R1*C1 +" elements of first matrix");
			for(i=0;i<R1;i++)
			{
				for(j=0;j<C1;j++)
				{
					matrix1[i][j]=sc.nextInt();
				}
			}
			
			
			System.out.println("enter second matrix of"+R1+"*"+C1+" to create");
			int[][] matrix2=new int[R1][C1];
			System.out.println("enter "+R1*C1 +" elements");
			for(i=0;i<R1;i++)
			{
				for(j=0;j<C1;j++)
				{
					matrix2[i][j]=sc.nextInt();
				}
			}
			

	    	
	    	SparseMatrix first = new SparseMatrix(matrix1,R1,C1);
	    	SparseMatrix second = new SparseMatrix(matrix2,R1,C1);
	    	
	    	int[][] transposeOfFirstMat = first.transposeMatrix();
	    	int[][] transposeOfSecondMat = second.transposeMatrix();
	    	int[][] addResult = first.addMatrix(second);
	    	int[][] mulResult = first.multiplyMatrix(second);
	    	
	    	System.out.println("Transpose Result (First)");
	    	printMatrix(transposeOfFirstMat,C1,R1);
	    	
	    	System.out.println("Transpose Result (Second)");
	    	printMatrix(transposeOfSecondMat,C1,R1);
	    	
	    	System.out.println("Addition Result");
	    	printMatrix(addResult,R1,C1);

	    	System.out.println("Multiplication Result");
	    	printMatrix(mulResult,R1,C1);
	    	sc.close();
		}
	    
	 /**Method to print matrix
	  * @param mat: resultant matrix
	  * @param row
	  * @param col
	  */
	    public static void printMatrix(int[][] mat,int row,int col){
	    	for(int i=0;i<row;i++){
	    		for(int j=0;j<col;j++){
	    			System.out.print(mat[i][j]+ " ");
	    		}
	    		System.out.println();
	    	}
	    }

}