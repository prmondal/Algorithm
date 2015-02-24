package com.learning.algorithm.array;

public class MinCoinChange {

	public static void main(String[] args) {
		int[] coins = { 1, 5 };
		int S = 6;

		int minChange = minChange(coins, S, coins.length);

		System.out.println(minChange);
	}

	private static int minChange(int[] coins, int S, int N) {
		int[] table = new int[S + 1];

		for (int i = 1; i <= S; i++) {
			table[i] = Integer.MAX_VALUE - 1;
		}

		for (int n = 0; n < N; n++) {
			for (int s = 1; s <= S; s++) {
				if (coins[n] <= s && table[s - coins[n]] + 1 < table[s]) {
					table[s] = table[s - coins[n]] + 1;
				}
			}
		}

		return table[S];
	}

}
