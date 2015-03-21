package com.learning.algorithm.string;

public class XcelNumber {

	public static void main(String[] args) {
		printChar(17602);
	}

	static void printChar(int n) {
		if(n == 0) {
			return;
		}
		
		int d = (n - 1) / 26;
		int m = (n - 1) % 26;
		
		printChar(d);
		System.out.print((char) ((m % 26) + 97));
	}

}
