public class array {
	int max_size = 101;
	int top = -1;
	int[] A = new int[max_size];
	
	public void push(int x) {
		if(top == max_size - 1) {
			System.out.println("Error: Stack Overflow");
			return;
		}
		A[++top] = x;
	}
	
	public void pop() {
		if(top == -1) {
			System.out.println("Error: There is no element to pop");
			return;
		}
		top--;
	}
	
	public int Top() {
		return A[top];
	}
	
	public void print() {
		int i = top;
		System.out.print("Last one on the list, first one out: ");
		while(i != -1) {
			System.out.print(A[i]);
			i--;
		}
	}
	
	public static void main(String[] args) {
		array obj = new array();
		for(int i = 0; i < 10; i++) {
			obj.push(i);
		}
		obj.pop();
		obj.pop();
		obj.print();
	}
}	
