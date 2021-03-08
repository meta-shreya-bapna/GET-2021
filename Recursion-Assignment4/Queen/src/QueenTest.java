import static org.junit.Assert.*;
import org.junit.Test;


public class QueenTest {
	int[][] array1={{0,0,1,0},{1,0,0,0},{0,0,0,1},{0,1,0,0}};
	int[][] array2={{1,0,0,0,0},{0,0,0,1,0},{0,1,0,0,0},{0,0,0,0,1},{0,0,1,0,0}};
	int[][] array3={{1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0},{0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,0},{0,0,0,1,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,1,0,0,0,0,0}};

	
	@Test
	public void nQueenTest() throws Exception {
		
		Queen q=new Queen();
		assertArrayEquals(array1,q.createMatrix(4));
		assertArrayEquals(array2,q.createMatrix(5));
		assertArrayEquals(array3,q.createMatrix(8));

	}

}
