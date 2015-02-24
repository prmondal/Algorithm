package com.learning.algorithm.array;

import java.util.Iterator;
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

	private static void printAllSubset(char[] array, int start, int end, int[] solution) {
		if(start > end) {
			return;
		}
		
		for(int i = start; i <= end; i++) {
			solution[i] = 1;
			
			printAllSubset(array, i + 1, end, solution);
			
			printSet(solution, array);
			
			solution[i] = 0;
			
			//start++;
		}
	}
	
	private static void printSet(int[] solution, char[] array) {
		int l = array.length;
		
		for(int i = 0; i < l; i++) {
			System.out.print((solution[i] == 1) ? array[i] + ", " : "");
		}
		
		System.out.println();
	}
	
	private static void printAllSubset(char[] array, int start, int end) {
		for(int i = start; i <= end; i++) {
			stack.push(array[i]);
			
			printAllSubset(array, i + 1, end);
			
			printSubSet(stack);
			
			stack.pop();
		}
		
	}

	private static void printSubSet(Stack<Character> stack) {
		for(Character c: stack) {
			System.out.print(c + " ");
		}
		
		System.out.println();
	}

}
