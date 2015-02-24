package com.learning.algorithm.array;

public class SumSubset {

	public static void main(String[] args) {
		int sum = 10;
		
		int[] array = new int[]{1,2,3,4,5,6,7,8,9};
		
		int[] solution = new int[array.length];
		
		printSubset(array, 0, array.length - 1, 0, sum, solution);
	}

	private static void printSubset(int[] array, int startIdx, int endIdx, int currentSum, int target, int[] solution) {
		//base case
		if(currentSum == target) {
			printSet(solution, array);
			
			return;
		}
		
		if(currentSum > target) {
			//System.out.println("currentSum > target");
			//solution[startIdx] = 0;
			return;
		}
		
		for(int i = startIdx; i <= endIdx; i++) {
			currentSum += array[i];
			
			//include the element
			solution[i] = 1;
			
			//System.out.println("current idx: " + i + " ,StartIdx: " + startIdx + " , value: " + array[i] + " ,currentSum: " + currentSum);
			
			printSubset(array, i + 1, endIdx, currentSum, target, solution);
			
			solution[i] = 0; //reset
			
			currentSum -= array[i];
			
			//System.out.println("Not valid idx: " + i + " ,currentSum: " + currentSum );
			
			//startIdx++;
		}
	}

	private static void printSet(int[] solution, int[] array) {
		int l = array.length;
		
		for(int i = 0; i < l; i++) {
			System.out.print((solution[i] == 1) ? array[i] + ", " : "");
		}
		
		System.out.println();
	}

}
