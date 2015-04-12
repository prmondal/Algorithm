package com.practice.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class CandyDistributeDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] ranks = new int[N];

		for (int i = 0; i < N; i++)
			ranks[i] = sc.nextInt();

		printMinimumCandies(ranks);
	}

	private static void printMinimumCandies(int[] ranks) {
		int l = ranks.length;

		int[] result = new int[l];
		Arrays.fill(result, 1);

		for (int i = 1; i < l; i++) {
			if (ranks[i] > ranks[i - 1]) {
				result[i] = result[i - 1] + 1;
			}
		}

		for (int i = l - 2; i >= 0; i--) {
			if (ranks[i] > ranks[i + 1]) {
				result[i] = Math.max(result[i], result[i + 1] + 1);
			}
		}

		int minCanides = 0;

		for (int i = 0; i < l; i++)
			minCanides += result[i];

		System.out.println(minCanides);
	}
}
