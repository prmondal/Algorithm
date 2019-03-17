package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LongestIncSubDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] array = new int[N];

		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		printLengthLIS(array);

		// printMaxLengthLongestIncSubSeq(array);

	}

	// O(N^2) solution using DP
	private static void printMaxLengthLongestIncSubSeq(int[] array) {
		int L = array.length;
		int[] T = new int[L + 1];

		Arrays.fill(T, 1);

		int result = 0;

		for (int i = 1; i <= L; i++) {
			for (int j = 0; j < i - 1; j++) {
				if (array[i - 1] > array[j]) {
					if (T[j + 1] + 1 > T[i]) {
						T[i] = T[j + 1] + 1;
					}
				}
			}

			result = Math.max(result, T[i]);
		}

		System.out.println(result);
	}

	// finding LIS inspired by Patience sorting
	// binary search on stacks
	private static int binarySearchStacks(Stack<Integer> test,
			ArrayList<Stack<Integer>> piles, int low, int high) {
		if (low > high)
			return -1;

		// get mid index of piles list
		int mid = low + (high - low) / 2;

		if (piles.get(mid).peek() < test.peek()) {
			// search in right
			return binarySearchStacks(test, piles, mid + 1, high);
		} else {
			// search in left
			// the key has to be placed in the pile as far left possible
			int idx = binarySearchStacks(test, piles, low, mid - 1);

			// if the element can not be placed in left half place in the middle
			if (idx == -1)
				return mid;

			return idx;
		}
	}

	// calculate LIS length using Patience Sort
	private static void printLengthLIS(int[] a) {
		int L = a.length;

		if (L == 0)
			return;

		// create piles list
		ArrayList<Stack<Integer>> piles = new ArrayList<Stack<Integer>>();

		// patience sort starts
		// insert first element
		Stack<Integer> initialPile = new Stack<Integer>();
		initialPile.add(a[0]);

		// add it to the piles list
		piles.add(initialPile);

		for (int i = 1; i < L; i++) {
			Stack<Integer> pile = new Stack<Integer>();
			pile.add(a[i]);

			// get index of the pile in the list
			int idx = binarySearchStacks(pile, piles, 0, piles.size() - 1);

			if (idx == -1) {
				// add the stack to the end of the array list
				piles.add(pile);
			} else {
				piles.get(idx).add(a[i]);
			}
		}

		System.out.println(piles.size());
	}
}
