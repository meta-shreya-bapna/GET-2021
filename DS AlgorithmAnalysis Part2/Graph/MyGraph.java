import java.util.*;

class Edge implements Comparable<Edge>{
	int source;
	int destination;
	int weight;
	Edge(int s,int d,int w){
		source = s;
		destination = d;
		weight = w;
	}
	
	/**
	 * Used to sort edges on the basis of weight from low to high
	 */
	public int compareTo(Edge compareEdge)
    {
        return this.weight - compareEdge.weight;
    }
}

class subset
{
    int parent, rank;
};


public class MyGraph implements Graph{
	
	List<Edge> graph;
	int V;

	
	MyGraph(int v){
		graph = new ArrayList<Edge>();
		this.V = v;

	}
	
	public void addEdge(int s,int d,int w){
		graph.add(new Edge(s,d,w));
	}

	/*
	 * Method to find if graph is connected or not 
	 * 
	 */
	@Override
	public boolean isConnected(int root) {
		Set<Integer> visited = new HashSet<Integer>();
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(root);
		while(!st.empty()){
			int curr = st.peek();
			st.pop();
			visited.add(curr);
			for(Edge e:graph){
				if(e.source == curr){
					if(!visited.contains(e.destination)){
						st.push(e.destination);
					}
				}
				else if(e.destination == curr){
					if(!visited.contains(e.source)){
						st.push(e.source);
					}
				}
			}
		}
		System.out.println(visited.size());
		return visited.size() == this.V;
	}

	/**
	 * Method to find all the vertices reachable from the given vertex a
	 * @param a:vertex
	 */
	@Override
	public List<Integer> reachable(int a) {
		List<Integer> reachableNodes = new ArrayList<Integer>();
		for(Edge e:graph){
			if(e.source == a){
				reachableNodes.add(e.destination);
			}
			else if(e.destination == a){
				reachableNodes.add(e.source);				
			}
		}
		return reachableNodes;
	}
	
	/**
	 * Finds root and make root as parent  
	 */
    int find(subset subsets[], int i)
    {
       
        if (subsets[i].parent != i)
            subsets[i].parent
                = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
    
    /**
     * Method to make tree from high rank to small rank
     * @param subsets
     * @param x
     * @param y
     */
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xroot].rank
            < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                 > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    /**
     * method to find mst
     */
	@Override
	public Edge[] mst() {
		Edge[] result = new Edge[V];
	       
        // An index variable, used for result[]
        int e = 0;
       
        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge(0,0,0);
 
        //Sorts all the edges in non-decreasing order of their weight.
        Collections.sort(graph);
 
        // Allocate memory for creating V subsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0; 
 
        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            //Pick the smallest edge. And increment the index for next iteration
            Edge next_edge = graph.get(i);
            i++;
 
            int x = find(subsets, next_edge.source);
            int y = find(subsets, next_edge.destination);
 
            // If including this edge does't cause cycle,include it in result and increment the index of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            
        }
 
        System.out.println("Following are the edges in "
                           + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(result[i].source + " -- "
                               + result[i].destination
                               + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                           + minimumCost);
		return result;
	}

	@Override
	public int shortestPath(int a, int b) {
		return 0;
	}

	//main method
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of vertices");
		int v=sc.nextInt();
		MyGraph mg= new MyGraph(v);
		System.out.println("Enter source , destination and weight of 1st node");
		int src=sc.nextInt();
		mg.addEdge(src, sc.nextInt(), sc.nextInt());
		for(int i=1;i<=v;i++)
		{
			System.out.println("Enter source, destination and weight of "+ (i+1) +" node seperated by space");
			mg.addEdge(sc.nextInt(),sc.nextInt(), sc.nextInt());
		}
//		MyGraph mg = new MyGraph(4);
//		mg.addEdge(0, 1, 10);
//		mg.addEdge(0, 2, 6);
//		mg.addEdge(0, 3, 5);
//		mg.addEdge(1, 3, 15);
//		mg.addEdge(2, 3, 4);
		System.out.println("Graph is connected : "+ mg.isConnected(src));
		
		System.out.println("Enter the vertex to find all the nodes reachable from it");
		src= sc.nextInt(); //src=0 ,nodes reachable=>1,2,3
		List<Integer> x = mg.reachable(src);
		System.out.println("Nodes reachable from vertex "+src+" is: ");
		for(int a:x){
			System.out.println(a);
		}
		mg.mst();
	}

}