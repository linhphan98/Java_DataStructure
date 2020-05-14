import java.util.*;
class Graph{
	class Edge{
		int vertice, weight;
		public Edge(int v, int w) {
			this.vertice = v;
			this.weight = w;
		}
		
		@Override
		public String toString() {
			return "to: " + vertice + " with w: " + weight;
		}
	}
	
	List<Edge> graph[];
	
	public Graph(int vertices) {
		graph = new LinkedList[vertices];
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<Edge>();
		}
	}
	
	boolean isConnected(int src, int dest) {
		for(Edge i : graph[src]) {
			if(i.vertice == dest) return true;
		}
		return false;
	}
	
	@Override
	// over write the toString method provide by java.util
	public String toString() {
		String result = ""; 
		for(int i = 0; i < graph.length; i++) {
			result += i + " -> " + graph[i] + '\n';
		}
		return result;
	}
	
	void addEdge(int source, int destination, int weight) {
		graph[source].add(0, new Edge(destination, weight)); // add to beginning of the linkedList
	}
}
public class AdjacencyList {
	public static void main(String args[]) {
		Graph g = new Graph(10);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 5, 15);
		g.addEdge(2, 5, 10);
		g.addEdge(9, 3, 10);
		g.addEdge(1, 2, 15);
		System.out.println(g);
		System.out.println(g.isConnected(2, 5));
	}
}
