package com.learning.algorithm.array;

import java.util.Stack;

public class MaxRectHist {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {2,2,2,6,1,5,4,2,2,2,2}));
	}
	
	static int maxArea(int[] H) {
		int l = H.length;
		
		int maxArea = 0;
		int top = -1;
		int i = 0;
		
		Stack<Integer> s = new Stack<Integer>();
		
		while(i < l) {
			if(s.isEmpty() || H[i] >= H[s.peek()]) {
				s.push(i++);
			} else {
				while(!s.isEmpty() && H[s.peek()] > H[i]) {
					top = s.pop();
					
					int currArea = 0;
					
					if(s.isEmpty()) {
						currArea = H[top] * i;
					} else {
						currArea = H[top] * (i - s.peek() - 1);
					}
					
					if(currArea > maxArea) {
						maxArea = currArea;
					}
				}
				
				s.push(i++);
			}
		}
		
		while(!s.isEmpty()) {
			top = s.pop();
			
			int currArea = 0;
			
			if(s.isEmpty()) {
				currArea = H[top] * i;
			} else {
				currArea = H[top] * (i - s.peek() - 1);
			}
			
			if(currArea > maxArea) {
				maxArea = currArea;
			}
		}
		
		return maxArea;
	}
}
