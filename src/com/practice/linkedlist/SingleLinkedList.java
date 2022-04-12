package com.practice.linkedlist;

public class SingleLinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

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

	public void insertFirst(int value) {
		Node temp = new Node(value);
		temp.next = head;
		head = temp;

		if (tail == null) {
			tail = head;
		}
		size += 1;
	}

	public void insertLast(int value) {
		if (tail == null) {
			insertFirst(value);
			return;
		}
		Node node = new Node(value);
		tail.next = node;
		tail = node;

		size++;
	}

	public void insert(int value, int index) {
		if (index == 0) {
			insertFirst(value);
			return;
		}
		if (index == size) {
			insertLast(value);
			return;
		}

		Node temp = head;

		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		Node node = new Node(value, temp.next);
		temp.next = node;
		size++;
	}

	public int deleteFirst() {
		int value = head.value;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return value;
	}

	public int deleteLast() {

		if (size <= 1) {
			return deleteFirst();
		}
		Node secondLast = get(size - 2);
		int value = tail.value;
		tail = secondLast;
		tail.next = null;
		size--;
		return value;

	}

	public int delete(int index) {
		if (index == 0) {
			return deleteFirst();
		}
		if (index == size - 1) {
			return deleteLast();
		}

		Node node = head;
		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		int value = get(index).value;
		Node secondNode = get(index + 1);
		node.next = secondNode;
		size--;
		return value;
	}

	public Node get(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public Node find(int value) {
		Node node = head;
		while (node != null) {
			if (node.value == value) {
				return node;
			}
			node = node.next;
		}

		return null;
	}

	// insert using recursion
	public void insertRec(int value, int index) {
		head = insertRec(value, index, head);
	}

	private Node insertRec(int value, int index, Node node) {

		if (index == 0) {
			Node temp = new Node(value, node);
			size++;
			return temp;
		}

		node.next = insertRec(value, index - 1, node.next);

		return node;
	}

	// https://leetcode.com/problems/remove-duplicates-from-sorted-list
	public void deleteDuplicates() {
		Node node = head;

		while (node.next != null) {
			if (node.value == node.next.value) {
				node.next = node.next.next;
				size--;
			} else {
				node = node.next;
			}
		}

		tail = node;
		tail.next = null;
	}

	public void display() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + "-> ");
			curr = curr.next;
		}
		System.out.print("END");
		System.out.println("");
	}

	public int size() {
		return size;
	}

	// https://leetcode.com/problems/merge-two-sorted-lists/
	public SingleLinkedList merge(SingleLinkedList first, SingleLinkedList second) {
		Node f = first.head;
		Node s = second.head;

		SingleLinkedList ans = new SingleLinkedList();

		while (f != null && s != null) {
			if (f.value < s.value) {
				ans.insertLast(f.value);
				f = f.next;
			} else {
				ans.insertLast(s.value);
				s = s.next;
			}
		}

		while (f != null) {
			ans.insertLast(f.value);
			f = f.next;
		}

		while (s != null) {
			ans.insertLast(s.value);
			s = s.next;
		}

		return ans;
	}

	// https://leetcode.com/problems/linked-list-cycle-ii/submissions/
	public Node detectCycle(Node head) {

		Node fast = head;
		Node slow = head;
		Node start = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				while (slow != start) {
					slow = slow.next;
					start = start.next;
				}
				return start;
			}
		}

		return null;
	}

	// https://leetcode.com/problems/linked-list-cycle/
	public boolean hasCycle(Node head) {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}

		return false;
	}
}
