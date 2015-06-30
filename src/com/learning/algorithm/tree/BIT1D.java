package com.learning.algorithm.tree;

public class BIT1D {
	static int[] BIT;

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int n = A.length;

		// init BIT array
		BIT = new int[n + 1];
		
		// initialize BIT for the given array
		init(A, n);
		
		// range query
		rangeSum(A, n, 1, 3);
		
		//update value
		update(n, 2, 5);
		rangeSum(A, n, 1, 3);
	}

	static void rangeSum(int[] A, int n, int i, int j) {
		if (i > j || i < 0 || j > n)
			return;

		System.out.println(query(j) - query(i - 1));
	}
	
	//increase by value
	static void update(int n, int i, int v) {
		while (i <= n) {
			BIT[i] += v;
			i += i & -i;
		}
	}

	static int query(int i) {
		int result = 0;

		while (i > 0) {
			result += BIT[i];
			i -= i & -i;
		}

		return result;
	}

	static void init(int[] A, int n) {
		for (int i = 1; i <= n; i++) {
			update(n, i, A[i - 1]);
		}
	}
}
