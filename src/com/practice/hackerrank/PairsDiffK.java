package com.practice.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class PairsDiffK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt(); 
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) 
			A[i] = sc.nextInt();
		
		countPairs(A, K);
	}
	
	static void countPairs(int[] A, int K) {
		HashSet<Integer> set = new HashSet<Integer>();
		int L = A.length;
		int count = 0;
		
		set.add(A[0]);
		
		for(int i = 1; i < L; i++) {
			if(set.contains(A[i] - K)) {
				count++;
			}
			
			if(set.contains(K + A[i])) {
				count++;
			}
			
			set.add(A[i]);
		}
		
		System.out.println(count);
	}
}
