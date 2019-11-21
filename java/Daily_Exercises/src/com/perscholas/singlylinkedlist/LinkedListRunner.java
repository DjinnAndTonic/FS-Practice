package com.perscholas.singlylinkedlist;

public class LinkedListRunner {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(5);
		
		System.out.println(sll + "size: " + sll.getLength());
		
		System.out.println();
		sll.remove(0);
		System.out.println(sll + "size: " + sll.getLength());
		
		System.out.println();
		sll.add(10, 0);
		System.out.println(sll + "size: " + sll.getLength());
		
		System.out.println();
		sll.add(15, 0);
		System.out.println(sll + "size: " + sll.getLength());
		
		System.out.println();
		sll.removeByValue(5);
		System.out.println(sll + "size: " + sll.getLength());
		
		
		System.out.println();
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		l2.add(123);
		System.out.println(l2 + "size: " + l2.getLength());
	}
}
