package com.practice.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class SuperPowersOfTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt(), b = sc.nextInt();

		BigInteger result = new BigInteger("4");

		for (int i = 1; i < a; i++) {
			result = result.pow(2).mod(BigInteger.valueOf(b));
		}

		System.out.println(result.mod(BigInteger.valueOf(b)));
	}

}
