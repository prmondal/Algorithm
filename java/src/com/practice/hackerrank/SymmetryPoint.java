package com.practice.hackerrank;

import java.util.Scanner;

public class SymmetryPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		while(T > 0) {
			int[] points = new int[4];
			
			for(int i = 0; i < 4; i++) {
				points[i] = sc.nextInt();
			}
			
			printSymmetryPoint(points[0], points[1], points[2], points[3]);
			
			T--;
		}
	}

	private static void printSymmetryPoint(int x1, int y1, int x2, int y2) {
		int symX = -1;
		int symY = -1;
		
		/*if(x2 > x1) {
			symX = x2 + (x2 - x1);
		} else {
			symX = x2 - (x1 - x2);
		}
		
		if(y2 > y1) {
			symY = y2 + (y2 - y1);
		} else {
			symY = y2 - (y1 - y2);
		}*/
		
		symX = 2 * x2 - x1;
		symY = 2 * y2 - y1;
		
		System.out.println(symX + " " + symY);
	}

}
