package com.learning.algorithm.numerical;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(powBERL(sc.nextInt(), sc.nextInt()));
	}

	// binary exponentiation right to left
	//http://mathforum.org/library/drmath/view/55603.html
	static long powBERL(int a, int b) {
		if (b == 0)
			return 1;

		if (a == 0)
			return 0;

		long result = 1;

		while (b > 0) {
			if ((b & 1) != 0) {
				result *= a;
			}

			a = a * a;
			b = b >> 1;
		}

		return result;
	}
	
	// binary exponentiation left to right
	static long powBELR(int a, int b) {
		if (b == 0)
			return 1;

		if (a == 0)
			return 0;

		long result = 1;

		while (b > 1) {
			
		}
		
		return result;
	}

	// iterative
	private static long printPower(int x, int n) {
		if (n == 0)
			return 1;

		if (x == 0)
			return 0;

		long result = 1;

		while (n > 0) {
			if (n % 2 == 0) {
				n = n >> 1;

				x = x * x;
			} else {
				n--;

				result *= x;
			}
		}

		return result;
	}

	// recursive
	private static long power(int x, int n) {
		if (n == 0)
			return 1;

		if (x == 0)
			return 0;

		long result = power(x, n / 2);

		// even
		if (n % 2 == 0) {
			return result * result;
		} else {
			return x * result * result;
		}
	}
}
