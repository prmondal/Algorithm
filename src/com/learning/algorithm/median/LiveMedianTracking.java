/*
 * Max heap and min heap method to find medians of live data
 * Prasenjit Mondal
 */
package com.learning.algorithm.median;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LiveMedianTracking {
	private static Comparator<Integer> descending = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return (o2 - o1);
		}
	};
	
	public static void main(String[] args) {
		 PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, descending);
		 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		 //ArrayList<Integer> myData = new ArrayList<Integer>();
		
		 Scanner scanner = new Scanner(System.in);
	
		//count of elements
		int count = 0;
		
		//get live input
		String input = scanner.next();
		
		//insert first element
		maxHeap.add(Integer.valueOf(input));
		
		displayQueue(maxHeap, minHeap);
		System.out.println("Count is " + ((count % 2 == 0) ? "even" : "odd"));
		
		System.out.println("Median is " + maxHeap.peek());
		
		count++;
		
		//enter more elems
		while(true) {
			//get live input
			input = scanner.next();
			
			//press q to exit
			if(String.valueOf(input).equals("q")){
				break;
			}
			
			
			
			//even
			if(count % 2 == 0) {
				Integer newData = Integer.valueOf(input);
				
				if(newData < minHeap.peek()) {
					maxHeap.add(newData);
				} else {
					maxHeap.add(minHeap.poll());
					minHeap.add(newData);
				}
				
				count++;
				
				System.out.println("Count is " + ((count % 2 == 0) ? "even" : "odd"));
				
				displayQueue(maxHeap, minHeap);
				
				//calculate median
				System.out.println("\nMedian is " + maxHeap.peek());
				
			} else {//odd
				maxHeap.add(Integer.valueOf(input));
				minHeap.add(maxHeap.poll());
				
				count++;
				
				System.out.println("Count is " + ((count % 2 == 0) ? "even" : "odd"));
				
				displayQueue(maxHeap, minHeap);
				
				//calculate median
				float median = (float) minHeap.peek() + ((float)(maxHeap.peek() - minHeap.peek()) / 2);
				System.out.println("\nMedian is " + median);
				
			}
		}
	}

	private static void displayQueue(PriorityQueue<Integer> maxHeap,
			PriorityQueue<Integer> minHeap) {
		Iterator<Integer> it = maxHeap.iterator();
		
		System.out.println("===MaxHeap===");
		
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		
		it = minHeap.iterator();
		
		System.out.println("\n===MinHeap===");
		
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		
		System.out.println();
	}

}
