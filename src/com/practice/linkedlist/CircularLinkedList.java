package com.practice.linkedlist;

public class CircularLinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	public CircularLinkedList() {
		this.head = null;
		this.tail = null;
	}

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}

	}

	public void insert(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		newNode.next = head;
		tail = newNode;

	}

	public void delete(int value) {
		Node node = head;
		if (node == null) {
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		if (node.value == value) {
			head = head.next;
			tail.next = head;
			return;
		}

		do {
			Node n = node.next;
			if (n.value == value) {
				node.next = n.next;
				break;
			}
			node = node.next;
		} while (node != head);

	}

	public void display() {
		Node node = head;
		if (head != null) {
			do {
				System.out.print(node.value + " ");
				if (node.next != null) {
					node = node.next;
				}
			} while (node != head);
		}
		System.out.println(" ");
	}
}
