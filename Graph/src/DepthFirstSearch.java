import java.util.*;
// 0 has 1 and 2
// 1 has 3 and 4
// 2 has 4 and 5 
// start at 0, DFS go to 1 -> 3 -> 4 then it will go to 2 and so on
public class DepthFirstSearch {
	private int numOfVertices; 
	private ArrayList<LinkedList<Integer>> listOfVertices;
	
	DepthFirstSearch(int vertices){
		numOfVertices = vertices;
		listOfVertices = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i < vertices; i++) {
			listOfVertices.add(new LinkedList<Integer>());
		}
	}
	
	void addEdge(int src, int dest) {
		(listOfVertices.get(src)).add(0,dest);
	}
	
	void DFSrecursive(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = (listOfVertices.get(v)).listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSrecursive(n, visited);
			}
		}
	}
	void DFS(int src) {
		boolean visited[] = new boolean[numOfVertices];
		DFSrecursive(src,visited);
	}
	
	public static void main(String args[]) {
		DepthFirstSearch g = new DepthFirstSearch(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(0); 

	}
}
