package com.practice.linkedlist;

public class LL {

	public static void main(String[] args) {

		SingleLinkedList ll = new SingleLinkedList();
		ll.insertLast(0);
		ll.insertLast(1);
		ll.insertLast(6);
		ll.insertLast(9);
		ll.insertLast(15);
		ll.display();
		
		SingleLinkedList ll2 = new SingleLinkedList();
		ll2.insertLast(3);
		ll2.insertLast(4);
		ll2.insertLast(5);
		ll2.insertLast(7);
		ll2.insertLast(8);
		ll2.display();
		
		
		SingleLinkedList ll3 = new SingleLinkedList();
		ll3 = ll3.merge(ll, ll2);
		ll3.display();
		
		
//		System.out.println("find::" + ll.find(6));
//		System.out.println(ll.size());
//		
//		System.out.println("Now its time to test doubly linked list as well");
//		DoublyLinkedList dll = new DoublyLinkedList();
//		
//		dll.insertFirst(3);
//		dll.insertFirst(8);
//		dll.insertLast(2);
//		dll.insertFirst(5);
//		dll.insertLast(13);
//		dll.insert(10, 2);
//		dll.insert(0, 4);
//		dll.display();
//		dll.displayRev();
//		
//		CircularLinkedList cll = new CircularLinkedList();
//		cll.insert(0);
//		cll.insert(1);
//		cll.insert(2);
//		cll.insert(3);
//		cll.display();
//		cll.delete(0);
//		cll.display();
	}

}
