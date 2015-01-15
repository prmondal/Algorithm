package com.practice.hackerrank;

import java.util.Scanner;

public class RunningTimeQuicksort {
	static int countSwap = 0;
	static int countSwapShift = 0;
	
	static void quickSort(int[] ar) {
		quickSort(0, ar.length - 1, ar);
	}

	static void quickSort(int low, int high, int[] ar) {
		int pIndex = partition(low, high, ar);

		if (low > pIndex) {
			return;
		}

		if (high < pIndex)
			return;

		if (low < pIndex) {
			quickSort(low, pIndex - 1, ar);
		}

		if (high > pIndex) {
			quickSort(pIndex + 1, high, ar);
		}
	}

	static int partition(int low, int high, int[] ar) {
		int pivot = ar[high];
		int temp;
		
		int j = low;
		
		for(int i = low; i < high; i++) {
			if(ar[i] <= pivot) {
				swap(ar, j, i);
				
				countSwap++;
				
				j++;
			}
		}
		
		
		swap(ar, j, high);
		
		if(low != high) //does not count for single element
			countSwap++;
		
		return j;
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
	
	public static void insertIntoSorted(int[] ar, int elemInd) {
        int j = elemInd;
        int v = ar[j];
        
        while(j > 0 && ar[j - 1] > v) {
            ar[j] = ar[j - 1];
            
            countSwapShift++;
            j = j - 1;
        }
        
        ar[j] = v;
    }
    
    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		
		int[] temp = new int[n];
		temp = ar.clone();
		
		quickSort(temp);
		
		temp = ar.clone();
		
		for(int i = 1; i < temp.length; i++) {
			insertIntoSorted(ar, i);
		}
		
		System.out.println(countSwapShift - countSwap);
	}

}
