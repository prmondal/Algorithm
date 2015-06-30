package com.learning.algorithm.array;

import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

		suffle(a);
		
		print(a);
	}

	static void print(int[] a) {
		for (int i = 0, l = a.length; i < l; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static void suffle(int[] a) {

		for (int l = a.length, i = l - 1; i > 0; i--) {
			int j = new Random(System.currentTimeMillis()).nextInt(i + 1);

			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
	}
}
