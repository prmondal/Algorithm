package com.practice.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedFibDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] line = sc.nextLine().split(" ");

		printNthNumber(Integer.valueOf(line[0]), Integer.valueOf(line[1]),
				Integer.valueOf(line[2]));
	}

	static void printNthNumber(int A, int B, int N) {
		BigInteger[] T = new BigInteger[N];

		T[0] = BigInteger.valueOf(A);
		T[1] = BigInteger.valueOf(B);

		for (int i = 2; i < N; i++)
			T[i] = T[i - 1].multiply(T[i - 1]).add(T[i - 2]);

		System.out.println(T[N - 1]);
	}

}
