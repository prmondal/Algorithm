package com.learning.algorithm.array;

public class Partition {

	public static void main(String[] args) {
		int[] a1 = {0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0};

		sepZeroOne(a1);
		printArray(a1);
		
		int[] a2 = {100, 45, 23, 34, 5, 78, 9, 90, 65, 23, 10};
		
		partition(a2);
		printArray(a2);
	}

	private static void partition(int[] a) {
		int L = a.length;
		int pivot = a[L - 1];
		
		int k = 0;
		
		for(int i = 0; i < L; i++) {
			if(a[i] < pivot) {
				int e = a[k];
				a[k] = a[i];
				a[i] = e;
				
				k++;
			} else
				continue;
		}
		
		//place pivot correctly
		int e = a[k];
		a[k] = pivot;
		a[L - 1] = e;
	}

	//separate 0s and 1s
	private static void sepZeroOne(int[] array) {
		int k = 0;
		int L = array.length;
		
		for(int i = 0; i < L; i++) {
			if(array[i] == 0) {
				int e = array[k];
				array[k] = array[i];
				array[i] = e;
				
				k++;
			} else 
				continue;
		}
	}
	
	private static void printArray(int[] array) {
		System.out.println();
		
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
}
