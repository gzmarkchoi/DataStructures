package com.mci.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "Christophe", "JC");
		HeroNode hero2 = new HeroNode(2, "David", "DD");
		HeroNode hero3 = new HeroNode(3, "Nicolas", "Nico");
		HeroNode hero4 = new HeroNode(4, "Mark", "mci");

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

//		HeroNode newHeoHeroNode = new HeroNode(2, "David", "DDDD");
//		System.out.println("The original list");
//		list.displayList();
//		list.update(newHeoHeroNode);
//		System.out.println("The modified list");
//		list.displayList();

//		System.out.println("The original list");
//		list.displayList();
//		list.delete(3);
//		System.out.println("The modified list");
//		list.displayList();

//		System.out.printf("Number of nodes: %d\n", getLength(list.getHeadNode()));

//		HeroNode result = findLastIndexNode(list.getHeadNode(), 1);
//		System.out.println(result);

		// revrse the linked list
//		System.out.println("The original list");
//		list.displayList();
//		reverseList(list.getHeadNode());
//		System.out.println("The modified list");
//		list.displayList();
		
		reversePrint(list.getHeadNode());
	}

	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode current = head.next;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	public static void reverseList(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}

		HeroNode current = head.next;
		HeroNode currentNext = null;
		HeroNode reverseHead = new HeroNode(0, "", "");

		while (current != null) {
			currentNext = current.next; // save the next node of the current node
			current.next = reverseHead.next; // move to the new list in reverse order
			reverseHead.next = current; // add the current to the new list
			current = currentNext; // move forward the current node
		}
		head.next = reverseHead.next;
	}

	// get the index element in reverse order in the list
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if (head.next == null) {
			return null;
		}
		int listSize = getLength(head);

		if (index <= 0 || index > listSize) {
			return null;
		}

		HeroNode current = head.next;
		for (int i = 0; i < listSize - index; i++) {
			current = current.next;
		}

		return current;
	}

	// Number of nodes in a linked list, head node not included
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode current = head.next;
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
	private HeroNode head = new HeroNode(0, "", "");

	public void add(HeroNode heroNodeToAdd) {
		HeroNode tempNode = head;
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
	public void addAtPosition(HeroNode heroNode) {
		HeroNode temp = head;
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

	public void update(HeroNode heroNodeToUpdate) {
		if (head.next == null) {
			System.out.println("List is empty");
			return;
		}

		// Find the hero node to update
		HeroNode temp = head.next;
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
		HeroNode temp = head;
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
		HeroNode tempNode = head.next;
		while (true) {
			if (tempNode == null) {
				break;
			}
			System.out.println(tempNode.toString());
			tempNode = tempNode.next;
		}
	}

	public HeroNode getHeadNode() {
		return head;
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
