package com.practice.hackerrank;

import java.util.Scanner;

public class SherlockWatsonRotArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt(), q = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		int d = k % n;
		reverseArray(a, 0, n - d - 1);
		reverseArray(a, n - d, n - 1);
		reverseArray(a, 0, n - 1);

		for (int i = 1; i <= q; i++)
			System.out.println(a[sc.nextInt()]);
	}

	// reverse array between range
	static void reverseArray(int[] a, int l, int h) {
		for (int i = l; i < l + (h - l + 1) / 2; i++) {
			int t = a[i];
			a[i] = a[l + h - i];
			a[l + h - i] = t;
		}
	}
}
