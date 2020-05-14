import java.util.*;
public class LinkedList {
	Node head; // head of the list
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	// inserting a new node 
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
		}
	}
	
	// traversing and print the list
	public void printList() {
		Node currNode = this.head;
		System.out.print("LinkedList: ");
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	// deleting
	public void deleteByKey(int data) {
		Node temp1 = null;
		Node temp2 = this.head;
		if(temp2.data == data) {
			this.head = temp2.next;
		}else {
			temp1 = temp2;
			temp2 = this.head.next;
			while(temp2 != null) {
				if(temp2.data == data) {
					temp1.next = temp2.next;
					temp2 = null;
					return;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
	}
	
	// Checking if it is palindrome 
	public Boolean checkPalindrom(Node temp) {
		Stack<Integer> stack = new Stack<Integer>();
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		temp = null;
		temp = head;
		
		while(!stack.isEmpty()) {
			if(stack.peek() != temp.data) {
				return false;
			}else {
				stack.pop();
			}
			temp = temp.next;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		
		list.printList();
		
		Boolean check = list.checkPalindrom(list.head);

		
	}
}
