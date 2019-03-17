package com.learning.algorithm.tree;

public class QuadTree {
	static int[] T;
	static int[][] A;

	public static void main(String[] args) {
		int M = 5;
		int N = 5;
		
		//TODO
		T = new int[4 * M * N];

		A = new int[][] { 
				{ 1, 2, 3, 4, 4}, 
				{ 5, 6, 7, 8, 5}, 
				{ 9, 10, 11, 12, 6},
				{13, 14, 15, 16, 8},
				{13, 14, 15, 16, 8}
			};
		
		buildTree(0, 0, 0, M - 1, N - 1);
		
		System.out.println(query(0, 0, 0, M - 1, N - 1, 1, 1, 2, 1));
	}

	static void buildTree(int idx, int a1, int b1, int a2, int b2) {
		// out of range
		if (a1 > a2 || b1 > b2)
			return;

		// if the segment itself represents the leaf node or grid element
		if (a1 == a2 && b1 == b2) {
			T[idx] = A[a1][b1];
			return;
		}

		int idx1 = 4 * idx + 1, idx2 = 4 * idx + 2, idx3 = 4 * idx + 3, idx4 = 4 * idx + 4;
		
		buildTree(idx1, a1, b1, a1 + (a2 - a1) / 2, b1 + (b2 - b1) / 2);
		buildTree(idx2, a1 + (a2 - a1) / 2 + 1, b1, a2, b1 + (b2 - b1) / 2);
		buildTree(idx3, a1, b1 + (b2 - b1) / 2 + 1, a1 + (a2 - a1) / 2, b2);
		buildTree(idx4, a1 + (a2 - a1) / 2 + 1, b1 + (b2 - b1) / 2 + 1, a2, b2);
		
		T[idx] = T[idx1] + T[idx2] + T[idx3] + T[idx4];
	}
	
	static int query(int idx, int a1, int b1, int a2, int b2, int x1, int y1, int x2, int y2) {
		// out of range
		if (a1 > a2 || b1 > b2 || x1 > x2 || y1 > y2 || x1 > a2 || y1 > b2 || x2 < a1 || y2 < b1)
			return 0;
		
		//segment is contained in query interval
		if(x1 <= a1 && x2 >= a2 && y1 <= b1 && y2 >= b2) {
			return T[idx];
		}
		
		int idx1 = 4 * idx + 1, idx2 = 4 * idx + 2, idx3 = 4 * idx + 3, idx4 = 4 * idx + 4;
		
		return query(idx1, a1, b1, a1 + (a2 - a1) / 2, b1 + (b2 - b1) / 2, x1, y1, x2, y2)
		+ query(idx2, a1 + (a2 - a1) / 2 + 1, b1, a2, b1 + (b2 - b1) / 2, x1, y1, x2, y2)
		+ query(idx3, a1, b1 + (b2 - b1) / 2 + 1, a1 + (a2 - a1) / 2, b2, x1, y1, x2, y2)
		+ query(idx4, a1 + (a2 - a1) / 2 + 1, b1 + (b2 - b1) / 2 + 1, a2, b2, x1, y1, x2, y2);
	}
}
