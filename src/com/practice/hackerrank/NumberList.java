package com.practice.hackerrank;

import java.util.Scanner;

public class NumberList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			t--;
			int N = sc.nextInt(), K = sc.nextInt();
			int[] a = new int[N];

			for (int i = 0; i < N; i++)
				a[i] = sc.nextInt();

			count(a, N, K);
		}

	}
	
	static void count(int[] a, int N, int K) {
		int i = 0, j = 0; 
		long count = 0;
		long[] b = new long[N];
		
		while(i < N) {
			if(a[i] <= K) 
				count++;
			else 
				if(count > 0) {b[j++] = count; count = 0;}
			
			i++;
		}
		

		if(count > 0) {b[j++] = count; count = 0;}
		
		long result = 0;
		j = 0;
		
		while(j < N) {
			result += b[j] * (b[j] + 1) / 2;
			j++;
		}
		
		 result = (long)N * ((long) N + 1) / 2 - result;
		
		System.out.println(result);
	}
	
	/*static void count(int[] a, int N, int K) {
		long count = 0;

		long[] L = new long[N];
		int rightMaxIdx = -1, max = 0;
		int leftMaxIdx = -1, leftMax = 0;
		
		L[0] = 1;
		
		//System.out.print(L[0] + " ");
		
		for(int i = 1; i < N; i++) {
			if(a[i] >= a[i - 1]) {
				if(leftMax < a[i]) {
					leftMax = a[i];
					leftMaxIdx = i;
				}
				
				if(leftMaxIdx != -1) {
					if(leftMaxIdx != i) {
						if(leftMax > a[i])
							L[i] = i - leftMaxIdx;
						else
							L[i] = i + 1;
					} else
						L[i] = i + 1;
				}
			} else 
				L[i] = 1;
			
			//System.out.print(L[i] + " ");
		}
		
		//System.out.println();
		//System.out.print(L[N - 1] + " ");
		
		for(int i = N - 2; i >= 0; i--) {
			if(a[i] > a[i + 1]) {
				if(rightMaxIdx != -1) {
					if(rightMaxIdx != i) {
						if(max > a[i]) {
							L[i] += rightMaxIdx - i;
						} else {
							L[i] += N - i - 1;
							
						}
						
						//System.out.print(L[i] + " ");
						
						continue;
					}
				}
				
				if(a[i] > max) {
					max = a[i];
					rightMaxIdx = i;
				}
				
				if(i == N - 2)
					L[i] += 1;
				else
					L[i] += L[i + 1];
			} else if(a[i] < a[i + 1]) {
				if(a[i + 1] > max) {
					max = a[i + 1];
					rightMaxIdx = i + 1;
				}
				
			} else {
				L[i] += 1;
			} 
			
			//System.out.print(L[i] + " ");
		}
		
		for(int i = 0; i < N; i++) {
			if(a[i] >= K)
				count += L[i];
		}
		
		System.out.println(count);
	}
	
	static void count(int[] a, int N, int K) {
		int count = 0;

		for(int i = 0; i < N; i++) {
			int max = 0;
			
			for(int j = i; j < N; j++) {
				if(a[j] > max) {
					max = a[j];
				}
				
				if(max > K) {
					count ++;
				}
			}
		}

		System.out.println(count);
	}

	static void count(int[] a, int N, int K) {
		int count = 0;

		for (int l = 1; l <= N; l++) {
			for (int i = 0; i <= N - l; i++) {
				long subMax = 0;
				
				for (int j = i; j < i + l; j++) {
					if (a[j] > subMax)
						subMax = a[j];
					
					if(subMax > K) {
						count++;
						break;
					}
				}
			}
		}

		System.out.println(count);
	}*/
}
