package com.learning.algorithm.array;

public class CountFrequencyInPlace {

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
		
		count(a, a.length);
	}
	
	static void printCount(int[] a, int n) {
		for(int i = 0; i < n; i++) {
			System.out.println((i+1) + " -> " + -a[i]);
		}
	}

	static void count(int[] a, int n) {
		if(n == 0) return;
		
		int i = 0;
		
		while(i < n) {
			if(a[i] <= 0) {
				i++;
				continue;
			}
			
			int elemIdx = a[i] - 1;
			
			if(a[elemIdx] > 0) {
				a[i] = a[elemIdx];
				a[elemIdx] = -1;
			} else {
				a[elemIdx]--;
				a[i] = 0;
			}
		}
		
		printCount(a, n);
	}
}
