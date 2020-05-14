import java.util.*;
//0 has 1 and 2
//1 has 3 and 4
//2 has 4 and 5 
//start at 0, BFS go to 1 -> 3 then 2 -> 4, then 3 -> 4 then 4 -> 5
public class BreadthFirstSearch {
	private int numOfVertices; 
	private ArrayList<LinkedList<Integer>> listOfVertices;
	
	BreadthFirstSearch(int vertices){
		numOfVertices = vertices; 
		listOfVertices = new ArrayList();
		for(int i = 0; i < vertices; i++) {
			listOfVertices.add(new LinkedList<Integer>());
		}
	}
	
	// adding edges into the graph
	void addEdge(int src, int dest) {
		(listOfVertices.get(src)).add(0,dest);
	}
	
	void BFS(int src) {
		boolean visited[] = new boolean[numOfVertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		// mark the current node as visited and enqueue it
		visited[src] = true;
		queue.add(src);
		
		while(queue.size() != 0) {
			// retrieve and remove the head
			src = queue.poll();
			System.out.print(src + " ");
			
			// getting all adjacent vertices to the src after dequeue the src
			// if the adjacent vertex has not been visisted, then mark true and enque it
			Iterator<Integer> i = (listOfVertices.get(src)).listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String args[]) {
		BreadthFirstSearch g = new BreadthFirstSearch(4); 
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        System.out.println("Following is Breadth First Traversal "+ "(starting from vertex 2)"); 

        g.BFS(0); 
	}
}