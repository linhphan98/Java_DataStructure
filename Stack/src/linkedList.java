public class linkedList {
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public void push(int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
	}
	
	public void pop() {
		Node temp = head;
		if(temp == null) return;
		head = head.next;
		temp = null;
	}
	
	public void print() {
		Node temp = head;
		System.out.print("Stack with LinkedList Last In First Out: ");
		while(temp!=null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String args[]) {
		linkedList obj = new linkedList();
		for(int i = 0; i < 10; i++) {
			obj.push(i);
		}
		obj.pop();
		obj.pop();
		obj.print();
	}
}
