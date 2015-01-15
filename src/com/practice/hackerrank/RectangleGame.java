package com.practice.hackerrank;

import java.util.Scanner;

public class RectangleGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		int[][] stepArray = new int[N][2];
		
		int i = 0;
		int minRow = Integer.MAX_VALUE;
		int minCol = Integer.MAX_VALUE;
		
		while(N > 0) {
			stepArray[i][0] = sc.nextInt();
			stepArray[i][1] = sc.nextInt();
			
			if(stepArray[i][0] < minRow) {
				minRow = stepArray[i][0];
			}
			
			if(stepArray[i][1] < minCol) {
				minCol = stepArray[i][1];
			}
			
			i++;
			N--;
		}
		
		long result = (long)minRow * minCol;
		
		System.out.println(result);
	}

	/*private static void find(int[][] grid, int[][] stepArray) {
		int maxValue = Integer.MIN_VALUE;
		int count = 0;
		
		int L = stepArray.length;
		
		for(int e = 0; e < L; e++) {
			int r = stepArray[e][0];
			int c = stepArray[e][1];
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					grid[i][j]++;
					
					if(grid[i][j] > maxValue) {
						//new max found reset count
						count = 0;
						
						maxValue = grid[i][j];
						
						count++;
					} else if(maxValue == grid[i][j]){
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}*/

}
