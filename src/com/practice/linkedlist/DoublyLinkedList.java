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

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Node(int value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

	}

	public void insertFirst(int value) {
		Node temp = new Node(value);
		temp.next = head;
		temp.prev = null;
		if (head != null) {
			head.prev = temp;
		}
		head = temp;
		if (tail == null) {
			tail = head;
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

	public void insert(int value, int index) {
		if (index == 0) {
			insertFirst(value);
			return;
		}
		if (index == size - 1) {
			insertLast(value);
			return;
		}

		Node temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		Node newNode = new Node(value, temp.next, temp);
		//newNode.prev = temp;
		temp.next = newNode;
		newNode.next.prev = newNode;
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
