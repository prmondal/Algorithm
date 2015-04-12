package com.practice.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class IceCreamPerlour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			t--;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int[] flavs = new int[N];

			for (int i = 0; i < N; i++)
				flavs[i] = sc.nextInt();

			int idx1 = -1, idx2 = -1;

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.put(flavs[0], 0);

			for (int j = 1; j < N; j++) {
				int v = M - flavs[j];

				if (map.get(v) != null) {
					idx1 = map.get(v) + 1;
					idx2 = j + 1;

					break;
				}
			}

			System.out.println(idx1 + " " + idx2);
		}
	}
}
