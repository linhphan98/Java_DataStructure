public class DoublyLinkedList {
	Node head;
	Node tail;
	
	static class Node{
		int data;
		Node next;
		Node prev; 
		
		Node(int d){
			data = d;
			next = null;
			prev = null;
		}
	}
	
	// insert a new node 
	public void insert (int data) {
		Node newNode = new Node(data);
		
		if(this.head == null) {
			this.head = newNode;
		}else {
			Node temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
			tail = newNode;
		}
	}
	
	// traversing and print the list
	public void print() {
		Node currNode = this.head;
		System.out.print("DoublyLinkedList: ");
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	// traversing and print the list
		public void printBackward() {
			Node temp = tail;
			while(temp != null) {
				System.out.print(temp.data);
				temp = temp.prev;
			}
		}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		for(int i = 0; i < 10; i++) {
			list.insert(i);
		}
		System.out.print("Backward DoublyLinkedList: ");
		list.printBackward();
	}
}
