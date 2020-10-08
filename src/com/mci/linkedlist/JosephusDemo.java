package com.mci.linkedlist;

public class JosephusDemo {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addKid(5); // a 5 kid list
		circleSingleLinkedList.showKid();
	}

}

class CircleSingleLinkedList {
	private Kid first = null;
	
	// add a number of¨¦ kids
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
