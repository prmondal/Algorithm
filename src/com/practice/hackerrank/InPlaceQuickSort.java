package com.practice.hackerrank;

import java.util.Scanner;

public class InPlaceQuickSort {
	static void quickSort(int[] ar) {
		quickSort(0, ar.length - 1, ar);
	}

	static void quickSort(int low, int high, int[] ar) {
		int pIndex = partition(low, high, ar);
		
		
		
		if (low < pIndex) {
			quickSort(low, pIndex - 1, ar);
		}

		if (high > pIndex) {
			quickSort(pIndex + 1, high, ar);
		}
	}

	static int partition(int low, int high, int[] ar) {
		if(low == high)
			return low;
		
		int pivot = ar[high];

		int j = low;

		for (int i = low; i < high; i++) {
			if (ar[i] < pivot) {
				swap(ar, j, i);
				j++;
			}
		}
		
		//swap pivot
		swap(ar, j, high);
		
		printArray(ar);

		return j;
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		quickSort(ar);
	}
}