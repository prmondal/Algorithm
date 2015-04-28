package com.learning.algorithm.bits;

public class BitsFun {

	public static void main(String[] args) {
		int n = 110;
		System.out.println("Original number: " + Integer.toBinaryString(n));
		System.out.println("Reverse number: "
				+ Integer.toBinaryString(reverse(n)));
		// System.out.println(getLength(n));
	}

	// find length of the integer in number of bits
	private static int getLength(int n) {
		return (int) Math.ceil(Math.log((double) n) / Math.log(2.0));
	}

	// reverse integer
	private static int reverse(int n) {
		if (n == 0)
			return n;

		int reverse = 0;
		int c = getLength(n);

		// loop through bits and if the current bit is set in n put set bit in
		// ((NO_OF_BITS - 1) - i) location in reverse
		for (int i = 0; i < c; i++) {
			if (((n & (1 << i)) >> i) == 1) {
				reverse |= 1 << ((c - 1) - i);
			}
		}

		return reverse;
	}

	static int countOnes(long n) {
		int count = 0;

		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}
}
