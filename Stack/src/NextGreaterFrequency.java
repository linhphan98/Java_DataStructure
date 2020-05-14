import java.util.*;
public class NextGreaterFrequency {
	
	int[] getFrequency(int a[]) {
		int[] frequency = new int[a.length];
		int max = 0; 
		for(int i = a.length - 1; i >= 0; i--) {
			frequency[i] = calculateNextFrequency(a, i);
			if(max < frequency[i]) {
				max = frequency[i];
			}
		}
		
		for (int i = 0; i < frequency.length; i++) {
			if(frequency[i] == max) frequency[i] = -1;
			else frequency[i] = max - frequency[i];
		}
		return frequency;
	}
	
	int calculateNextFrequency(int a[], int place) {
		Stack<Integer> stack = new Stack<Integer>();
		int frequency = 0;
		for(int i = 0; i < a.length; i++) {
			stack.push(a[i]);
		}
		while(!stack.isEmpty()) {
			if(stack.peek() == a[place]) frequency++;
			stack.pop();
		}
		return frequency;
	}
	
	public static void main(String args[]) {
		NextGreaterFrequency obj = new NextGreaterFrequency();
		int[] a = {1, 1, 2, 3, 4, 2, 1};
		int[] frequency = obj.getFrequency(a);
		for(int i = 0; i < frequency.length; i++) {
			System.out.print(frequency[i] + " ");
			
		}
		
	}
}
