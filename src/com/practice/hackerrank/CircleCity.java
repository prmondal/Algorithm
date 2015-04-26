package com.practice.hackerrank;

import java.util.Scanner;

public class CircleCity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t > 0) {
			t--;

			int N = sc.nextInt(), K = sc.nextInt();

			System.out.println(placeStations(N, K) ? "possible" : "impossible");
		}
	}

	static boolean placeStations(int N, int K) {
		int count = 0;
		
		for (int i = 1; i * i <= N; i++) {
			if (isPerfectSquare(N - i * i)) {
				count += 4;
				System.out.println(N - i * i);
			}
		}
		
		System.out.println(count);
		
		return (count <= K);
	}
	
	static boolean isPerfectSquare(int N) {
		int sq = (int) Math.sqrt(N);
		
		return sq * sq == N;
	}
}
