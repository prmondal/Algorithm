package com.learning.brokenamit;

import java.util.HashSet;
import java.util.Scanner;

public class BrokenAmit {
	public static void main(String[] args) {
		//store index of girl who has been kissed so far
		HashSet<Integer> set = new HashSet<Integer>();

		// inputs
		Scanner sc = new Scanner(System.in);
		
		//total number of girls
		int N = sc.nextInt();

		long[] L = new long[N];
		long[] D = new long[N];

		// populate love value array
		for (int i = 0; i < N; i++) {
			L[i] = sc.nextInt();
		}

		// populate decrement array
		for (int i = 0; i < N; i++) {
			D[i] = sc.nextInt();
		}
		
		//total gross value
		long grossLoveValue = 0;

		// calculate initial total love value at the very beginning
		for (int i = 0; i < N; i++) {
			grossLoveValue += L[i];
		}

		// iterate for (N - 1) steps
		// for each step calculate max reward obtained
		for (int i = 1; i < N; i++) {
			// find a girl which gives max accumulated love value for that step and kiss her
			grossLoveValue += afterKissedGirl(set, L, D, N);
		}
		
		//print gross value
		System.out.println(grossLoveValue);
	}
	
	private static long afterKissedGirl(HashSet<Integer> set, long[] l,
			long[] d, int n) {
		int maxIdx = -1;
		long maxVal = Long.MIN_VALUE;
		long totalLoveValue = 0;
		
		//iterate over number of girls
		for (int i = 0; i < n; i++) {
			//for each girl selected check total reward
			for (int j = 0; j < n; j++) {
				//the girl kissed earlier or the girl is being considered now
				if (j == i || set.contains(j)) {
					totalLoveValue += l[j];
				} else {
					// decrement value except kissed girl
					totalLoveValue += l[j] - j * d[j];
				}
			}
			
			//check for max reward and store the index	
			if (totalLoveValue >= maxVal) {
				maxVal = totalLoveValue;
				maxIdx = i;
			}
			
			//reset
			totalLoveValue = 0;
		}
			
		//add to set
		set.add(maxIdx);
		
		//decrement love value for other girls
		for (int i = 0; i < n; i++) {
			//except kissed girl
			if (!set.contains(i)) {
				l[i] -= i * d[i];
			}
		}

		return maxVal;
	}
}
