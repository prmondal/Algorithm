package com.learning.algorithm.bits;

//http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
public class BitsFun {

	public static void main(String[] args) {
		int n = 11;
		System.out.println("Original number: " + Integer.toBinaryString(n));
		System.out.println("Reverse number: "
				+ Integer.toBinaryString(reverse(n)));

		System.out.println(toggleKthBit(5, 0));
	}

	// find length of the integer in number of bits
	static int getBitLength(int n) {
		return (int) Math.ceil(Math.log((double) n) / Math.log(2.0));
	}

	// reverse integer
	static int reverse(int n) {
		if (n == 0)
			return n;

		int reverse = 0;
		int c = getBitLength(n);

		// loop through bits and if the current bit is set in n put set bit in
		// ((NO_OF_BITS - 1) - i) location in reverse
		for (int i = 0; i < c; i++) {
			if ((n & (1 << i)) != 0) {
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

	static boolean isOdd(long n) {
		return (n & 1) != 0;
	}

	static boolean isPowerOfTwo(long n) {
		return (n & (n - 1)) == 0;
	}

	static boolean isKthBitSet(long n, int k) {
		return (n & (1 << k)) != 0;
	}

	static long setKthBit(long n, int k) {
		return n | (1 << k);
	}

	static long toggleKthBit(long n, int k) {
		return n ^ (1 << k);
	}

	static long turnOffRightMostOneBit(long n) {
		return n & (n - 1);
	}

	static long turnOnRightMostZeroBit(long n) {
		return n | (n + 1);
	}

	static long isolateRightMostOneBit(long n) {
		return n & (-n);
	}

	static long isolateRightMostZeroBit(long n) {
		return ~n & (n + 1);
	}
}
