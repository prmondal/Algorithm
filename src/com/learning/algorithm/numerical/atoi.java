package com.learning.algorithm.numerical;

public class atoi {
	static int _atoi(char[] array) {
		int l = array.length;

		int result = 0;
		char sign = '+';

		for (int i = 0; i < l; i++) {
			if (sign != '-' && array[i] == '-') {
				sign = '-';
				continue;
			}

			if (array[i] == '-' || array[i] < '0' || array[i] > '9') {
				throw new NumberFormatException();
			}

			result = (array[i] - '0') + 10 * result;
		}

		if (sign == '-') {
			return -result;
		} else
			return result;
	}

	public static void main(String[] args) {
		System.out.println(_atoi(new char[] { '-', '1', '2', '3' }));
	}

}
