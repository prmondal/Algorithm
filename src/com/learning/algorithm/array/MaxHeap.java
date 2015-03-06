package com.learning.algorithm.array;

public class MaxHeap {

	public static void main(String[] args) {
		int[] array = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };

		// build heap
		buildHeap(array);

		// print array
		System.out.print("Heap Elements:");
		printArray(array);

		// heapSort
		System.out.print("\n\nSorted heap:");
		heapSort(array);
	}

	private static void heapSort(int[] array) {
		int l = array.length;

		// run the loop for (l - 1) times
		for (int i = l - 1; i >= 1; i--) {
			// swap first elem with last elem
			swap(array, 0, i);

			// print
			// call max heap to first elem
			maxHeap(array, 0, i);
		}

		// print sorted order
		printArray(array);
	}

	private static void printArray(int[] array) {
		System.out.println();

		int l = array.length;

		for (int i = 0; i < l; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static void buildHeap(int[] array) {
		// heap size
		int l = array.length;

		// all leaf nodes in the heap are lies between Math.floor(l / 2) and n -
		// 1 indices
		// loop through remaining nodes and build the heap
		int idx = (int) Math.floor(l / 2) - 1;

		for (int i = idx; i >= 0; i--) {
			maxHeap(array, i, l);
		}
	}

	private static void maxHeap(int[] array, int i, int heapLength) {
		// store largest index
		int largest;

		// left child
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		// check with left child
		if (left < heapLength && array[left] > array[i]) {
			largest = left;
		} else {
			largest = i;
		}

		// check with right child
		if (right < heapLength && array[right] > array[largest]) {
			largest = right;
		}

		// swap largest with current i if the largest is not i
		if (largest != i) {
			// swap largest with i
			swap(array, i, largest);

			// recur with swapped node
			maxHeap(array, largest, heapLength);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
