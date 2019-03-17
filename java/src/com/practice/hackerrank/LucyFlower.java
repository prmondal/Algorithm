package com.practice.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class LucyFlower {
	static final int MAX = 5000;
	static BigInteger[] fact = new BigInteger[2 * MAX + 1];

	/*static long bin(int n, int k) {
		if (n < k)
			return 0;

		if (k == 0 || k == n) {
			binomial[n][k] = 1;
			return 1;
		}

		if (binomial[n][k] != 0)
			return binomial[n][k];

		binomial[n - 1][k - 1] = bin(n - 1, k - 1);
		binomial[n - 1][k] = bin(n - 1, k);

		return binomial[n - 1][k - 1] + binomial[n - 1][k];
	}*/
	
	static BigInteger fact(int n) {
		if(n == 1) {
			fact[n] = new BigInteger("1");
			return fact[n];
		}
		
		if(fact[n] != null && fact[n].longValue() != 0) {
			return fact[n];
		}
		
		fact[n] = BigInteger.valueOf(n).multiply(fact[n - 1]);
		return fact[n];
	}

	static long catalan(int n) {
		return fact[2 * n].divide(fact[n]).divide((fact[n + 1])).mod(BigInteger.valueOf(1000000009)).longValue();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 2 * MAX; i++)
			fact(i);
		
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			long count = 0;

			for (int j = 1; j <= n; j++) {
				if(j != n) count += catalan(j) * fact[n].divide(fact[j]).divide(fact[n - j]).longValue();
				else count += catalan(j);
			}

			System.out.println(count % 1000000009);
		}

	}
}
