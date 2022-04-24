package com.practice.linkedlist;

public class RecursiveReverseLinkedList {
    static Node head;


    public static void main(String[] args)
    {
        RecursiveReverseLinkedList list = new RecursiveReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    // prints content of double linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
