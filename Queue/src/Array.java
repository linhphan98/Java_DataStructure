public class Array {
	int size = 10;
	int front = -1;
	int tail = -1;
	int[] A = new int[size];
	
	public Boolean isEmpty() {
		if((front == -1) && (tail == -1)) {
			return true;
		}
		return false;
	}
	
	public void enQueue(int x) {
		if((tail + 1) == front) {
			System.out.println("Out of space");
			return;
		}else if(isEmpty()) {
			front = tail = 0;
		}else {
			tail = (tail + 1) % size;
		}
		A[tail] = x;
	}
	
	public void deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}else if(front == tail) {
			front = tail = -1;
		}else {
			front = (front + 1) % size;
		}
	}
	
	public void print() {
		System.out.print("Array: ");
		if(tail >= front) {
			for(int i = front; i <= tail; i++) {
				System.out.print(A[i] + " ");
			}
			return;
		}
		int i = front;
		while(i < size) {
			System.out.print(A[i] + " ");
			i++;
		}
		for(i = 0; i <= tail; i++) {
			System.out.print(A[i] + " ");
		}
		
	}
	
	public static void main(String args[]) {
		Array obj = new Array();
		for (int i = 0; i < 10; i++) {
			obj.enQueue(i);
		}
		obj.deQueue();
		obj.deQueue();
		obj.enQueue(11);
		obj.enQueue(12);
		obj.deQueue();
		obj.deQueue();
		obj.enQueue(13);
		obj.enQueue(14);
		obj.print();
	}
}
