public class DepthFirst {
	Node root;
	
	static class Node{
		char data; 
		Node right;
		Node left;
		
		Node(char x){
			data = x;
			right = null;
			left = null;
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
	
	// Preorder: data -- left -- right
	void preorderPrint(Node root) {
		System.out.print(root.data + " ");
		if(root.left != null) preorderPrint(root.left);
		if(root.right != null) preorderPrint(root.right);
	}
	
	// Inorder: left -- data -- right
	void inorderPrint(Node root) {
		if(root.left != null) inorderPrint(root.left);
		System.out.print(root.data + " ");
		if(root.right != null) inorderPrint(root.right);
	}
	
	// Postorder: left -- right -- data
	void postorderPrint(Node root) {
		if(root.left != null) postorderPrint(root.left);
		if(root.right != null) postorderPrint(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String args[]) {
		DepthFirst obj = new DepthFirst();
		
		obj.insert('M');
		obj.insert('B');
		obj.insert('Q');
		obj.insert('Z');
		obj.insert('A');
		obj.insert('C');
		
		System.out.print("\nPreorder: ");
		obj.preorderPrint(obj.root);
		System.out.print("\nInorder: ");
		obj.inorderPrint(obj.root);
		System.out.print("\nPostorder: ");
		obj.postorderPrint(obj.root);
	}
}
