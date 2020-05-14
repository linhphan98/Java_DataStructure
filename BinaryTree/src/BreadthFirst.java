import java.util.*;
public class BreadthFirst {
	Node root; 
	
	static class Node{
		char data;
		Node left;
		Node right;
		
		Node(char C){
			data = C;
			left = null;
			right = null; 
		}
	}
	
	void insert(char data) {
		root = insertRecursion(root, data);
	}
	
	Node insertRecursion(Node root, char data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		if(data < root.data) {
			root.left = insertRecursion(root.left, data);
		}else if(data > root.data) {
			root.right = insertRecursion(root.right, data);
		}
		return root;
	}
	
	void breadthFirst(Node root) {
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.print("Breadth First Search using queue: ");
		while(!queue.isEmpty()) {
			Node current = queue.peek();
			System.out.print(current.data);
			if(current.left != null) queue.add(current.left);
			if(current.right != null) queue.add(current.right);
			queue.remove();
		}
	}
	
	public static void main(String args[]) {
		BreadthFirst obj = new BreadthFirst();
		obj.insert('M');
		obj.insert('B');
		obj.insert('Q');
		obj.insert('Z');
		obj.insert('A');
		obj.insert('C');
		
		obj.breadthFirst(obj.root);
	}
}
