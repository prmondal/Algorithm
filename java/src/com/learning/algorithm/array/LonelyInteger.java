package com.learning.algorithm.array;

import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] count = new int[100];

		for (int i = 0; i < N; i++) {
			count[sc.nextInt()]++;
		}

		for (int i = 0; i < 100; i++) {
			if (count[i] == 1) {
				System.out.println(i);
				break;
			}
		}
	}

}
