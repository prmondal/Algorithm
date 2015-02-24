package com.learning.algorithm.backtrack;

public class SudukuSolver {

	public static void main(String[] args) {
		int[][] board = {
					{3, 0, 6, 5, 0, 8, 4, 0, 0},
	                {5, 2, 0, 0, 0, 0, 0, 0, 0},
	                {0, 8, 7, 0, 0, 0, 0, 3, 1},
	                {0, 0, 3, 0, 1, 0, 0, 8, 0},
	                {9, 0, 0, 8, 6, 3, 0, 0, 5},
	                {0, 5, 0, 0, 9, 0, 6, 0, 0},
	                {1, 3, 0, 0, 0, 0, 2, 5, 0},
	                {0, 0, 0, 0, 0, 0, 0, 7, 4},
	                {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
		
		/*3 1 6 5 7 8 4 9 2
		  5 2 9 1 3 4 7 6 8
		  4 8 7 6 2 9 5 3 1
		  2 6 3 4 1 5 9 8 7
		  9 7 4 8 6 3 1 2 5
		  8 5 1 7 9 2 6 4 3
		  1 3 8 9 4 7 2 5 6
		  6 9 2 3 5 1 8 7 4
		  7 4 5 2 8 6 3 1 9
		  */
		SudukuSolver ss = new SudukuSolver();
		
		if(ss.solveSuduku(board)) {
			ss.printBoard(board);
		} else {
			System.out.println("No solution!");
		}
	}
	
	void printBox(int r, int c) {
		System.out.println("X: " + 3 * (int) (c / 3) + ", Y: " + 3 * (int) (r / 3));
	}
	
	boolean isSafe(int[][] board, int r, int c, int num) {
		int M = board.length;
		int N = board[0].length;
		
		if(r >= M || c >= N)
			return false;
		
		int boxX = 3 * (int) (c / 3);
		int boxY = 3 * (int) (r / 3);
		
		return isSafeRow(board, r, num) && isSafeCol(board, c, num) && isSafeBox(board, boxX, boxY, num);
	}
	
	boolean isSafeBox(int[][] board, int boxX, int boxY, int num) {
		//System.out.println("BoxX: " + boxX + ", boxY: " + boxY);
		for(int i = boxY; i <= boxY + 2; i++) {
			for(int j = boxX; j <= boxX + 2; j++) {
				if(board[i][j] == num) {
					//System.out.println(board[i][j] + " isSafeBox false");
					return false;
				}
			}
		}
		
		return true;
	}

	boolean isSafeCol(int[][] board, int c, int num) {
		int M = board.length;
		
		for(int i = 0; i < M; i++) {
			if(board[i][c] == num) {
				//System.out.println("isSafeCol false");
				
				return false;
			}
		}
		
		return true;
	}

	boolean isSafeRow(int[][] board, int r, int num) {
		int N = board[0].length;
		
		for(int j = 0; j < N; j++) {
			if(board[r][j] == num) {
				//System.out.println("isSafeRow false");
				
				return false;
			}
		}
		
		return true;
	}

	boolean solveSuduku(int[][] board) {
		//printBoard(board);
		
		//contain empty row and column index
		int[] rc = new int[2];
		
		//if the board is filled up return true
		if(isFull(board, rc)) {
			return true;
		}
		
		for(int i = 1; i <= 9; i++) {
			int row = rc[0];
			int col = rc[1];
			
			//System.out.println("row : " + rc[0] + ", col : " + rc[1]);
			
			if(isSafe(board, row, col, i)) {
				
				board[row][col] = i;
				
				//System.out.println("Safe: " + i);
				
				if(solveSuduku(board)) {
					return true;
				}
				
				//undo
				board[row][col] = 0;
			}
			
			//System.out.println("Not safe: " + i);
		}
		
		//backtrack
		return false;
	}

	boolean isFull(int[][] board, int[] rc) {
		int M = board.length;
		int N = board[0].length;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 0) {
					rc[0] = i;
					rc[1] = j;
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	void printBoard(int[][] board) {
		int M = board.length;
		int N = board[0].length;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
