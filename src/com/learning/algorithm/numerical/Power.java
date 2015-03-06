package com.learning.algorithm.numerical;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//System.out.println(printPower(sc.nextInt(), sc.nextInt()));
		System.out.println(power(sc.nextInt(), sc.nextInt()));
	}
	
	//iterative
	private static long printPower(int x, int n) {
		if (n == 0)
			return 1;
		
		if(x == 0)
			return 0;

		long result = 1;

		while (n > 0) {
			if (n % 2 == 0) {
				n = n >> 1;

				x = x * x;
			} else {
				n--;

				result *= x;
			}
		}

		return result;
	}

	//recursive
	private static long power(int x, int n) {
		if (n == 0)
			return 1;
		
		if(x == 0)
			return 0;
		
		long result = power(x, n / 2);
		
		//even
		if(n % 2 == 0) {
			return result * result;
		} else {
			return x * result * result;
		}
	}
}
