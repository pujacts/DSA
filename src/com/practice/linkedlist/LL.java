package com.practice.linkedlist;

public class LL {

	public static void main(String[] args) {

//		SingleLinkedList ll = new SingleLinkedList();
//		ll.insertLast(0);
//		ll.insertLast(1);
//		ll.insertLast(2);
//		ll.insertLast(3);
//		ll.insertLast(4);
//		ll.display();
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
		
		CircularLinkedList cll = new CircularLinkedList();
		cll.insert(0);
		cll.insert(1);
		cll.insert(2);
		cll.insert(3);
		cll.display();
		cll.delete(0);
		cll.display();
	}

}
