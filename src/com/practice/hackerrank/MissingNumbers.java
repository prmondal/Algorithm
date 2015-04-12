package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();

		int M = sc.nextInt();
		int[] B = new int[M];
		for (int i = 0; i < M; i++)
			B[i] = sc.nextInt();

		printMissingNumbers(A, B, N, M);
	}

	static void printMissingNumbers(int[] A, int[] B, int n, int m) {
		if (n == m)
			return;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
			} else
				map.put(A[i], 1);
		}

		for (int j = 0; j < m; j++) {
			if (map.containsKey(B[j])) {
				if (map.get(B[j]) != -1) {
					if (map.get(B[j]) == 0) {
						map.put(B[j], -1);
						list.add(B[j]);
					} else
						map.put(B[j], map.get(B[j]) - 1);
				}
			} else
				list.add(B[j]);
		}

		Collections.sort(list);
		int L = list.size();

		for (int i = 0; i < L; i++) {
			if (i != L - 1)
				System.out.print(list.get(i) + " ");
			else
				System.out.print(list.get(i));
		}
	}

}
