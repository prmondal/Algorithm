package com.learning.algorithm.tree;

public class PixelQuadTree {
	static Node[] T;
	static int[][] A;

	static void buildTree(int idx, int a1, int b1, int a2, int b2) {
		// out of range
		if (a1 > a2 || b1 > b2)
			return;

		// if the segment itself represents the leaf node or grid element
		if (a1 == a2 && b1 == b2) {
			if(A[a1][b1] == 1) {
				T[idx].blackPixel++;
			} else
				T[idx].whitePixel++;
			
			return;
		}

		int idx1 = 4 * idx + 1, idx2 = 4 * idx + 2, idx3 = 4 * idx + 3, idx4 = 4 * idx + 4;
		
		buildTree(idx1, a1, b1, a1 + (a2 - a1) / 2, b1 + (b2 - b1) / 2);
		buildTree(idx2, a1 + (a2 - a1) / 2 + 1, b1, a2, b1 + (b2 - b1) / 2);
		buildTree(idx3, a1, b1 + (b2 - b1) / 2 + 1, a1 + (a2 - a1) / 2, b2);
		buildTree(idx4, a1 + (a2 - a1) / 2 + 1, b1 + (b2 - b1) / 2 + 1, a2, b2);
		
		T[idx].blackPixel = T[idx1].blackPixel + T[idx2].blackPixel + T[idx3].blackPixel + T[idx4].blackPixel;
		T[idx].whitePixel = T[idx1].whitePixel + T[idx2].whitePixel + T[idx3].whitePixel + T[idx4].whitePixel;
	}
	
	static int queryWhitePixel(int idx, int a1, int b1, int a2, int b2, int x1, int y1, int x2, int y2) {
		// out of range
		if (a1 > a2 || b1 > b2 || x1 > x2 || y1 > y2 || x1 > a2 || y1 > b2 || x2 < a1 || y2 < b1)
			return 0;
		
		//segment is contained in query interval
		if(x1 <= a1 && x2 >= a2 && y1 <= b1 && y2 >= b2) {
			return T[idx].whitePixel;
		}
		
		int idx1 = 4 * idx + 1, idx2 = 4 * idx + 2, idx3 = 4 * idx + 3, idx4 = 4 * idx + 4;
		
		return queryWhitePixel(idx1, a1, b1, a1 + (a2 - a1) / 2, b1 + (b2 - b1) / 2, x1, y1, x2, y2)
		+ queryWhitePixel(idx2, a1 + (a2 - a1) / 2 + 1, b1, a2, b1 + (b2 - b1) / 2, x1, y1, x2, y2)
		+ queryWhitePixel(idx3, a1, b1 + (b2 - b1) / 2 + 1, a1 + (a2 - a1) / 2, b2, x1, y1, x2, y2)
		+ queryWhitePixel(idx4, a1 + (a2 - a1) / 2 + 1, b1 + (b2 - b1) / 2 + 1, a2, b2, x1, y1, x2, y2);
	}
	
	static class Node {
		int whitePixel; 
		int blackPixel;
		
		Node() {
			this.blackPixel = 0;
			this.whitePixel = 0;
		}
	}
	
	public static void main(String[] args) {
		int M = 5; 
		int N = 10;
		
		//1 - black pixel, 0 - white pixel
		A = new int[][] {
				{1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
				{0, 0, 1, 1, 0, 1, 1, 0, 0, 1},
				{1, 0, 1, 0, 1, 1, 1, 0, 0, 1},
				{0, 1, 1, 1, 0, 0, 1, 0, 1, 0},
				{1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
				{1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
		};
		
		//TODO
		int size = 100 * M * N;
		
		T = new Node[size];
		
		for(int i = 0; i < size; i++)
			T[i] = new Node();
		
		//build tree
		buildTree(0, 0, 0, M - 1, N - 1);
		
		//query white pixels
		System.out.println("Number of white pixels: " + queryWhitePixel(0, 0, 0, M - 1, N - 1, 1, 1, 2, 3));
	}
}
