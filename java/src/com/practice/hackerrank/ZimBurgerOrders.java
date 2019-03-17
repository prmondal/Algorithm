package com.practice.hackerrank;

import java.io.*;
import java.util.*;

public class ZimBurgerOrders {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 1; i <= n; i++) {
			int t = sc.nextInt();
			int d = sc.nextInt();

			map.put(t + d, i);
		}

		StringBuilder result = new StringBuilder("");

		for (Integer i : map.values()) {
			result.append(i + " ");
		}

		System.out.println(result.toString().trim());
	}
}
