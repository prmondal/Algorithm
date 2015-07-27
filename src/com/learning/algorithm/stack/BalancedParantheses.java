package com.learning.algorithm.stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParantheses {
	static final HashMap<Character, Character> pair = new HashMap<Character, Character>();

	static {
		pair.put(')', '(');
		pair.put('}', '{');
		pair.put(']', '[');
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.println(balanced(sc.next()));
		}
	}

	static boolean balanced(String p) {
		Stack<Character> s = new Stack<Character>();
		int i = 0;
		char[] sym = p.toCharArray();

		while (i < sym.length) {
			if (sym[i] == '(' || sym[i] == '{' || sym[i] == '[') {
				s.push(sym[i]);
			} else {
				char curr = sym[i];

				if (s.isEmpty()) {
					return false;
				}

				char top = s.pop();

				if (top != pair.get(curr)) {
					return false;
				}
			}

			i++;
		}

		if (!s.isEmpty()) {
			return false;
		}

		return true;
	}

}
