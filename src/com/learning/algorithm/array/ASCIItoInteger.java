package com.learning.algorithm.array;

public class ASCIItoInteger {
	static int atoi(char[] array) {
		int l = array.length;

		int result = 0;
		int prev = 0;
		char sign = ' ';

		for (int i = 0; i < l; i++) {
			if (i == 0 && array[i] == '-') {
				sign = '-';
				continue;
			}

			if (array[i] == '-' || array[i] < '0' || array[i] > '9') {
				throw new NumberFormatException();
			}

			prev = array[i];

			result = prev + 10 * result - '0';
		}

		if (sign == '-') {
			return result * -1;
		} else
			return result;
	}

	public static void main(String[] args) {
		System.out.println(atoi(new char[] { '-', '1', 'a', '3' }));
	}
}