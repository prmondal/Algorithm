package com.learning.algorithm.array;

public class MaxSumSubarray {

	public static void main(String[] args) {
		int[] a = {-2, -3, 4, -4, -2, 1, 5, 8, 100};
		
		printMaxSum(a, 0, a.length - 1);
	}

	private static void printMaxSum(int[] a, int l, int h) {
		int sumCurrent = 0;
		int maxSum = 0;
		int startIdx = 0;
		int endIdx = -1;
		
		for(int i = l; i <= h; i++) {
			sumCurrent += a[i];
			
			if(sumCurrent < 0) {
				startIdx = i + 1;
				sumCurrent = 0;
			} else {
				if(maxSum < sumCurrent) {
					maxSum = sumCurrent;
					
					endIdx = i;
				}
			}
		}
		
		System.out.println("Max sum: " + maxSum + ", startIdx: " + startIdx + " - endIdx: " + endIdx);
	}
}
