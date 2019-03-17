package com.learning.algorithm.array;

public class MinCoinChange {

	public static void main(String[] args) {
		int[] coins = { 1, 4};
		int S = 10;

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
	
	/*
	 	for i from 0 to n
    for j from 0 to m
      if i equals 0
         table[i, j] = 1          
      else if j equals 0
         table[i, j] = 0
      else if S_j greater than i
         table[i, j] = table[i, j - 1]
      else 
         table[i, j] = table[i - S_j, j] + table[i, j - 1]

  return table[n, m]
	 */

}
