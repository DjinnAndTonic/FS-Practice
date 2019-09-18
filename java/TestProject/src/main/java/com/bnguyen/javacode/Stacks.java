package com.bnguyen.javacode;

import java.util.EmptyStackException;

/*
 * Creating a Stack from scratch using Arrays.
 * Functions: push, pop, clear
 * 
 * */

public class Stacks {
	
	private int[] mant;
	private int size, index = 0;
	
	public Stacks(int size) {
		this.size = size;
		mant = new int[size];
	}
	
//	Method to push items onto stack
	public void push(int ele) {
		if(isFull()) {
			System.out.println("Stack is full! Cannot add '" + ele + "' to the stack.");
			return;
		}
		mant[index] = ele;
		index++;
	}
	
//	Method to pop items from stack
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return mant[--index];
	}
	
//	Method to determine if stack is empty
	public boolean isEmpty() {
		return (index == 0);
	}
	
//	Method to determine if stack is full
	public boolean isFull() {
		return (index == size);
	}
	
//	Method to determine the size of the stack
	public int size() {
		return index;
	}
	
	public static void main(String[] args) {
		System.out.println("Stack from Scratch");
		
		Stacks arrStack = new Stacks(5);
		
		for(int i = 0; i <=5; ++i) {
			System.out.println("Pushing: " + (int)(i+1));
			arrStack.push(i+1);	
		}
		
		System.out.println("\n\nPopping");
		
		for(int i = 4; i >=-1; --i) {
			System.out.println("Popping: " + arrStack.pop());
		}
	}

}
