public class SparseMatrixInitial {
	private final int row;
	private final int col;
	private final int value;
	
	/**
	 * @param row: row of matrix
	 * @param col: column of matrix
	 * @param value: value inside (row,column)
	 */
	public SparseMatrixInitial(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	
}