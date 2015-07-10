package com.learning.algorithm.array;

public class Partition {

	public static void main(String[] args) {
		int[] a1 = {0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0};

		sepZeroOne(a1);
		printArray(a1);
		
		int[] a2 = {100, 45, 23, 10, 5, 78, 9, 90, 65, 23, 34};
		
		partition(a2);
		printArray(a2);
		
		//three way partition
		int[] b = {1,2,3,4,5,6,8,9,5,5,5};
		threeWayPartition(b);
		printArray(b);
	}
	
	static void threeWayPartition(int[] a) {
		int l = a.length - 1;
		int i = 0, k = 0;
		int p = l;
		
		while(i < p) {
			if(a[i] < a[l]) {
				int t = a[k];
				a[k] = a[i];
				a[i] = t;
				
				i++;
				k++;
			} else if(a[i] == a[l]) {
				--p;
				
				int t = a[i];
				a[i] = a[p];
				a[p] = t;
			} else 
				i++;
		}
		
		//bring equal numbers group in the middle
		int min = Math.min(p - k, l - p + 1);
		
		//swap last min number of elements with the elements starts from kth element
		for(int j = l; j >= l - min + 1; j--) {
			int t = a[k];
			a[k] = a[j];
			a[j] = t;
			
			k++;
		}
	}
	
	//using dutch national flag algo O(N)
	static void threeWayPartition(int[] a, int N) {
		int l = 0, mid = 0, h = N - 1;
		int pivot = a[h];

		while (mid < h) {
			if (a[mid] < pivot) {
				int c = a[l];
				a[l] = a[mid];
				a[mid] = c;

				l++;
				mid++;
			} else if (a[mid] > pivot) {
				int c = a[mid];
				a[mid] = a[h];
				a[h] = c;

				h--;
			} else
				mid++;
		}
		
		System.out.println("\n" + l + " " + mid);
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
			}
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
			}
		}
	}
	
	//sort Rs, Gs, Bs
	static void sort(char[] a, int N) {
		int l = 0, mid = 0, h = N - 1;

		while (mid < h) {
			if (a[mid] == 'R') {
				char c = a[l];
				a[l] = a[mid];
				a[mid] = c;

				l++;
				mid++;
			} else if (a[mid] == 'B') {
				char c = a[mid];
				a[mid] = a[h];
				a[h] = c;

				h--;
			} else
				mid++;
		}
	}
	
	private static void printArray(int[] array) {
		System.out.println();
		
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
}
