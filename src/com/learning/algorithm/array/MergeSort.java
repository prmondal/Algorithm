package com.learning.algorithm.array;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// int[] array = new int[] { 100, 90, 80, 70, 60, 50, 40, 80, 30, 20, 10
		// };
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] array = new int[N];

		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		mergeSort(array, 0, array.length - 1);

		printArray(array);

	}

	private static void mergeSort(int[] array, int low, int high) {
		if (low >= high)
			return;

		int mid = low + (high - low) / 2;

		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);

		merge(array, low, mid, high);

	}

	private static void merge(int[] array, int low, int mid, int high) {
		int l = mid - low + 1;
		int r = high - mid;

		int[] L = new int[l];
		int[] R = new int[r];

		System.arraycopy(array, low, L, 0, l);
		System.arraycopy(array, mid + 1, R, 0, r);

		int i = 0, j = 0, k = low;

		while (i < l && j < r) {
			if (L[i] < R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}

			k++;
		}

		while (i < l) {
			array[k] = L[i];
			i++;
			k++;
		}

		while (j < r) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}
