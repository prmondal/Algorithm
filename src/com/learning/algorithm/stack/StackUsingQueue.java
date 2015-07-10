package com.learning.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	static Queue<Integer> first = new LinkedList<Integer>();
	static Queue<Integer> second = new LinkedList<Integer>();
	static int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		push(10);push(20);push(30);push(40);push(50);push(100);
		pop();pop();push(60);pop();pop();pop();pop();pop();
	}
	
	static void push(int i) {
		if(first.size() == MAX_SIZE) {
			System.out.println("PUSH ERROR : Stack is FULL!");
			return;
		}
		
		first.add(i);
	}
	
	static void pop() {
		if(first.isEmpty()) {
			System.out.println("POP ERROR : Stack is empty!");
			return;
		}
		
		while(first.size() != 1) {
			second.add(first.poll());
		}
		
		System.out.println("POP : " + first.poll());
		
		//change role
		Queue<Integer> temp = first;
		first = second;
		second = temp;
	}
}
