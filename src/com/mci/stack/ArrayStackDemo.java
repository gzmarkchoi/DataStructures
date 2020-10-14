package com.mci.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show: show stack values");
			System.out.println("exit: exit program");
			System.out.println("push: push a value into stack");
			System.out.println("pop: get a value out of stack");
			System.out.println("Please enter your choice");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.showStack();
				break;
			case "push":
				System.out.println("Please input a number");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int result = stack.pop();
					System.out.printf("Number poped: %d\n", result);
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}

class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
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
}