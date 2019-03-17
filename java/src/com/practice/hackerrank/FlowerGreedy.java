package com.practice.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FlowerGreedy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), K = sc.nextInt();
		
		int[] cost = new int[N];
		
		for(int i = 0; i < N; i++)
			cost[i] = sc.nextInt();
		
		Arrays.sort(cost);
		
		reverse(cost);
		
		minCost(cost, N, K);
	}
	
	static void reverse(int[] cost) {
		int l = cost.length, i = 0, j = l - 1;
		
		while(i < j) {
			int t = cost[i];
			cost[i] = cost[j];
			cost[j] = t;
			
			i++;
			j--;
		}
	}
	
	//N - Items left
	//K - friends remain
	/*static int minCost(int[] cost, int N, int L, int K) {
		if(L < K)
			return -1;
		
		int sum = 0;

		if (L == K) {
			for (int i = N - L; i < N; i++) {
				sum += cost[i];
			}
			
			//System.out.println("same");

			return sum;
		}

		if (K == 1) {
			for (int i = N - L; i < N; i++) {
				sum += (i + 1 - (N - L)) * cost[i];
				//System.out.println("i + 1 - (N - L): " + (i + 1 - (N - L)) + " ,cost[i]: " + cost[i]);
			}

			return sum;
		}
		
		//System.out.println("cost[N - L]: " + cost[N - L]);
		return cost[N - L] + minCost(cost, N, L - 1, K - 1);
	}*/
	
	static void minCost(int[] cost, int N, int K) {
		int[] flowers = new int[K];
		int minCost = 0;
		
		int i = 0;
		
		while(i < N) {
			Arrays.sort(flowers);
			
			minCost += cost[i] * (flowers[0] + 1);
			flowers[0] += 1;
			
			i++;
		}
		
		System.out.println(minCost);
	}
}
