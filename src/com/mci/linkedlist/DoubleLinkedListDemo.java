package com.mci.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		DoubleLinkedHeroNode hero1 = new DoubleLinkedHeroNode(1, "Christophe", "JC");
		DoubleLinkedHeroNode hero2 = new DoubleLinkedHeroNode(2, "David", "DD");
		DoubleLinkedHeroNode hero3 = new DoubleLinkedHeroNode(3, "Nicolas", "Nico");
		DoubleLinkedHeroNode hero4 = new DoubleLinkedHeroNode(4, "Mark", "mci");

		DoubleLinkedHeroNodeList list = new DoubleLinkedHeroNodeList();
		list.add(hero1);
		list.add(hero2);
		list.add(hero3);
		list.add(hero4);
		
		list.displayList();
		
//		DoubleLinkedHeroNode newNode = new DoubleLinkedHeroNode(4, "Marko", "mcii");
//		list.update(newNode);
//		list.displayList();
		
//		list.delete(3);
//		list.displayList();
		
		
	}

}

class DoubleLinkedHeroNodeList {
	private DoubleLinkedHeroNode head = new DoubleLinkedHeroNode(0, "", "");

	public void update(DoubleLinkedHeroNode heroNodeToUpdate) {
		if (head.next == null) {
			System.out.println("List is empty");
			return;
		}

		// Find the hero node to update
		DoubleLinkedHeroNode tempNode = head.next;
		boolean flagNodeFound = false;

		while (true) {
			if (tempNode == null) {
				break;
			}
			if (tempNode.no == heroNodeToUpdate.no) {
				flagNodeFound = true;
				break;
			}
			tempNode = tempNode.next;
		}

		if (flagNodeFound) {
			tempNode.name = heroNodeToUpdate.name;
			tempNode.nickname = heroNodeToUpdate.nickname;
		} else {
			System.out.printf("Node No: %d not found", heroNodeToUpdate.no);
		}
	}
	
	// Add a node at tail
	public void add(DoubleLinkedHeroNode heroNodeToAdd) {
		DoubleLinkedHeroNode tempNode = head;
		// find the last node
		while (true) {
			if (tempNode.next == null) {
				break;
			}
			tempNode = tempNode.next;
		}

		tempNode.next = heroNodeToAdd;
		heroNodeToAdd.prev = tempNode;
	}
	
	public void delete(int no) {
		if (head.next == null) {
			System.out.println("List is empty!");
			return;
		}
		
		DoubleLinkedHeroNode tempNode = head.next;
		boolean flagNodeFound = false;

		while (true) {
			if (tempNode == null) { // last hero node
				break;
			}
			if (tempNode.no == no) {
				flagNodeFound = true;
				break;
			}
			tempNode = tempNode.next; // move to the next hero node
		}

		if (flagNodeFound) {
			tempNode.prev.next = tempNode.next;
			if (tempNode.next != null) {
				tempNode.next.prev = tempNode.prev; // if it's not the last node, otherwise nullpointerexception
			}
		} else {
			System.out.printf("The hero node with Number %d does not exist\n", no);
		}
	}
	
	public void displayList() {
		if (head.next == null) {
			System.out.println("List is empty");
			return;
		}
		DoubleLinkedHeroNode tempNode = head.next;
		while (true) {
			if (tempNode == null) {
				break;
			}
			System.out.println(tempNode.toString());
			tempNode = tempNode.next;
		}
	}
	
	public DoubleLinkedHeroNode getHead() {
		return head;
	}
}

class DoubleLinkedHeroNode {
	public int no;
	public String name;
	public String nickname;
	public DoubleLinkedHeroNode next;
	public DoubleLinkedHeroNode prev;

	public DoubleLinkedHeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}