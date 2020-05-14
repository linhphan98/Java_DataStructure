import java.util.*;
public class checkBalanceParenthesis {
	Stack<Character> stack = new Stack<Character>();
	public Boolean check(String line) {
		char[] characterArray = line.toCharArray();
		int size = characterArray.length;
		
		for(int i = 0; i < size; i++) {
			if((characterArray[i] == '{') || (characterArray[i] == '[') || (characterArray[i] == '(')) {
				stack.push(characterArray[i]);
			}else if ((characterArray[i] == '}') || (characterArray[i] == ']') || (characterArray[i] == ')')) {
				switch(characterArray[i]) {
					case '}':
						characterArray[i] = '{';
					break;
					case ']':
						characterArray[i] = '[';
					break;
					case ')':
						characterArray[i] = '(';
					break;
				}
				if((stack.empty()) || (characterArray[i] != stack.peek())) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		
		if(stack.empty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String args[]) {
		checkBalanceParenthesis obj = new checkBalanceParenthesis();
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		Boolean answer = obj.check(line);
		if(answer) {
			System.out.println("Check");
		}else {
			System.out.println("Not Balanced");
		}
			
		
	}
}
