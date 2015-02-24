package com.learning.algorithm.array;

import java.util.HashMap;
import java.util.Scanner;

public class FindSubArraySumToZero {

	public static void main(String[] args) {
		/*int[] array;
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}*/
		int[] array = {4, 2, 3, -2, -3, 4, 1, 2, -2, -1, 8, 3};
		printSubArray(array); //{4, 2, 3, -2, -3, 4, 1, 2, -2, -1, 8, 3}
	}

	private static void printSubArray(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int l = array.length;
		int currentSum = 0;
		
		for(int i = 0; i < l; i++) {
			currentSum += array[i];
			
			if(map.containsKey(currentSum)) {
				System.out.println("Start Index: " + (map.get(currentSum) + 1) + " , End Index: " + i);
			} else {
				//System.out.println("Add");
				map.put(currentSum, i);
			}
		}
	}

}
