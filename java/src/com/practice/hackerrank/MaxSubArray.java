package com.practice.hackerrank;

import java.util.Scanner;

public class MaxSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] a = new int[N];
			
			for(int i = 0; i < N; i++) 
				a[i] = sc.nextInt();
			
			System.out.println(printMaxSumDP(a) + " " + printMaxSumNonCont(a));
		}
	}

	private static int printMaxSumDP(int[] a) {
		int l = a.length;

		int currentSum = a[0];
		int maxSum = a[0];

		for (int i = 1; i < l; i++) {
			currentSum = Math.max(currentSum + a[i], a[i]);
			maxSum = Math.max(currentSum, maxSum);
		}

		return maxSum;
	}

	private static int printMaxSumNonCont(int[] a) {
		int l = a.length;
		int maxSum = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < l; i++) {
			if (a[i] >= 0) {
				maxSum += a[i];
			} else {
				max = Math.max(max, a[i]);
			}
		}

		return (maxSum == 0) ? max : maxSum;
	}
}
