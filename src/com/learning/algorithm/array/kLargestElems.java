package com.learning.algorithm.array;

import java.util.PriorityQueue;

public class kLargestElems {

	public static void main(String[] args) {
		int k = 5;
		int[] a = {100,20,30,1,2,5,70,8,100,80};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		
		for(int i = 0, l = a.length; i < l; i++) {
			pq.add(a[i]);
		}
		
		//print k smallest elements
		for(int i = 1; i <= k; i++) {
			System.out.print(pq.poll() + ", ");
		}
	}
}
