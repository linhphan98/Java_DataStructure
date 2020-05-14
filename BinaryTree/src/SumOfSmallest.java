import java.util.*;
public class SumOfSmallest {
	Node root;
	Queue<Integer> queue = new LinkedList();
	
	class Node{
		int data;
		Node right;
		Node left;
		
		Node(int data){
			this.data = data;
			right = null;
			left = null;
		}
	}
	
	void insert (int data) {
		root = insertUtil(root, data);
	}
	
	Node insertUtil(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		if(data < root.data) {
			root.left = insertUtil(root.left, data);
		}else {
			root.right = insertUtil(root.right, data);
		}
		return root;
	}
	
	void inorderSearch(Node root) {
		if(root.left != null) inorderSearch(root.left);
		queue.add(root.data);
		if(root.right != null) inorderSearch(root.right);
	}
	
	int calculateSum(int k) {
		int sum = 0;
		int count = 1;
		while(!queue.isEmpty()) {
			sum += queue.poll();
			if(count == k) break;
			else {
				count++;
			}
		}
		return sum;
	}
	
	public static void main(String args[]) {
		SumOfSmallest obj = new SumOfSmallest();
		
		obj.insert(8);
		obj.insert(5);
		obj.insert(11);
		obj.insert(2);
		obj.insert(7);
		obj.insert(3);
		obj.inorderSearch(obj.root);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter value for K: ");
		int k = input.nextInt();
		int sum = obj.calculateSum(k);
		System.out.println("Sum = " + sum);
	}
}
