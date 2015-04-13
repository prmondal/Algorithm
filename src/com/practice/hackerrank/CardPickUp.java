package com.practice.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class CardPickUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T > 0) {
			T--;

			int N = sc.nextInt();
			int[] a = new int[N];

			for (int i = 0; i < N; i++)
				a[i] = sc.nextInt();

			System.out.println(getNumberWays(a));
		}
	}

	private static long getNumberWays(int[] array) {
		int l = array.length;
		long result = 1;

		// sort the array
		Arrays.sort(array);

		for (int i = 0; i < l; i++) {
			long count = 0;

			for (int j = i; j < l; j++) {
				if (array[j] <= i)
					count++;
				else
					break;
			}
			
			result = (result * count) % 1000000007;
		}

		return result;
	}
}
