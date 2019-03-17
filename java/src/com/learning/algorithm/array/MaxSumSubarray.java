package com.learning.algorithm.array;

public class MaxSumSubarray {

	public static void main(String[] args) {
		int[] a = {2 ,-1 ,2 ,3, 4, -5};
		
		//printMaxSum(a, 0, a.length - 1);
		System.out.println(printMaxSumDP(a));
		
		a = new int[]{3,3,9,9,5};
		
		System.out.println("  " + printMaxSumDPModuloN(a, 7));
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
	
	//dp based
	private static int printMaxSumDP(int[] a) {
		int l = a.length;
		
		int currentSum = a[0];
		int maxSum = a[0];
		
		for(int i = 1; i < l; i++) {
			currentSum = Math.max(currentSum + a[i], a[i]);
			maxSum = Math.max(currentSum, maxSum);
		}
		
		return maxSum;
	}
	
	private static long printMaxSumDPModuloN(int[] a, long N) {
		int l = a.length;
		
		long currentSum = a[0] % N;
		long maxSum = currentSum;
		
		for(int i = 1; i < l; i++) {
			currentSum = Math.max(currentSum + a[i], a[i]) % N;
			maxSum = Math.max(currentSum, maxSum);
		}
		
		return maxSum;
	}
	
	private static int printMaxSumNonCont(int[] a) {
		int l = a.length;
		int maxSum = 0;
		
		for(int i = 0; i < l; i++) {
			if(a[i] > 0)
				maxSum += a[i];
		}
		
		return maxSum;
	}
}
