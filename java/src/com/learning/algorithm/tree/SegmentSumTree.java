package com.learning.algorithm.tree;

public class SegmentSumTree {

	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 56, 26, 72, 28, 9, 12, 7 };
		int L = array.length;

		System.out.println(" === Input ===");
		for (int i = 0; i < L; i++)
			System.out.print(array[i] + " ");

		// total number of nodes in segment tree is (2*n - 1)
		// height of segment tree is h = ceil(log(n))
		// size of segment tree 2*2^h - 1

		int h = (int) Math.ceil(Math.log(L) / Math.log(2));

		long[] M = new long[2 * (int) Math.pow(2, h) - 1];

		// build segment tree
		buildTree(0, M, array, 0, L - 1);

		int i = 8;
		int j = 10;

		System.out.println("\n\n === Sum in range " + i + " and " + j + " ===");
		// find sum in the range
		long sum = getSum(i - 1, j - 1, 0, M, array, 0, L - 1);

		if (sum != Long.MAX_VALUE)
			System.out.println(sum);
		else
			System.out.println("Out of range error!");

		int idx = 7;
		int v = 5;
		System.out.println("\nUpdating value at index " + idx + " with " + v
				+ "\n");
		// update value
		update(idx, v, 0, M, array, 0, L - 1);

		System.out.println(" === Updated sum in previous range ===");
		// find sum in the range
		sum = getSum(i - 1, j - 1, 0, M, array, 0, L - 1);

		if (sum != Long.MAX_VALUE)
			System.out.println(sum);
		else
			System.out.println("Out of range error!");
	}

	// index is the node index
	private static void buildTree(int index, long[] M, int[] A, int l, int r) {
		// if the node is a leaf node or contains single element of A return
		// value
		if (l == r) {
			M[index] = A[l];
			return;
		}

		int mid = l + (r - l) / 2;
		int leftChildIdx = 2 * index + 1;
		int rightChildIdx = 2 * index + 2;

		buildTree(leftChildIdx, M, A, l, mid);
		buildTree(rightChildIdx, M, A, mid + 1, r);

		M[index] = M[leftChildIdx] + M[rightChildIdx];
	}

	private static void update(int i, int v, int index, long[] M, int[] A,
			int l, int r) {
		if (i < l || i > r)
			return;

		if (l == r) {
			A[i] = v;
			M[index] = v;
			return;
		}

		int mid = l + (r - l) / 2;
		int leftChildIdx = 2 * index + 1;
		int rightChildIdx = 2 * index + 2;

		if (i <= mid)
			update(i, v, leftChildIdx, M, A, l, mid);
		else
			update(i, v, rightChildIdx, M, A, mid + 1, r);

		M[index] = M[leftChildIdx] + M[rightChildIdx];
	}

	private static long getSum(int i, int j, int index, long[] M, int[] A,
			int l, int r) {
		// outside range of current node
		if (i > r || j < l || i > j) {
			return Long.MAX_VALUE;
		}

		// if current segment is contained in range
		if (i <= l && j >= r)
			return M[index];

		// search in left and right half
		int mid = l + (r - l) / 2;

		long leftSum = getSum(i, j, 2 * index + 1, M, A, l, mid);
		long rightSum = getSum(i, j, 2 * index + 2, M, A, mid + 1, r);

		if (leftSum == Long.MAX_VALUE)
			return rightSum;
		else if (rightSum == Long.MAX_VALUE)
			return leftSum;

		return leftSum + rightSum;
	}
}
