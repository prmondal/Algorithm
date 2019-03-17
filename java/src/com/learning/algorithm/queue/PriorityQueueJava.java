package com.learning.algorithm.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueJava {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,
				Collections.reverseOrder());

		pq.add(10);
		pq.add(30);
		pq.add(2);
		pq.add(5);
		pq.add(6);

		for (int i = 0; i < 5; i++) {
			System.out.println(pq.poll());
		}

	}

}
