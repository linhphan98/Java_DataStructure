import java.util.*;

public class InfixToPostfix {
	public Boolean IsOperand(char C) {
		if((C >= '0') && (C <= '9')) return true;
		if((C >= 'a') && (C <= 'z')) return true;
		if((C >= 'A') && (C <= 'Z')) return true;
		return false;
	}
	
	public Boolean IsOperator(char C) {
		if((C == '+') || (C == '-') || (C == '*') || (C == '/')) return true;
		return false;
	}
	
	public int getOperatorWeight(char operator) {
		int weight = 0; 
		switch(operator) {
			case '+':
			case '-':
				weight = 1;
			break;
			case '*':
			case '/':
				weight = 2;
			break;
		}
		return weight;
	}
	
	// check if top has higher priority than current
	public boolean hasHigherPriority(char topOperator, char currentOperator) {
		int weight1 = getOperatorWeight(topOperator);
		int weight2 = getOperatorWeight(currentOperator);
		
		if(weight1 == weight2) {
			return true;
		}
		
		return weight1 > weight2 ? true : false;
	}
	
	public String infixToPostfix(String expression) {
		Stack<Character>stack = new Stack<Character>();
		char[] expressionArray = expression.toCharArray();
		String postFix = "";
		
		for(int i = 0; i < expression.length(); i++) {
			if(expressionArray[i] == ' ' || expressionArray[i] == ',') {
				continue;
			}
			else if(IsOperator(expressionArray[i])) {
				while(!stack.isEmpty() && expressionArray[i] != '(' && hasHigherPriority(stack.peek(),expressionArray[i])) {
					postFix += stack.peek();
					stack.pop();
				}
				stack.push(expressionArray[i]);
			}
			else if(IsOperand(expressionArray[i])) {
				postFix += expressionArray[i];
			}else if(expressionArray[i] == '(') {
				stack.push(expressionArray[i]);
			}else if(expressionArray[i] == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					postFix += stack.peek();
					stack.pop();
				}	
				stack.pop();
			}	
		}
		while(!stack.isEmpty()) {
			postFix += stack.peek();
			stack.pop();
		}
		return postFix;
	}
	
	public int calculatePostFix(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] expressionArray = expression.toCharArray();
		for(int i = 0; i < expression.length(); i++) {
			if(expressionArray[i] == ' ' || expressionArray[i] == ',') {
				continue;
			}else if(IsOperand(expressionArray[i])) {
				stack.push(expressionArray[i] - '0');
			}else if(IsOperator(expressionArray[i])) {
				int top2 = stack.peek(); stack.pop();
				int top1 = stack.peek(); stack.pop();
				int result = performOperation(expressionArray[i], top1, top2);
				stack.push(result);
			}
		}
		return stack.peek();
		
	}
	
	public int performOperation(char operator, int top1, int top2) {
		if(operator == '+') return top1+top2;
		if(operator == '-') return top1-top2;
		if(operator == '*') return top1*top2;
		if(operator == '/') return top1/top2;
		
		System.out.println("Unexpected Error");
		return -1;
	}
	
	public static void main(String[] args) {
		InfixToPostfix obj = new InfixToPostfix();
		String expression;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Infix Expression");
		expression = input.nextLine();
		String postFix = obj.infixToPostfix(expression);
		System.out.println("Output: " + postFix);
		System.out.println("Calculating postFix:");
		int calculatedPostfix = obj.calculatePostFix(postFix);
		System.out.println("Result: " + calculatedPostfix);
	}
	
}
