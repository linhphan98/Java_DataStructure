import java.util.*;
public class StockSpanProblem {
	
	int[] checkStock(int[] array) {
		int[] spanArray = new int[array.length];		
		for(int i = array.length - 1; i >= 0; i--) {
			spanArray[i] = calculateSpan(array, i);
		}
		return spanArray;
	}
	
	int calculateSpan(int[] price, int spot) {
		Stack<Integer> stack = new Stack<Integer>();
		int count = 1;
		for(int i = 0; i < spot; i++) {
			stack.push(price[i]);
		}
		while(!stack.isEmpty()) {
			if(stack.peek() < price[spot]) {
				count++;
			}
			stack.pop();
		}
		return count;
	}
	
	public static void main(String args[]) {
		StockSpanProblem obj = new StockSpanProblem();
		int[] data = {100, 80, 60, 70, 60, 75, 85};
		int[] span = obj.checkStock(data);
		for(int i = 0; i < span.length; i++) {
			System.out.print(span[i] + " ");
		}
	}
}
