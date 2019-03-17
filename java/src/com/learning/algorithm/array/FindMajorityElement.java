package com.learning.algorithm.array;

public class FindMajorityElement {
	public static void main(String[] args) {
		int[] a = { 8, 1, 8, 5, 8, 1, 8 };
					// {1, 3, 3, 1, 2}; //no solution

		printMajorityElem(a);
	}

	static void printMajorityElem(int[] a) {
		int n = a.length, i = 1, count = 1;
		int mIdx = 0;

		while (i < n) {
			if (a[i] == a[mIdx]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				mIdx = i;
				count = 1;
			}

			i++;
		}

		// check whether a[mIdx] appears more than n / 2 times in the array
		i = 0;
		count = 0;

		while (i < n) {
			if (a[i] == a[mIdx])
				count++;

			i++;
		}

		System.out.println((count > n / 2) ? a[mIdx]
				: "No majority element found!");
	}
}
