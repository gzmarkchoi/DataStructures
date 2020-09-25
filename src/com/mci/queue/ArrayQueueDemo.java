package com.mci.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);

		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		// a simple program menu
		while (loop) {
			System.out.println("s(show): show queue");
			System.out.println("e(exit): quit program");
			System.out.println("a(add): add data to queue");
			System.out.println("g(get): get data from queue");
			System.out.println("h(head): show head data of queue");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("Input a int number");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int result = queue.getQueue();
					System.out.printf("Get the int number: %d\n", result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int result = queue.headQueue();
					System.out.printf("Head int number: %d\n", result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("Exit program, bye");
	}

}

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;

	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		this.front = -1; // point to the position before queue header
		this.rear = -1;
		this.array = new int[maxSize];
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int number) {
		if (isFull()) {
			System.out.println("Queue already full");
			return;
		}

		rear++;
		array[rear] = number;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty, can not get data");
		}

		front++;

		return array[front];
	}

	// display all data
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d] = %d\n", i, array[i]);
		}
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}

		return array[front + 1];
	}
}
