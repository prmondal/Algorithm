package com.learning.algorithm.array;

public class SortEvenOdd {

	public static void main(String[] args) {
		int[] a = { 0,1 };

		int pivot = partitionOddEven(a, 0, a.length - 1);

		quickSort(a, 0, pivot - 1, true);
		quickSort(a, pivot, a.length - 1, false);
		printArray(a, 0, a.length - 1);
	}

	static void printArray(int[] a, int l, int h) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static void quickSort(int[] a, int l, int h, boolean increasingOrder) {
		if (l <= h) {
			int pivot = partition(a, l, h, increasingOrder);
			quickSort(a, l, pivot - 1, increasingOrder);
			quickSort(a, pivot + 1, h, increasingOrder);
		}
	}

	static int partition(int[] a, int l, int h, boolean increasingOrder) {
		int i = l;
		int pivot = a[h];

		for (int j = l; j <= h; j++) {
			if (increasingOrder) {
				if (a[j] < pivot) {
					swap(a, i, j);
					
					i++;
				}
			} else {
				if (a[j] > pivot) {
					swap(a, i, j);

					i++;
				}
			}
		}

		swap(a, i, h);

		return i;
	}

	static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static int partitionOddEven(int[] a, int l, int h) {
		int i = l;

		for (int j = l; j <= h; j++) {
			if ((a[j] & 1) != 0) {
				swap(a, i, j);

				i++;
			}
		}

		swap(a, i, h);

		return i;
	}

}
