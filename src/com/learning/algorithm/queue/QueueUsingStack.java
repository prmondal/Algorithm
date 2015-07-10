package com.learning.algorithm.queue;

import java.util.Stack;

public class QueueUsingStack {
	static Stack<Integer> first = new Stack<Integer>();
	static Stack<Integer> second = new Stack<Integer>();
	static int MAX_SIZE = 10;
	
	public static void main(String[] args) {
		enque(10);
		enque(20);
		enque(30);
		enque(40);
		
		deque();
		enque(50);
		deque();
		deque();
		deque();
		deque();
	}
	
	static void enque(int i) {
		if(first.size() >= MAX_SIZE) {
			System.out.println("New element can not be inserted. Queue is FULL!");
			return;
		}
		
		//push to first stack
		first.push(i);
	}
	
	static void deque() {
		if(first.isEmpty() && second.isEmpty()) {
			System.out.println("Queue is empty!");
			return;
		}
		
		//if there are elements in second stack pop from it else push all elements from first stack to second except the last element
		if(!second.isEmpty()) {
			System.out.println("DEQUE: " + second.pop());
			return;
		}
		
		while(first.size() != 1) {
			second.push(first.pop());
		}
		
		System.out.println("DEQUE: " + first.pop());
	}

}
