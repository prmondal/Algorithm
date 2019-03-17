package com.learning.algorithm.string;

import java.util.Scanner;

public class RunLengthCoding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(runLengthCoding(sc.next()));
	}

	private static String runLengthCoding(String str) {
		if (str.length() == 0)
			return "";

		String result = "";

		int m = str.length();
		int count = 1;

		for (int i = 0; i < m - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				result += str.charAt(i) + String.valueOf(count);
				count = 1;
			}

			if (i == m - 2) {
				result += str.charAt(i + 1) + String.valueOf(count);
				count = 1;
			}
		}

		return result;
	}
}
