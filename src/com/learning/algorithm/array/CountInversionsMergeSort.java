package com.learning.algorithm.array;

import java.util.Scanner;

public class CountInversionsMergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();

		System.out.println(mergeSort(A, 0, A.length - 1));

	}

	static int mergeSort(int[] A, int low, int high) {
		if (low >= high)
			return 0;

		int mid = low + (high - low) / 2;

		int leftInversion = mergeSort(A, low, mid);
		int rightInversion = mergeSort(A, mid + 1, high);

		return leftInversion + rightInversion + merge(A, low, mid, high);
	}

	private static int merge(int[] A, int low, int mid, int high) {
		int l = mid - low + 1;
		int r = high - mid;
		int count = 0;

		int[] L = new int[l];
		int[] R = new int[r];

		System.arraycopy(A, low, L, 0, l);
		System.arraycopy(A, mid + 1, R, 0, r);

		int i = 0, j = 0, k = low;

		while (i < l && j < r) {
			if (L[i] <= R[j]) {
				A[k++] = L[i++];
			} else {
				A[k++] = R[j++];
				count += l - i;
			}
		}

		while (i < l) {
			A[k++] = L[i++];
		}

		while (j < r) {
			A[k++] = R[j++];
		}

		return count;
	}

	static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
