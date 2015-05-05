package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckGCDMathInf11 {
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);

		int t = r.nextInt();
		while (t-- > 0) {
			int N = r.nextInt(), K = r.nextInt();
			int[] a = new int[N];

			for (int i = 0; i < N; i++) {
				a[i] = r.nextInt();
			}

			if (checkGcd(a, N, K)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static long GCD(long a, long b) {
		if (a == b)
			return a;

		if (a > b)
			return GCD(a - b, b);
		else
			return GCD(a, b - a);
	}

	static boolean checkGcd(int[] a, int N, int K) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			if (a[i] % K == 0) {
				a[i] /= K;
				list.add(a[i]);
			}
		}

		if (list.size() == 0)
			return false;

		if (list.size() == 1)
			if (list.get(0) == 1)
				return true;

		long result = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			result = GCD(result, list.get(i));
		}

		if (result == 1)
			return true;

		return false;
	}
}
