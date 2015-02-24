package com.learning.algorithm.array;

import java.util.Date;
import java.util.Scanner;

public class AllSubsetAlt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		int subsetSize = (int) Math.pow(2.0, str.length());

		printAllSubset(str.toCharArray(), subsetSize);
	}

	private static void printAllSubset(char[] a, int subsetSize) {
		long startTime = new Date().getTime();
		
		for (int i = 1; i < subsetSize; i++) {
			int l = 0;

			while (l < a.length) {
				if ((i & (1 << l)) != 0) {
					System.out.print(a[l] + " ");
				}

				l++;
			}
			System.out.println();
		}
		
		long duration = new Date().getTime() - startTime;
		System.out.println("Execution time : " + duration/1000f + " sec");
	}
}
