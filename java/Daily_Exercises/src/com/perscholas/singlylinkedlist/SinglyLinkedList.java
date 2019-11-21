package com.perscholas.singlylinkedlist;

public class SinglyLinkedList {
	// add, insert, remove
	private int numItems;
	private Node head;
	
	public SinglyLinkedList() {	}
	
	public void add(Object value) {
		System.out.println("Adding: " + value);
		
		if(head == null) {
			head = new Node(value);
			increment();
			return;
		}
		
		Node tmp = new Node(value);
		Node cur = head;
		
		if(cur != null) {
			while(cur.getNext() != null) {
				cur = cur.getNext();
			}
			
			cur.setNextNode(tmp);
		}
		
		increment();
	}
	
	public void add(Object value, int index) {
		Node tmp = new Node(value);
		Node cur = head;
		
		System.out.println("Adding " + value + " at index " + index);
		
		if(cur != null) {
			
			if(index == 0) {
				head = tmp;
				tmp.setNextNode(cur);
				increment();
				return;
			}
			
			for(int i = 0; i < index && cur.getNext() != null; i++) {
				cur = cur.getNext();
			}
		}
		
		tmp.setNextNode(cur.getNext());
		cur.setNextNode(tmp);
		
		increment();
	}
	
	
	public void remove(int index) {
		System.out.println("Removing at index: " + index);
		
		if(index < 0 || index > getLength()) {
			System.out.println("Invalid index.");
			return;
		}
		
		Node cur = head;
		
		if(head != null) {
			if (index == 0) {
				head = cur.getNext();
				head.setNextNode(cur.getNext().getNext());
				decrement();
				return;
			}
			
			for(int i = 0; i < index; ++i) {
				if(cur.getNext() == null) {
					return;
				}
				
				cur = cur.getNext();				
			}
			
			cur.setNextNode(cur.getNext().getNext());
		}
		
		decrement();
	}
	
	public void removeByValue(Object value) {
		System.out.println("Removing value: " + value);
		
		Node cur = head;
		
		if(head != null) {
			if(head.getValue().equals(value)) {
				head = cur.getNext();
				head.setNextNode(cur.getNext().getNext());
				decrement();
				return;
			}
			
			while(cur.getNext() != null) {
				
				if(cur.getNext().getValue().equals(value)) {
					cur.setNextNode(cur.getNext().getNext());
					decrement();
					return;
				}
				cur = cur.getNext();
			}
			
			
		}
		
		System.out.println("Value not found.");
	}
	
	public int getLength() {
		return numItems;
	}
	
	private void increment() {
		numItems++;
	}
	
	private void decrement() {
		numItems--;
	}
	
	@Override
	public String toString() {
		String outputString = "";
		
		if(head != null) {
			Node cur = head;
			while(cur != null) {
				outputString += "(" + cur.getValue() + ") ";
				cur = cur.getNext();
			}
		}
		
		return outputString;
	}
	
}
