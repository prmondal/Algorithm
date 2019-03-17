package com.learning.algorithm.array;

import java.util.Scanner;
import java.util.Stack;

public class AllSubset {
	private static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int[] solution = new int[str.length()];
		
		//printAllSubset(str.toCharArray(), 0, str.length() - 1);
		printAllSubset(str.toCharArray(), 0, str.length() - 1, solution);

	}
	
	//use solution array
	private static void printAllSubset(char[] array, int start, int end, int[] solution) {
		if(start > end) return;
		
		for(int i = start; i <= end; i++) {
			solution[i] = 1;
			
			printAllSubset(array, i + 1, end, solution);
			
			printSet(solution, array);
			
			solution[i] = 0;
		}
	}
	
	private static void printSet(int[] solution, char[] array) {
		int l = array.length;
		
		for(int i = 0; i < l; i++) {
			System.out.print((solution[i] == 1) ? array[i] : "");
		}
		
		System.out.println();
	}
	
	//stack based
	private static void printAllSubset(char[] array, int start, int end) {
		for(int i = start; i <= end; i++) {
			stack.push(array[i]);
			
			printAllSubset(array, i + 1, end);
			
			printSubSet(stack);
			
			stack.pop();
		}
		
	}
	
	//using bit
	static void printAllSubset(char[] a) {
		int subsetSize = (int) Math.pow(2.0, a.length);
		
		for (int i = 1; i < subsetSize; i++) {
			int l = 0;

			while (l < a.length) {
				if ((i & (1 << l)) != 0) {
					System.out.print(a[l] + " ");
				}

				l++;
			}
			
			System.out.println();
		}
	}
	
	static void printSubsetBit(char[] a) {
		int L = a.length;
		int sub = (int) Math.pow(2, L);
				
		for(int s = 0; s < sub; s++) {
			int j = 0;
			
			while(j < L) {
				if((s & (1 << j)) != 0) {
					System.out.print(a[j]);
				}
				
				j++;
			}
			
			System.out.println();
		}
	}

	private static void printSubSet(Stack<Character> stack) {
		for(Character c: stack) {
			System.out.print(c);
		}
		
		System.out.println();
	}

}
