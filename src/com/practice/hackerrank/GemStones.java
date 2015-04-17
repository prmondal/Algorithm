package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class GemStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 1; i <= N; i++)
			list.add(sc.next());

		countGemElems(list, list.size());
	}

	static void countGemElems(ArrayList<String> list, int N) {
		String first = removeDuplicates(new StringBuilder(list.get(0)));

		int count = 0;
		boolean missing = false;

		for (int i = 0; i < first.length(); i++) {
			missing = false;

			for (int j = 1; j < N && !missing; j++) {
				String str = list.get(j);

				if (str.indexOf(first.charAt(i)) == -1)
					missing = true;
			}

			if (!missing)
				count++;
		}

		System.out.println(count);
	}

	static String removeDuplicates(StringBuilder str) {
		int l = str.length(), i = 0, k = 0;
		boolean[] map = new boolean[26];

		while (i < l) {
			if (!map[str.charAt(i) - 'a']) {
				map[str.charAt(i) - 'a'] = true;

				char t = str.charAt(i);
				str.setCharAt(k, t);

				i++;
				k++;
			} else {
				i++;
			}
		}

		return str.substring(0, k).toString();
	}
}
