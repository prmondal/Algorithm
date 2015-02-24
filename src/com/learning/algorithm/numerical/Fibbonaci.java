package com.learning.algorithm.numerical;

import java.util.Arrays;
import java.util.Scanner;

public class Fibbonaci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//printNthFibonacci(n);
		
		//memozation
		int[] table = new int[n + 1];
		Arrays.fill(table, -1);
		table[0] = 0;
		table[1] = 1;
		
		System.out.println(printNthFibonacciMemozation(n, table));
	}

	private static void printNthFibonacci(int n) {
		if(n == 0 || n == 1) {
			System.out.println(n);
			return;
		}
		
		int[] table = new int[n + 1];
		
		table[0] = 0;
		table[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			table[i] = table[i - 1] + table[i - 2];	
		}
		
		System.out.println(table[n]);
	}
	
	private static int printNthFibonacciMemozation(int n, int[] table) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		if(table[n] != -1) 
			return table[n];
		else {
			table[n] = printNthFibonacciMemozation(n - 1, table) + printNthFibonacciMemozation(n - 2, table);
		}
		
		return table[n];
	}
}
