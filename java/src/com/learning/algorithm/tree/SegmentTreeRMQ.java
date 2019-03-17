package com.learning.algorithm.tree;

public class SegmentTreeRMQ {

	public static void main(String[] args) {
		int[] array = {-2, -1, 3, -4};//{ 2, 4, 3, 56, 26, 72, 28, 9, 12, 7 };

		// total number of nodes in segment tree is (2*n - 1) 
		// height of segment tree is h = ceil(log(n))
		// size of segment tree 2*2^h - 1
		
		int h = (int) Math.ceil(Math.log(array.length) / Math.log(2));

		int[] M = new int[2 * (int) Math.pow(2, h) - 1];
		
		//build segment tree
		buildTree(0, M, array, 0, array.length - 1);

		//query
		int idx = RMQ(0, 2, 0, M, array, 0, array.length - 1);

		if (idx != -1)
			System.out.println(array[idx]);
	}

	// index is the node index
	private static int buildTree(int index, int[] M, int[] A, int l, int r) {
		// if the node is a leaf node or contains single element of A return the
		// index of minimum element
		if (l == r) {
			M[index] = l;
			return M[index];
		}

		int mid = l + (r - l) / 2;

		int leftIdx = buildTree(2 * index + 1, M, A, l, mid);
		int rightIdx = buildTree(2 * index + 2, M, A, mid + 1, r);

		if (A[leftIdx] < A[rightIdx])
			M[index] = leftIdx;
		else
			M[index] = rightIdx;

		return M[index];
	}

	private static int RMQ(int i, int j, int index, int[] M, int[] A, int l,
			int r) {
		// outside range of current node
		if (i > r || j < l || i > j)
			return Integer.MAX_VALUE;

		// if current segment is contained in range
		if (i <= l && j >= r)
			return M[index];

		// search in left and right half
		int mid = l + (r - l) / 2;

		int minL = RMQ(i, j, 2 * index + 1, M, A, l, mid);
		int minR = RMQ(i, j, 2 * index + 2, M, A, mid + 1, r);

		if (minL == Integer.MAX_VALUE)
			return minR;
		else if (minR == Integer.MAX_VALUE)
			return minL;

		if (A[minL] < A[minR])
			return minL;
		else
			return minR;
	}
}
