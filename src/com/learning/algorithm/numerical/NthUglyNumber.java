package com.learning.algorithm.numerical;

public class NthUglyNumber {
	public static void main(String[] args) {
		int N = 11;

		printNthUglyNumber(N);
	}

	private static boolean isUglyNumber(int n) {
		if (n == 0)
			return false;

		n = maxDivide(n, 2);
		n = maxDivide(n, 3);
		n = maxDivide(n, 5);

		if (n == 1)
			return true;

		return false;
	}

	private static int maxDivide(int n, int i) {
		while (n % i == 0)
			n = n / i;

		return n;
	}

	private static void printNthUglyNumber(int n) {
		if (n == 1)
			System.out.println(n);

		int count = 1;
		int i = 1;
		
		while(true) {
			i++;
		
			if (isUglyNumber(i))
				count++;

			if (count == n) {
				System.out.println(i);
				return;
			}
		}
	}
}
