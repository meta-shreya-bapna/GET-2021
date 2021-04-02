import java.util.*;
public interface Graph {
	public boolean isConnected(int root);
	public List<Integer> reachable(int a);
	public Edge[] mst();
	public int shortestPath(int a,int b);
}