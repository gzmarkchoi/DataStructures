package com.mci.stack;

/**
 * Expression calculator using customized Stack.
 * 
 * Example: "700+20*6-4", the result would be 816
 * 
 * @author 
 *
 */
public class Calculator {

	public static void main(String[] args) {
		String calExpression = "700+20*6-4";

		ArrayStackCal numberStack = new ArrayStackCal(10);
		ArrayStackCal operatorStack = new ArrayStackCal(10);

		int index = 0; // for scanner
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int result = 0;
		char ch = ' ';
		String keepNumber = "";

		while (true) {
			// Get each value in expression
			ch = calExpression.substring(index, index + 1).charAt(0);
			if (operatorStack.isOperator(ch)) { // ch is an operator
				if (!operatorStack.isEmpty()) {
					// compare the priority of the operators
					if (operatorStack.operatorPriority(ch) <= operatorStack.operatorPriority(operatorStack.peek())) {
						// current operator has bigger priority then the one in operator stack
						num1 = numberStack.pop();
						num2 = numberStack.pop();
						oper = operatorStack.pop();
						result = numberStack.calculate(num1, num2, oper);
						// Push the result into number stack
						numberStack.push(result);
						// dont forget this step, the current operator has to be pushed
						operatorStack.push(ch);
					} else { // current operator has bigger priority then the one in operator stack
						operatorStack.push(ch);
					}
				} else { // operator stack is empty
					operatorStack.push(ch);
				}
			} else { // ch is a number
				// numberStack.push(ch - 48);
				keepNumber += ch;

				if (index == calExpression.length() - 1) { // ch is the last character
					numberStack.push(Integer.parseInt(keepNumber));
				} else {
					// check next ch if it's still number or not, important !!
					if (operatorStack.isOperator(calExpression.substring(index + 1, index + 2).charAt(0))) {
						// the next ch is an operator
						numberStack.push(Integer.parseInt(keepNumber));
						keepNumber = "";
					}
				}
			}

			index++;
			if (index >= calExpression.length()) { // Finish reading the expression
				break;
			}
		}

		// calExpression is scanned
		while (true) {
			// operator stack is empty, number stack has only 1 number
			if (operatorStack.isEmpty()) {
				break;
			}
			num1 = numberStack.pop();
			num2 = numberStack.pop();
			oper = operatorStack.pop();
			result = numberStack.calculate(num1, num2, oper);
			numberStack.push(result);
		}

		int finalResult = numberStack.pop();
		System.out.printf("Expression to calculate: %s = %d", calExpression, finalResult);
	}

}

class ArrayStackCal {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStackCal(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	public int peek() {
		return stack[top];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	// Push a value into the stack
	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack full");
			return;
		}
		top++;
		stack[top] = value;
	}

	// Get a value out of the stack
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack empty");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// Show the stack, starts from the list pushed value
	public void showStack() {
		if (isEmpty()) {
			System.out.println("Stack empty");
		}

		for (int i = top; i >= 0; i--) {
			System.out.printf("Stack[%d]=%d\n", i, stack[i]);
		}
	}

	// Get the priority of operators
	public int operatorPriority(int operator) {
		if (operator == '*' || operator == '/') {
			return 1;
		} else if (operator == '+' || operator == '-') {
			return 0;
		} else {
			return -1; // there're only 4 operators +, -, *, /
		}
	}

	public boolean isOperator(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/';
	}

	public int calculate(int num1, int num2, int operator) {
		int result = 0;
		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num2 - num1;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num2 / num1;
			break;
		default:
			break;
		}
		return result;
	}

}