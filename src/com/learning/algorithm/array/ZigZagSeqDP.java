package com.learning.algorithm.array;

public class ZigZagSeqDP {

	public static void main(String[] args) {
		int[] array = //{1, 7, 4, 9, 2, 5};
			//{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
				/*{374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244};*/
				//{1, 2, 3, 4, 5, 6, 7, 8, 9};
				//{1, 7, 4, 9, 2, 5};
				 {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
				 
		
		int maxLength = zigZag(array, array.length);
		
		System.out.println("Max length is " + maxLength);
	}

	private static int zigZag(int[] A, int L) {
		//array contains successive subtracted elements
		//A[j] - A[i], j > i
		int[] sign = new int[L];
		
		sign[0] = A[0];
		
		//populate sign array
		for(int i = 1; i < L; i++) {
			sign[i] = A[i] - A[i - 1];
		}
		
		int[] T = new int[L + 1];
		T[1] = 1;
		T[2] = 2;
		
		int max = 0;
		
		for(int i = 3; i <= L; i++) {
			max = 0;
			
			for(int j = 0; j < i - 1; j++) {
				if(sign[j] == 0)
					continue;
				
				if((sign[j] > 0 && A[i - 1] - A[j] < 0) || (sign[j] < 0 && A[i - 1] - A[j] > 0)) {
					if(max < T[j + 1]) {
						max = T[j + 1];
					}
				}
			}
			
			//include the current element
			T[i] = max + 1;
			
			//System.out.println("T[i] " + T[i] + ", i " + i);
		}
		
		//get max of all
		max = 0;
		
		for(int i = 0; i <= L; i++) {
			if(max < T[i]) {
				max = T[i];
			}
		}
		
		return max;
	}

}
