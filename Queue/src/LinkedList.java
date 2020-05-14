public class LinkedList {
	Node head = null, tail = null;
	
	static class Node{
		Object data; 
		Node next; 
		
		Node(Object d){
			data = d;
			next = null;
		}
	}
	
	public void enQueue(Object x) {
		Node newNode = new Node(x);
		if((head == null) && (tail == null)) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode; 
		tail = newNode;
	}
	
	public void deQueue() {
		if(head == null) return;
		if(head == tail) {
			head = tail = null;
			return;
		}
		Node temp = head;
		head = head.next;
		temp = null;
	}
	
	void print() {
		Node temp = head;
		System.out.print("LinkedList first in first out: ");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList obj = new LinkedList();
		for (int i = 0; i < 10; i++) {
			obj.enQueue(i);
		}
		obj.deQueue();
		obj.deQueue();
		obj.enQueue('a');
		obj.enQueue('A');
		obj.print();
	}
}
