package com.practice.hackerrank;

import java.math.BigInteger;

public class XORSumDP {

	public static void main(String[] args) {
		printSum("10", "1010");
	}

	static void printSum(String a, String b) {
		BigInteger A = new BigInteger(a, 2);
		BigInteger B = new BigInteger(b, 2);

		int L = 314160;
		BigInteger[] F = new BigInteger[L];
		BigInteger sum = new BigInteger("0");

		F[0] = A.xor(B);
		F[1] = A.xor(B.shiftLeft(1));
		
		sum = F[0].add(F[1]);

		for (int i = 2; i < L; i++) {
			F[i] = A.xor(B.shiftLeft(i));
			sum = sum.add(F[i]);
		}

		System.out.println(sum.mod(
				new BigInteger("" + ((int) Math.pow(10, 9) + 7))));

	}
}
