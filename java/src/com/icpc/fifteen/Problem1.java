package com.icpc.fifteen;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), n = sc.nextInt();
		
		double[] stocks = new double[n];
		
		for(int k = 0; k < n; k++) {
			stocks[k] = p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2);
		}
		
		double max = stocks[0], min = Double.MAX_VALUE, maxDecline = 0;
		
		for(int k = 1; k < n; k++) {
			if(stocks[k] > max) {
				max = stocks[k];
			}
			
			if(stocks[k] < min) {
				min = stocks[k];
				
				if(maxDecline < max - min) {
					maxDecline = max - min;
				}
			}
		}
		
		System.out.println(maxDecline);
	}
}
