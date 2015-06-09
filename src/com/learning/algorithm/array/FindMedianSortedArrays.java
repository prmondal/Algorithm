package com.learning.algorithm.array;

public class FindMedianSortedArrays {

	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int b[] = { 8, 9 };

		System.out.print(findMedian(a, b, 0, a.length - 1, 0, b.length - 1));
	}

	// find median of two equal sized arrays o(n)
	static float getMedian(int[] a, int[] b) {
		int m1 = -1, m2 = -1, n = a.length;

		int i = 0, j = 0, count = 0;

		while (count <= n) {
			if (i == n) {
				m1 = m2;
				m2 = b[j];

				break;
			}

			if (j == n) {
				m1 = m2;
				m2 = a[i];

				break;
			}

			if (a[i] < b[j]) {
				m1 = m2;
				m2 = a[i];
				i++;
			} else {
				m1 = m2;
				m2 = b[j];
				j++;
			}

			count++;
		}

		return (float) (m1 + m2) / 2;
	}

	//o(logn)
	static float findMedian(int[] a, int[] b, int l1, int h1, int l2, int h2) {
		int m1 = l1 + (h1 - l1) / 2;
		int m2 = l2 + (h2 - l2) / 2;

		if (a[m1] == b[m2])
			return a[m1];

		if (h1 - l1 == 1 && h2 - l2 == 1) {
			return (float) (Math.max(a[l1], b[l2]) + Math.min(a[h1], b[h2])) / 2;
		}

		if (h1 == l1 && h2 == l2) {
			return (float) (a[l1] + b[l2]) / 2;
		}

		if (h1 - l1 == 1 && h2 == l2) {
			return (float) (Math.max(a[l1], b[l2]) + a[h1]) / 2;
		}

		if (h2 - l2 == 1 && h1 == l1) {
			return (float) (Math.max(a[l1], b[l2]) + a[h2]) / 2;
		}

		if (a[m1] > b[m2]) {
			return findMedian(b, a, m2, h2, l1, m1);
		}

		return findMedian(a, b, m1, h1, l2, m2);
	}
}
