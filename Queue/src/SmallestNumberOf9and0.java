import java.util.LinkedList;
import java.util.Queue;
public class SmallestNumberOf9and0 {
	public static void main(String args[]) {
		Queue<Integer> queue = new LinkedList<>(); 
		int answer = 0;
		int i = 9;
		int count = 0;
		queue.add(i);
		while(i < 100000) {
			int value = queue.poll();
			if(value%7 == 0) {
				answer = value;
				break;
			}else {
				value *= 10;
				queue.add(value);
				value += 9;
				queue.add(value);
				i = value;
			}
			if(answer > 0) {
				break;
			}
		}
		System.out.println("Answer: " + answer);
	}
}
