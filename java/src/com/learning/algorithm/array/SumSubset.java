package com.learning.algorithm.array;

public class SumSubset {

	public static void main(String[] args) {
		int sum = 7;

		int[] array = new int[] { 2,3,4,5,7 };

		int[] solution = new int[array.length];

		printSubset(array, 0, array.length - 1, 0, sum, solution);
	}

	private static void printSubset(int[] array, int startIdx, int endIdx,
			int currentSum, int target, int[] solution) {
		// base case
		if (currentSum == target) {
			printSet(solution, array);

			return;
		}

		for (int i = startIdx; i <= endIdx; i++) {
			currentSum += array[i];

			// include the element
			solution[i] = 1;

			printSubset(array, i + 1, endIdx, currentSum, target, solution);

			solution[i] = 0; // reset

			currentSum -= array[i];
		}
	}

	private static void printSet(int[] solution, int[] array) {
		int l = array.length;

		for (int i = 0; i < l; i++) {
			System.out.print((solution[i] == 1) ? array[i] + ", " : "");
		}

		System.out.println();
	}

}
