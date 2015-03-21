package com.learning.algorithm.backtracking;

import java.util.Arrays;

public class NQueen {

	public static void main(String[] args) {
		int N = 4;

		// hold previously queen positions
		int[] placement = new int[N];

		Arrays.fill(placement, -1);

		if(placeNQueens(0, N, placement)) {
			// print grid
			printPlacement(placement, N);
		} else {
			System.out.println("No solutions possible!");
		}
		
	}

	private static void printPlacement(int[] placement, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (placement[i] == j) {
					System.out.print(" Q ");
				} else {
					System.out.print(" . ");
				}
			}

			System.out.println();
		}
	}

	// return true if the queen can be placed in kth row and jth column safely
	// else return false
	static boolean isValid(int k, int j, int N, int[] placement) {
		if (k > N || k < 0 || j < 0 || j > N) {
			return false;
		}

		// loop through all previous rows to check for collision
		for (int i = 0; i <= k - 1; i++) {
			// if queen is placed at jth column in previous row or queen is
			// placed diagonally with the previous queen
			if (placement[i] != j) {
				if (placement[i] != -1
						&& Math.abs(placement[i] - j) == Math.abs(i - k)) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	// place queen at ith row and jth column
	static void place(int i, int j, int N, int[] placement) {
		if (i > N || i < 0 || j < 0 || j > N) {
			return;
		}

		placement[i] = j;
	}

	// place NQueens in the board
	static boolean placeNQueens(int k, int N, int[] placement) {
		// loop through all columns
		for (int j = 0; j < N; j++) {
			if (isValid(k, j, N, placement)) {
				place(k, j, N, placement);
				
				if (k == N - 1) {
					return true;
				}
				
				//Need to check
				System.out.println("row: " + k + ", col: " + j + ": valid");
				
				// recur from next row
				if (placeNQueens(k + 1, N, placement)) {
					return true;
				}
			}

			// backtrack triggers here if there were no valid placement found
			placement[k] = -1;
		}

		return false;
	}
}
