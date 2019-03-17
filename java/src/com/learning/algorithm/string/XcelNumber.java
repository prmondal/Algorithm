package com.learning.algorithm.string;

import java.util.Scanner;

public class XcelNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter XCel column number...");
		long n = sc.nextLong();
		System.out.print("XCel column name corresponds to " + n + " is ");
		printXcelColumnName(n);

		System.out.print("\n\nEnter XCel column name...");
		String s = sc.next();
		System.out.println("XCel column number corresponds to " + s + " is ");
		printXcelNumber(s);
	}

	// given a number print Excel column name
	static void printXcelColumnName(long n) {
		if (n <= 0) {
			return;
		}

		long d = (n - 1) / 26;
		long m = (n - 1) % 26;

		printXcelColumnName(d);
		System.out.print((char) (m % 26 + 'A'));
	}

	static void printXcelNumber(String colName) {
		int l = colName.length();

		if (l == 0)
			return;

		long result = 0;

		for (int i = 0; i < l; i++)
			result = 26 * result + (colName.charAt(i) - 'A' + 1);

		System.out.print(result);
	}
}
