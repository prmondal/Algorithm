package com.learning.algorithm.array;

import java.util.Scanner;

public class MinJumpReacEnd {

	public static void main(String[] args) {
		int[] array;

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}

		System.out.println("Min Jump : " + minJump(array, 0, array.length - 1)); // {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}
		//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} -> 3
	}

	private static int minJump(int[] array, int l, int h) {
		if (l == h)
			return 0;

		int min = Integer.MAX_VALUE;

		if (array[l] == 0)
			return min;

		// minJump(a, l, h) = min {minJump(a, k, h)}, for all k reachable from l
		for (int j = l + 1; j <= l + array[l] && j <= h; j++) {
			int nextMin = minJump(array, j, h);

			if (nextMin + 1 < min && nextMin != Integer.MAX_VALUE) {
				min = nextMin + 1;
			}
		}

		return min;
	}

}
