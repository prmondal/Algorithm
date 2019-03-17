package com.company.google;

import java.util.Scanner;

public class MagicSequenceGoogle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		
		if(inp.length() == 1) {
			System.out.println("1" + inp);
			return;
		}
		
		System.out.println(genSequence(inp));
		
		/*String result = new String("1");

		if (n == 1) {
			System.out.println(result);
			return;
		}

		System.out.print("1" + ", ");
		
		for (int i = 1; i <= n; i++) {
			result = genSequence(result);
			System.out.print(result + ", ");
		}*/
	}

	private static String genSequence(String s) {
		char[] c = s.toCharArray();
		int count = 0;
		char curr = c[0];
		StringBuilder result = new StringBuilder("");

		for (int i = 0, l = s.length(); i < l; i++) {
			if (curr == c[i]) {
				count++;
			} else {
				result.append(count + "" + curr);

				curr = c[i];
				count = 1;
			}
		}

		result.append(count + "" + curr);

		return result.toString();
	}

}
