package com.perscholas.singlylinkedlist;

public class Node {
	private Object value;
	private Node nextNode;
	
	public Node(Object val) {
		value = val;
		nextNode = null;
	}
	
	public Node(Object val, Node next) {
		value = val;
		nextNode = next;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}
