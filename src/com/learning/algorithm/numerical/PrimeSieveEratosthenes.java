package com.learning.algorithm.numerical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeSieveEratosthenes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ESeive(sc.nextInt());
	}

	/*private static void printAllPrimes(int n) {
		// added extra element for simplicity
		int L = n + 1; 
		int[] flag = new int[L];

		for (int i = 2; i * i <= (L - 1); i++) {
			if (flag[i] == -1)
				continue;

			int j = i * i;

			while (j <= L - 1) {
				if (flag[i] != -1) {
					flag[j] = -1;
				}

				j += i;
			}
		}

		for (int i = 2; i < L; i++) {
			if (flag[i] == 0) {
				System.out.print(i + " ");
			}
		}
	}*/
	
	static void ESeive(int n) {
		boolean[] isPrime = new boolean[n];
		List<Integer> list = new ArrayList<Integer>();
		
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for(int i = 2; i < n; i++) {
			if(isPrime[i]) {
				for(int j = i + i; j < n; j += i) {
					isPrime[j] = false;
				}
				
				list.add(i);
			}
		}
		
		for(Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
