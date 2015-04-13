package com.practice.hackerrank;

import java.util.Scanner;

public class FindMedianFinal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		
		int left = 0;
		int right = ar.length - 1;
		
		int pInd = partition(left, right, ar);
		
		int len = pInd - left + 1;
		
		int mid = ar.length >> 1;
		
		if(pInd == mid) {
			System.out.println(ar[pInd]);
			return;
		}
		
		/*while(true) {
			if(pInd > mid) {
				right = pInd - 1;
				pInd = partition(left, right, ar);
				System.out.println("right: " + right + " ,pIndx : " + pInd);
			} else if(pInd < mid) {
				left = pInd + 1;
				pInd = partition(left, right, ar);
				System.out.println("left: " + right + " ,pIndx : " + pInd);
			} else {
				System.out.println(ar[pInd]);
				break;
			}
		}*/
		
		/*while(true) {
			if(mid > len) {
				left = pInd + 1;
				pInd = partition(left, right, ar);
				
				len = pInd - left + 1;
				
				mid = mid - len;
			} else if(mid < len) {
				right = pInd - 1;
				pInd = partition(left, right, ar);
				
				len = pInd - left + 1;
			} else {
				System.out.println(ar[mid]);
				break;
			}
		}*/
		
	}

	static int partition(int low, int high, int[] a) {
		if(low == high) {
			return low;
		}
		
		int pivotIdx;
		
		if((high + 1 - low) % 2 == 0) {
			pivotIdx = (high + 1 - low) / 2;
		} else {
			pivotIdx = low + (high - low) >> 1;
		}
		
		int pivot = a[pivotIdx];
		//System.out.println("pivotindex: " + pivotIdx);
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(pivot > a[i]) {
				i++;
			}
			
			while(pivot < a[j]) {
				j--;
			}
			
			if(i <= j) {
				if(pivotIdx == i) {
					pivotIdx = j;
				} else if(pivotIdx == j) {
					pivotIdx = i;
				}
				
				swap(a, i, j);
				
				i++;
				j--;
			}
		}
		
		return pivotIdx;
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}
	
	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}