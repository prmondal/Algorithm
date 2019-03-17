package com.learning.algorithm.numerical;

import java.util.Scanner;

public class PrintFloat {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt(), i = sc.nextInt();

		int d = N / K;
		result.append(d);
		result.append(".");

		int m = (N % K) * 10;

		while (i > 0) {
			i--;

			d = m / K;
			m = (m % K) * 10;

			result.append(d);
		}

		System.out.println(result);
	}

}
