package com.mci.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "Christophe", "JC");
		HeroNode hero2 = new HeroNode(2, "David", "DD");
		HeroNode hero3 = new HeroNode(3, "Nicolas", "Nico");
		HeroNode hero4 = new HeroNode(4, "Mark", "mci");

		SingleLinkedList list = new SingleLinkedList();
//		list.add(hero1);
//		list.add(hero2);
//		list.add(hero3);
//		list.add(hero4);

		list.addAtPosition(hero1);
		list.addAtPosition(hero4);
		list.addAtPosition(hero2);
		list.addAtPosition(hero2);
		list.addAtPosition(hero3);
		
		list.displayList();
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
