package com.learning.algorithm.array;

public class SearchRotatedArray {

	public static void main(String[] args) {
		int a[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };

		System.out.println(printIndex(a, 3));
	}

	static int printIndex(int[] a, int num) {
		int pivot = findPivot(a, 0, a.length - 1);

		if (pivot == -1) {
			return binarySearch(a, num, 0, a.length - 1);
		}

		if (a[pivot] == num)
			return pivot;

		if (num > a[0]) {
			return binarySearch(a, num, 0, pivot - 1);
		}

		return binarySearch(a, num, pivot + 1, a.length - 1);
	}

	static int findPivot(int[] a, int l, int h) {
		if (l > h)
			return -1;
		if (l == h)
			return l;

		int mid = l + (h - l) / 2;

		if (mid + 1 <= h && a[mid] > a[mid + 1]) {
			return mid;
		}

		if (mid - 1 >= l && a[mid - 1] > a[mid]) {
			return mid - 1;
		}

		if (a[mid] >= a[l]) {
			return findPivot(a, mid + 1, h);
		}

		return findPivot(a, l, mid - 1);
	}

	static int binarySearch(int[] a, int n, int l, int h) {
		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (a[mid] == n)
				return mid;

			if (a[mid] > n) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return -1;
	}

}
