package com.practice.linkedlist;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	private class Node {
		private int value;
		private Node next;
		private Node prev;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next, Node prev) {
			super();
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

	}

	public void insertFirst(int value) {
		Node temp = new Node(value);
		temp.next = head;
		temp.prev = null;
		head = temp;
		if (tail == null) {
			tail = head;
		}
		if (head != null) {
			head.prev = temp;
		}

		size++;
	}

	public void insertLast(int value) {
		if (tail == null) {
			insertFirst(value);
			return;
		}

		Node node = new Node(value);
		
		tail.next = node;
		node.prev = tail;
		tail = node;
		
		size++;
	}

	public void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}

		System.out.println(" ");
	}

	public void displayRev() {
		Node node = tail;
		System.out.println();
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.prev;

		}
		System.out.println(" ");
	}
}
