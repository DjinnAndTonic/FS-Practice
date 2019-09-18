package com.bnguyen.javacode;

import java.util.Arrays;
import java.util.Random;

public class Queues {
	private int[] mant;
	private int size, index =0;
	
	public Queues(int s) {
		size = s;
		mant = new int[s];
	}
	
//	Adds element to the queue
	public void enqueue(int ele) {
		if(isFull()) {
			System.out.println("Queue is Full! Cannot enqueue : " + ele);
			return;
		}
		mant[index] = ele;
		index++;
	}
	
//	Removes element from queue
	public int dequeue() {
		int tmp;
		
		tmp = mant[0];
		for(int i = 0; i < index-1; ++i) {
			mant[i] = mant[i+1];
		}
		
		index--;
		
		return tmp;
	}
	
//	Checks to see if queue is full
	public boolean isFull() {
		return (index == size);
	}
	
//	Checks to see if queue is empty
	public boolean isEmpty() {
		return (index == 0);
	}
	
//	Returns size of the queue
	public int size() {
		return index;
	}
	
	public String toString() {
		String str = "";
		
		for(int i =0; i < index; ++i) {
			str = str + mant[i] + " ";
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		Queues q = new Queues(5);
		Random rand = new Random();
		
		System.out.println("Queue from Scratch");
				
		for(int i = 0; i <= q.size(); ++i) {
			int num = rand.nextInt(100);
			System.out.println("Adding: " + num);
			q.enqueue(num);	
		}
		
		System.out.println("Queue after operation: " + q);
		System.out.println("\n\nDequeue-ing");
		
		int size = q.size();
		
		for(int i = 0; i < size; ++i) {
//			System.out.println("i : " + i + "\nsize : " + q.size());
			System.out.println("Removing: " + q.dequeue());
		}
		
		System.out.println("Queue after operation: " + q);
	}
}
