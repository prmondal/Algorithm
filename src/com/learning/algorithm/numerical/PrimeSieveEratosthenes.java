package com.learning.algorithm.numerical;

import java.util.Scanner;

public class PrimeSieveEratosthenes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		printAllPrimes(sc.nextInt());
	}

	private static void printAllPrimes(int n) {
		// added extra element for simplicity
		int L = n + 1; 
		int[] flag = new int[L];

		for (int i = 2; i * i <= (L - 1); i++) {
			if (flag[i] == -1)
				continue;

			int j = i << 1;

			while (j <= L - 1) {
				if (flag[i] != -1) {
					flag[j] = -1;
				}

				j += i;
			}
		}

		for (int i = 2; i < L; i++) {
			if (flag[i] == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
