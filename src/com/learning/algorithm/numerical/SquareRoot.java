package com.learning.algorithm.numerical;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		float number = sc.nextFloat();

		// print the square root
		printSquareRoot(number, 1.0f, number);
	}
	
	//babylonian method
	private static void printSquareRoot(int number) {
		float x = number;
		float y = 1;

		float e = 0.000000001f;

		while (x - y > e) {
			x = (x + y) / 2.0f;
			y = number / x;
		}

		System.out.println(x);
	}
	
	static void printSquareRoot(float n, float l, float h) {
		while((int) h > (int) l) {
			float mid = l + (h - l) / 2;
			//System.out.println(mid);
			if(mid * mid > n) {
				h = mid;
			} else {
				l = mid;
			}
			
			//System.out.println("l: " + l + ", h: " + h);
		}
		
		System.out.println(l);
	}

}
