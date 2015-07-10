package com.learning.algorithm.numerical;

public class BinomialCoeff {
	static final int BIN_MAX = 1000;
	static long[][] binomial = new long[BIN_MAX + 1][BIN_MAX + 1];
	
	public static void main(String[] args) {
		System.out.println(bin(5, 2));

	}
	
	//Lilavati's Method
	static long binLilavati(int n, int k) {
		if (n < k || n == 0) {
			binomial[n][k] = 0;
			return 0;
		}

		if (k == 0) {
			binomial[n][k] = 1;
			return 1;
		}

		if (binomial[n][k] != 0)
			return binomial[n][k];

		binomial[n][k] = (n / k) * bin(n - 1, k - 1);
		return binomial[n][k];
	}
	
	static long cacheBin(int N, int K) {
		if (K < 0) {
			return 0;
		}

		if (K > N) {
			binomial[N][K] = 0;
			return 0;
		}

		if (K == 0 || N == K) {
			binomial[N][K] = 1;
			return binomial[N][K];
		}

		if (binomial[N][K] != 0)
			return binomial[N][K];

		binomial[N][K] = bin(N - 1, K - 1) + bin(N - 1, K);
		return binomial[N][K];
	}

	// find C(N, K)
	static long bin(int N, int K) {
		if (N < K)
			return -1;
		long[][] table = new long[N + 1][N + 1];

		for (int n = 0; n <= N; n++) {
			table[n][0] = 1;
		}

		for (int n = 0; n <= N; n++) {
			table[n][n] = 1;
		}

		for (int n = 1; n <= N; n++) {
			for (int k = 1; k <= Math.min(n, K); k++) {
				table[n][k] = table[n - 1][k - 1] + table[n - 1][k];
			}
		}

		return table[N][K];
	}

}
