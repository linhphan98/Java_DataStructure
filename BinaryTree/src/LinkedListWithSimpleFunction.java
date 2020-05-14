public class LinkedListWithSimpleFunction {
	Node root;
	LinkedListWithSimpleFunction(){
		root = null;
	}
	
	static class Node{
		int data; 
		Node left;
		Node right;
		
		Node(int input){
			data = input;
			left = right = null;
		}
	}
	
	void insert(int x) {
		root = insertRecursion(root, x);
	}
	
	Node insertRecursion(Node root, int x) {
		if(root == null) {
			Node newNode = new Node(x);
			root = newNode;
			return root;
		}
		if(x <= root.data) {
			root.left = insertRecursion(root.left, x);
		}else if(x > root.data) {
			root.right = insertRecursion(root.right, x);
		}
		return root;
	}
	
	void print(Node root) {
		if(root != null) {
			print(root.left);
			System.out.print(root.data + " ");
			print(root.right);
		}
		else return;
	}
	
	Node findMinNode(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	void delete(int x) {
		root = deleteRecursion(root, x);
	}
	
	Node deleteRecursion(Node root, int x) {
		if(root == null) {
			return root;
		}
		else if(x > root.data) {
			root.right = deleteRecursion(root.right, x);
		}
		else if(x < root.data) {
			root.left = deleteRecursion(root.left, x);
		}
		else {
			// No child 
			if((root.right == null) && (root.left == null)) {
				root = null;
			}
			// one child on left
			else if(root.right == null) {
				return root.left;
			}
			// one child on right
			else if(root.left == null) {
				return root.right;
			}
			// two kids
			else {
				Node min = findMinNode(root.right);
				root.data = min.data;
				root.right = deleteRecursion(root.right,min.data);
			}
		}
		return root;
	}
	
	public static void main(String args[]) {
		LinkedListWithSimpleFunction obj = new LinkedListWithSimpleFunction();
		
		obj.insert(7);
		obj.insert(10);
		obj.insert(4);
		obj.insert(5);
		obj.insert(2);
		obj.insert(1);
		obj.insert(3);
		obj.insert(6);
		obj.insert(9);
		
		obj.deleteRecursion(obj.root, 7);
		obj.print(obj.root);
	}
}
