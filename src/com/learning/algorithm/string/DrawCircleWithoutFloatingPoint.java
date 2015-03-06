package com.learning.algorithm.string;

import java.util.Scanner;

public class DrawCircleWithoutFloatingPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		draw(sc.nextInt());

	}

	private static void draw(int r) {
		if (r == 0 || r < 0)
			return;

		for (int i = -r; i <= r + 1; i++) {
			for (int j = -r; j <= r + 1; j++) {
				if (i * i + j * j <= r * r) {
					System.out.print(".");
				} else {
					System.out.print(" ");
				}
			}

			System.out.println();
		}
	}

}
