package com.mci.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue(4); // max size is 3

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

class CircleArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;

	public CircleArrayQueue(int arrayMaxSize) {
		this.maxSize = arrayMaxSize;
		array = new int[maxSize];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int number) {
		if (isFull()) {
			System.out.println("Queue already full");
			return;
		}

		array[rear] = number;
		rear = (rear + 1) % maxSize;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty, can not get data");
		}

		/*
		 * 1 - save front to a temp value 2 - move front 3 - return temp value
		 */
		int value = array[front];
		front = (front + 1) % maxSize;
		return value;
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		for (int i = front; i < front + queueSize(); i++) {
			System.out.printf("array[%d] = %d\n", i % maxSize, array[i % maxSize]);
		}
	}

	public int queueSize() {
		return (rear + maxSize - front) % maxSize;
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}

		return array[front];
	}
}
