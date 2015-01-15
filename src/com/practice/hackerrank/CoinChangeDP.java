package com.practice.hackerrank;

import java.util.Scanner;

public class CoinChangeDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] arr = sc.nextLine().replaceAll(" ", "").split(",");

		int[] coins = new int[arr.length];

		int i = 0;

		for (String str : arr) {
			coins[i++] = Integer.valueOf(str);
		}

		int S = sc.nextInt();
		
		changeCoin(coins, S);
	}

	private static void changeCoin(int[] coins, int S) {
		int L = coins.length;

		int[][] table = new int[L + 1][S + 1];

		for (int n = 0; n <= L; n++) {
			for (int s = 0; s <= S; s++) {
				if (n == 0) {
					table[n][s] = 0;
					continue;
				}

				if (s == 0) {
					table[n][s] = 1;
					continue;
				}
				
				if (coins[n - 1] > s) {
					table[n][s] = table[n - 1][s];
				} else {
					table[n][s] = table[n - 1][s] + table[n][s - coins[n - 1]];
				}
			}
		}
		
		System.out.println(table[L][S]);
	}
}
