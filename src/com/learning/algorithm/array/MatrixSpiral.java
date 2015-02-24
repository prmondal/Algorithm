package com.learning.algorithm.array;

public class MatrixSpiral {

	public static void main(String[] args) {
		int[][] matrix = {
				/*{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}*/
				{1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		};
		
		printSpiral(matrix);
	}

	private static void printSpiral(int[][] matrix) {
		//row low index
		int rl = 0;
		
		//row high index
		int rh = matrix.length - 1;
		
		//column low index
		int cl = 0;
		
		//column high index
		int ch = matrix[0].length - 1;
		
		while(true) {
			//print row left right
			for(int i = cl; i <= ch; i++) {
				System.out.print(matrix[rl][i] + " ");
			}
			
			//row finished
			//increment row counter
			rl++;
			
			if(rl > rh)
				break;
			
			//print column top down
			for(int i = rl; i <= rh; i++) {
				System.out.print(matrix[i][ch] + " ");
			}
			
			//column finished
			//decrease ch
			ch--;
			
			if(cl > ch)
				break;
			
			//row right to left
			for(int i = ch; i >= cl; i--) {
				System.out.print(matrix[rh][i] + " ");
			}
			
			//decrease rh
			rh--;
			
			if(rh < rl)
				break;
			
			//row down top
			for(int i = rh; i >= rl; i--) {
				System.out.print(matrix[i][cl] + " ");
			}
			
			//increase cl
			cl++;
			
			if(cl > ch)
				break;
			
			//System.out.println("\ncl: " + cl + ", ch: " + ch + ", rl: " + rl + ", rh: " + rh);
		}
	}
}
