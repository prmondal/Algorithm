package com.practice.hackerrank;

import java.util.*;

public class QuickSort {

	static void quickSort(int[] ar) {
		quickSort(0, ar.length - 1, ar);
	}

	static void quickSort(int low, int high, int[] ar) {
		int pIndex = partition(low, high, ar);

		if (low > pIndex) {
			return;
		}

		if (high < pIndex)
			return;

		if (low < pIndex) {
			quickSort(low, pIndex - 1, ar);

			printSubArray(low, pIndex - 1, ar);
		}

		if (high > pIndex) {
			quickSort(pIndex + 1, high, ar);

			printSubArray(pIndex + 1, high, ar);
		}
	}

	static void printSubArray(int low, int high, int[] ar) {
		if (low == high)
			return;

		for (int i = low; i <= high; i++) {
			System.out.print(ar[i] + " ");
		}

		System.out.println();
	}

	static int partition(int low, int high, int[] ar) {
		if (low >= high)
			return -1;

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		//System.out.println("Pivot: " + ar[low] + ", low: " + low + " ,high: "
			//	+ high);
		int pivot = ar[low];
		int index = low;

		for (int i = low + 1; i <= high; i++) {
			if (ar[i] < pivot) {
				list1.add(ar[i]);
				index++;
			} else {
				list2.add(ar[i]);
			}
		}

		//printList(list1, 1);
		//printList(list2, 2);

		int j = low;

		for (int i = 0; i < list1.size(); i++) {
			ar[j] = list1.get(i);
			j++;
		}

		ar[j++] = pivot;

		for (int i = 0; i < list2.size(); i++) {
			ar[j] = list2.get(i);
			j++;
		}
		
		//System.out.println("Current Array: ");
		//printArray(ar);
		
		//System.out.println("Next Pivot Index: " + (index + 1));
		return index;
	}

	private static void printList(ArrayList<Integer> list, int number) {
		System.out.println("List" + number + ": ");
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		quickSort(ar);

		printArray(ar);
	}
}
