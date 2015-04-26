package com.practice.hackerrank;

import java.util.Scanner;

public class AlgorithmCrush {
	static long[] BIT;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		BIT = new long[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
			updateRange(a, b, n, k);
		}
		
		printMin(n);
	}
	
	static void printMin(int n) {
		long max = 0;
		
		for(int i = 1; i <= n; i++) {
			long q = query(i);
			
			if(q > max) {
				max = q;
			}
		}
		
		System.out.println(max);
	}
	
	static void printArray(int n) {
		for(int i = 1; i <= n; i++) {
			System.out.print(query(i) + " ");
		}
	}

	static void updateRange(int a, int b, int n, long v) {
		update(v, a, n);
		update(-v, b + 1, n);
	}

	static void update(long v, int idx, int n) {
		while (idx <= n) {
			BIT[idx] += v;
			idx += (idx & -idx);
		}
	}

	static long query(int i) {
		long r = 0;

		while (i > 0) {
			r += BIT[i];
			i -= (i & -i);
		}

		return r;
	}
}
