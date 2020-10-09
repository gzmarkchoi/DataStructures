package com.mci.linkedlist;

public class JosephusDemo {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addKid(25);
		circleSingleLinkedList.showKid();
		
		// Test kids pop order, it should be 2->4->1->5->3 for a 5 kid circle
		circleSingleLinkedList.popKid(1, 2, 25);
		
	}

}

class CircleSingleLinkedList {
	private Kid first = null;
	
	// add a number of kids
	public void addKid(int numberOfKids) {
		if (numberOfKids < 1) {
			System.out.println("Number of kids not correct");
			return;
		}
		
		Kid currentKid = null;
		
		for (int i = 1; i <= numberOfKids; i++) {
			Kid kid = new Kid(i);
			if (i == 1) {
				first = kid;
				first.setNext(first);
				currentKid = first;
			} else {
				currentKid.setNext(kid);
				kid.setNext(first);
				currentKid = kid;
			}
		}
	}
	
	public void showKid() {
		if (first == null) {
			System.out.println("No kid to show.");
			return;
		}
		
		// first can not be moved, another help pointer
		Kid currentKid = first;
		while (true) {
			System.out.printf("Kid number %d \n", currentKid.getNumber());
			if (currentKid.getNext() == first) {
				break;
			}
			currentKid = currentKid.getNext();
		}
	}
	
	// Calculate kid pop order
	/**
	 * @param startNum start from which kid number 
	 * @param countNum number of count
	 * @param total total number of kids in the circle
	 */
	public void popKid (int startNum, int countNum, int total) {
		// Check all input numbers
		if (first == null || startNum < 1 || startNum > total) {
			System.out.println("Input numbers incorrect");
		}
		// Helper pointer
		Kid helper = first;
		
		while(true) {
			if (helper.getNext() == first) { // helper point to the last kid
				break;
			}
			helper = helper.getNext();
		}
		// Before the kid start counting, move first and helper (startNum -1) kids 
		for (int i = 0; i < startNum -1; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while(true) {
			if (helper == first) { // only 1 kid in the circle
				break;
			}
			// Let helper and first move (countNum -1) kids
			for (int i = 0; i < countNum -1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			// "first" point to the to the kid that pops
			System.out.printf("kid %d poped\n", first.getNumber());
			// get rid of the kid in the circle
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("Last kid number %d stays\n", helper.getNumber());
	}
}

class Kid {
	private int number;
	private Kid next;
	
	public Kid(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Kid getNext() {
		return next;
	}

	public void setNext(Kid next) {
		this.next = next;
	}	
	
}
