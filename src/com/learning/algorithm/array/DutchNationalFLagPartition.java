package com.learning.algorithm.array;

public class DutchNationalFLagPartition {

	public static void main(String[] args) {
		int[] a = new int[] { 0,0,0,1,1,1,2,2,2 };
		threeWayPartition(a);
		printArray(a);

		a = new int[] { 0, 1, 0, 1, 0, 1, 0, 0, 0 };
		twoWayPartition(a);
		printArray(a);
		
		//a = new int[] { 1,0,2,0,3,2,1,0 }; //failed
		//a = new int[] { 3,3,3,3,3,3,2,2,2,2,2,1,1,1,1,1,0,0,0 };
		a = new int[] { 0,1,2,3 };
		//fourWayPartition(a);
		//printArray(a);
	}

	static void printArray(int[] a) {
		System.out.println();

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	static void twoWayPartition(int[] a) {
		int l = a.length, low = 0, high = l - 1;

		while (low <= high) {
			if (a[low] == 1) {
				int e = a[high];
				a[high] = a[low];
				a[low] = e;

				high--;
			} else {
				low++;
			}
		}
	}

	static void threeWayPartition(int[] a) {
		int l = a.length, low = 0, mid = 0, high = l - 1;

		while (mid <= high) {
			if (a[mid] == 0) {
				int e = a[low];
				a[low] = a[mid];
				a[mid] = e;

				low++;
				mid++;
			} else if (a[mid] == 1) {
				mid++;
			} else {
				int e = a[mid];
				a[mid] = a[high];
				a[high] = e;

				high--;
			}
		}
	}

	//TODO
	static void fourWayPartition(int[] a) {
		int l = a.length, low = 0, mid1 = 0, mid2 = l - 1, high = l - 1;

		while (mid1 <= mid2) {
			if (a[mid1] == 0) {
				int e = a[low];
				a[low] = a[mid1];
				a[mid1] = e;

				low++;
				mid1++;
			} else if (a[mid1] == 1) {
				mid1++;
			} else if (a[mid1] == 3) {
				int e = a[mid2];
				a[mid2] = a[mid1];
				a[mid1] = e;
				
				mid2--;
			} else if (a[mid1] == 2) {
				int e = a[mid1];
				a[mid1] = a[high];
				a[high] = e;
				
				high--;
			}
		}
		
		System.out.println("\n" + mid1 + " " + mid2);
		
		high = l - 1;
		mid2++;

		while (mid2 <= high) {
			if (a[mid2] == 3) {
				int e = a[high];
				a[high] = a[mid2];
				a[mid2] = e;

				mid2++;
				high--;
			} else
				continue;
		}
	}
}
