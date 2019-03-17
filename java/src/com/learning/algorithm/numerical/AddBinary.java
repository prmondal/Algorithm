package com.learning.algorithm.numerical;

public class AddBinary {

	public static void main(String[] args) {
		int a = 30;
		int b = 34;

		System.out.println(add(a, b));
	}

	static int add(int a, int b) {
		if (a == 0)
			return b;

		int s = a ^ b;
		int c = (a & b) << 1;

		return add(c, s);
	}
}
