package com.practice.linkedlist;

public class LL {

	public static void main(String[] args) {

		SingleLinkedList ll = new SingleLinkedList();
		ll.insertLast(0);
		ll.insertLast(1);
		ll.insertLast(2);
		ll.insertLast(3);
		ll.insertLast(4);
		ll.display();
		System.out.println("find::" + ll.find(6));
		System.out.println(ll.size());
		
		System.out.println("Now its time to test doubly linked list as well");
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.insertFirst(3);
		dll.insertFirst(8);
		dll.insertLast(2);
		dll.insertFirst(5);
		dll.insertLast(13);
		dll.display();
		dll.displayRev();
	}

}
