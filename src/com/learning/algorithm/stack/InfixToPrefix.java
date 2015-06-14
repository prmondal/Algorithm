package com.learning.algorithm.stack;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {
		infixToPrefix(new Scanner(System.in).next().toCharArray());

	}

	static boolean isOperand(char c) {
		return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
	}

	static void infixToPrefix(char[] tokens) {
		int i = 0, l = tokens.length;

		while (i < l) {
			if (isOperand(tokens[i])) {
				System.out.print(tokens[i]);

				i++;
				continue;
			}

			if (tokens[i] == '(') {
				stack.push('(');
				i++;
				continue;
			}

			if (tokens[i] == ')') {
				while (stack.peek() != '(' && !stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				
				//remove (
				stack.pop();

				i++;
				continue;
			}

			if (getPriority(tokens[i]) == -1) {
				System.out.println("Invalid operator found!!!");
				return;
			}

			while (!stack.isEmpty()
					&& getPriority(stack.peek()) >= getPriority(tokens[i])) {
				System.out.print(stack.pop());
			}

			stack.push(tokens[i]);

			i++;
		}

		ListIterator<Character> it = stack.listIterator(stack.size());

		while (it.hasPrevious()) {
			System.out.print(it.previous());
		}
	}

	static int getPriority(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		default:
			return -1;

		}
	}
}
