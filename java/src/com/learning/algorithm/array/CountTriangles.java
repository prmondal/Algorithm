package com.learning.algorithm.array;

import java.util.Arrays;

public class CountTriangles {

	public static void main(String[] args) {
		int[] a = {10, 21, 22, 100, 101, 200, 300};

		Arrays.sort(a);

		System.out.println(countTriangles(a, a.length));
	}

	private static int countTriangles(int[] a, int l) {

		int count = 0;

		for (int k = l - 1; k >= 2; k--) {
			int i = 0;
			int j = k - 1;

			while (i < j) {
				if (a[i] + a[j] > a[k]) {
					count += j - i;
					j--;
				} else {
					i++;
				}
			}
		}

		return count;
	}
}
