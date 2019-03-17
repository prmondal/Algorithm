package com.practice.hackerrank;

import java.util.Scanner;

public class RestaurantCutBar {
	static int GCD(int a, int b) {
		if (a == b)
			return a;
		else if (a > b)
			return GCD(a - b, b);
		else
			return GCD(a, b - a);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			t--;

			int b = sc.nextInt();
			int l = sc.nextInt();

			int gcd = GCD(b, l);

			System.out.println((b / gcd) * (l / gcd));
		}

	}

}
