package com.mci.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedHeroNode hero1 = new SingleLinkedHeroNode(1, "Christophe", "JC");
		SingleLinkedHeroNode hero2 = new SingleLinkedHeroNode(2, "David", "DD");
		SingleLinkedHeroNode hero3 = new SingleLinkedHeroNode(3, "Nicolas", "Nico");
		SingleLinkedHeroNode hero4 = new SingleLinkedHeroNode(4, "Mark", "mci");

		SingleLinkedList list = new SingleLinkedList();
		list.add(hero1);
		list.add(hero2);
		list.add(hero3);
		list.add(hero4);

//		list.addAtPosition(hero1);
//		list.addAtPosition(hero4);
//		list.addAtPosition(hero2);
//		list.addAtPosition(hero2);
//		list.addAtPosition(hero3);

//		SingleLinkedHeroNode newHeroNode = new SingleLinkedHeroNode(2, "David", "DDDD");
//		System.out.println("The original list");
//		list.displayList();
//		list.update(newHeroNode);
//		System.out.println("The modified list");
//		list.displayList();

//		System.out.println("The original list");
//		list.displayList();
//		list.delete(3);
//		System.out.println("The modified list");
//		list.displayList();

//		System.out.printf("Number of nodes: %d\n", getLength(list.getHeadNode()));

//		SingleLinkedHeroNode result = findLastIndexNode(list.getHeadNode(), 1);
//		System.out.println(result);

		// revrse the linked list
//		System.out.println("The original list");
//		list.displayList();
//		reverseList(list.getHeadNode());
//		System.out.println("The modified list");
//		list.displayList();
		
		reversePrint(list.getHeadNode());
	}

	public static void reversePrint(SingleLinkedHeroNode head) {
		if (head.next == null) {
			return;
		}
		
		Stack<SingleLinkedHeroNode> stack = new Stack<SingleLinkedHeroNode>();
		SingleLinkedHeroNode current = head.next;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	public static void reverseList(SingleLinkedHeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}

		SingleLinkedHeroNode current = head.next;
		SingleLinkedHeroNode currentNext = null;
		SingleLinkedHeroNode reverseHead = new SingleLinkedHeroNode(0, "", "");

		while (current != null) {
			currentNext = current.next; // save the next node of the current node
			current.next = reverseHead.next; // move to the new list in reverse order
			reverseHead.next = current; // add the current to the new list
			current = currentNext; // move forward the current node
		}
		head.next = reverseHead.next;
	}

	// get the index element in reverse order in the list
	public static SingleLinkedHeroNode findLastIndexNode(SingleLinkedHeroNode head, int index) {
		if (head.next == null) {
			return null;
		}
		int listSize = getLength(head);

		if (index <= 0 || index > listSize) {
			return null;
		}

		SingleLinkedHeroNode current = head.next;
		for (int i = 0; i < listSize - index; i++) {
			current = current.next;
		}

		return current;
	}

	// Number of nodes in a linked list, head node not included
	public static int getLength(SingleLinkedHeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		SingleLinkedHeroNode current = head.next;
		while (current != null) {
			length++;
			current = current.next;
		}

		return length;
	}

}

/*
 * Single linked list to manage Hero nodes
 */
class SingleLinkedList {
	private SingleLinkedHeroNode head = new SingleLinkedHeroNode(0, "", "");

	public void add(SingleLinkedHeroNode heroNodeToAdd) {
		SingleLinkedHeroNode tempNode = head;
		// find the last node
		while (true) {
			if (tempNode.next == null) {
				break;
			}
			tempNode = tempNode.next;
		}

		tempNode.next = heroNodeToAdd;
	}

	// add a node by its number
	public void addAtPosition(SingleLinkedHeroNode heroNode) {
		SingleLinkedHeroNode temp = head;
		boolean flag = false;

		while (true) {
			if (temp.next == null) { // temp node is at last position
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) { // number already exist
				flag = true;
				break;
			}
			temp = temp.next;
		}

		if (flag) {
			System.out.printf("node number %d already exist, it can not be added ", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	public void update(SingleLinkedHeroNode heroNodeToUpdate) {
		if (head.next == null) {
			System.out.println("List is empty");
			return;
		}

		// Find the hero node to update
		SingleLinkedHeroNode temp = head.next;
		boolean flagNodeFound = false;

		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == heroNodeToUpdate.no) {
				flagNodeFound = true;
				break;
			}
			temp = temp.next;
		}

		if (flagNodeFound) {
			temp.name = heroNodeToUpdate.name;
			temp.nickname = heroNodeToUpdate.nickname;
		} else {
			System.out.printf("Node No: %d not found", heroNodeToUpdate.no);
		}
	}

	public void delete(int no) {
		SingleLinkedHeroNode temp = head;
		boolean flagNodeFound = false;

		while (true) {
			if (temp.next == null) { // last hero node
				break;
			}
			if (temp.next.no == no) {
				flagNodeFound = true;
				break;
			}
			temp = temp.next; // move to the next hero node
		}

		if (flagNodeFound) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("The hero node with Number %d does not exist\n", no);
		}
	}

	public void displayList() {
		if (head.next == null) {
			System.out.println("List is empty");
			return;
		}
		SingleLinkedHeroNode tempNode = head.next;
		while (true) {
			if (tempNode == null) {
				break;
			}
			System.out.println(tempNode.toString());
			tempNode = tempNode.next;
		}
	}

	public SingleLinkedHeroNode getHeadNode() {
		return head;
	}
}

class SingleLinkedHeroNode {
	public int no;
	public String name;
	public String nickname;
	public SingleLinkedHeroNode next;

	public SingleLinkedHeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "SingleLinkedHeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
