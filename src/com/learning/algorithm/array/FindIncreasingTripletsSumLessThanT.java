package com.learning.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FindIncreasingTripletsSumLessThanT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		printTripletsVer1(A);
	}

	static void printTripletsVer1(int[] A) {
		int l = A.length;
		int count = 0;
		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				if (A[i] >= A[j])
					continue;

				for (int k = j + 1; k < l; k++) {
					if (A[j] >= A[k])
						continue;
					String key = "" + A[i] + A[j] + A[k];
					
					if(!set.contains(key)) {
						set.add(key);
						//System.out.println(A[i] + " " + A[j] + " " + A[k]);
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}
	
	static void printTripletsVer2(int[] A) {
		int l = A.length;
		int count = 0;
		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				if (A[i] >= A[j])
					continue;

				for (int k = j + 1; k < l; k++) {
					if (A[j] >= A[k])
						continue;
					String key = "" + A[i] + A[j] + A[k];
					
					if(!set.contains(key)) {
						set.add(key);
						//System.out.println(A[i] + " " + A[j] + " " + A[k]);
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	// sort the array and remove duplicates in place
	static int[] removeDuplicates(int[] A) {
		int l = A.length;
		if (l == 0)
			return null;

		Arrays.sort(A);
		int resIdx = 1, currIdx = 1;

		while (currIdx < l) {
			if (A[currIdx] != A[currIdx - 1]) {
				A[resIdx] = A[currIdx];
				resIdx++;
			}

			currIdx++;
		}

		int[] result = new int[resIdx];

		// trim rest of the elements
		System.arraycopy(A, 0, result, 0, resIdx);

		return result;
	}

	// using set without sorting the array
	static int[] removeDuplicatesPreservingOrder(int[] A) {
		int l = A.length;
		if (l == 0)
			return new int[] {};

		HashSet<Integer> set = new HashSet<Integer>();

		int resIdx = 0, currIdx = 0;

		while (currIdx < l) {
			if (!set.contains(A[currIdx])) {
				set.add(A[currIdx]);

				A[resIdx] = A[currIdx];
				resIdx++;
			}

			currIdx++;
		}

		int[] result = new int[resIdx];

		// trim rest of the elements
		System.arraycopy(A, 0, result, 0, resIdx);

		return result;
	}
}
