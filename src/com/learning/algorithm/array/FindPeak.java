package com.learning.algorithm.array;

public class FindPeak {

	public static void main(String[] args) {
		//1D peak
		//int[] a = {3, 2, 3, 5, 3};
		//System.out.println(findPeak1D(a, 0, a.length - 1));
		
		//2D peak
		int[][] g = {
				{1,2,3,4,5,6},
				{3,10,5,6,8,4},
				{3,4,5,6,7,4}
		};
		
		System.out.println(findPeak2D(g, 0, g[0].length - 1, g.length));
	}
	
	//find peak in 1D array
	static int findPeak1D(int[] a, int l, int h) {
		int mid = l + (h - l) / 2;

		// middle elem is a peak
		if (mid > l && mid + 1 <= h) {
			if (a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1]) {
				return a[mid];
			}
		}

		// start or end elem
		if (mid == l || mid == h)
			return a[mid];

		// left elem is greater than middle
		if (mid > l && a[mid] < a[mid - 1]) {

			return findPeak1D(a, l, mid - 1);
		}

		// right is greater than middle
		if (mid + 1 <= h && a[mid] < a[mid + 1]) {
			return findPeak1D(a, mid + 1, h);
		}

		return -1;
	}
	
	static int findPeak2D(int[][] g, int l, int h, int m) {
		int mid = l + (h - l) / 2;
		
		//find global maximum in the mid col
		int max = Integer.MIN_VALUE, mIdx = -1;
		
		for(int i = 0; i < m; i++) {
			if(g[i][mid] > max) {
				max = g[i][mid];
				mIdx = i;
			}
		}
		
		if(mid - 1 >= l && mid + 1 <= h) {
			if(g[mIdx][mid] >= g[mIdx][mid - 1] && g[mIdx][mid] >= g[mIdx][mid + 1]) {
				return g[mIdx][mid];
			}
		}
		
		if(mid - 1 >= l && g[mIdx][mid] < g[mIdx][mid - 1]) {
			return findPeak2D(g, l, mid - 1, m);
		}
		
		if(mid + 1 <= h && g[mIdx][mid] < g[mIdx][mid + 1]) {
			return findPeak2D(g, mid + 1, h, m);
		}
		
		if(mid == l || mid == h) {
			return g[mIdx][mid];
		}
		
		return -1;
	}

}
