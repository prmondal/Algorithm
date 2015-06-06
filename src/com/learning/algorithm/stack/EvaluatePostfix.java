package com.learning.algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] tokens = sc.next().toCharArray();
		
		Stack<Float> stack = new Stack<Float>();
		
		evaluate(stack, tokens);
	}
	
	static boolean isValid(Stack<Float> stack) {
		if(stack.size() <= 1) {
			System.out.println("Not enough operands found!");
			return false;
		}
		
		return true;
	}
	
	static void evaluate(Stack<Float> stack, char[] tokens) {
		int l = tokens.length, i = 0;
		
		while(i < l) {
			if(tokens[i] == '+') {
				if(!isValid(stack)) return;
				
				stack.push(stack.pop() + stack.pop());
			} else if(tokens[i] == '-') {
				if(!isValid(stack)) return;
				
				float f1 = stack.pop();
				float f2 = stack.pop();
				
				stack.push(f2 - f1);
			} else if(tokens[i] == '*') {
				if(!isValid(stack)) return;
				
				stack.push(stack.pop() * stack.pop());
			} else if(tokens[i] == '/') {
				if(!isValid(stack)) return;
				
				float f1 = stack.pop();
				float f2 = stack.pop();
				
				stack.push(f2 / f1);
			} else {
				stack.push(Float.valueOf(tokens[i] + ""));
			}
			
			i++;
		}
		
		System.out.println(stack.get(0));
	}

}
