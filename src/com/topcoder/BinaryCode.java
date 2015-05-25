package com.topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

class BinaryCode {
	public static String[] decode(String message) {
		String[] result = { "", "" };

		result[0] = getDecodedString(message, 0);
		result[1] = getDecodedString(message, 1);

		return result;
	}

	static String getDecodedString(String message, int f) {
		int l = message.length();
		int[] p = new int[l];
		String result = "";

		p[0] = f;

		for (int i = 1; i < l; i++) {
			if (i == 1) {
				p[i] = message.charAt(0) - '0' - p[0];

				if (p[i] > 1) {
					result = "NONE";
					break;
				}

				continue;
			}

			if (i == l - 1) {
				p[i] = message.charAt(i) - '0' - p[i - 1];
				continue;
			}

			p[i] = message.charAt(i - 1) - '0' - p[i - 1] - p[i - 2];

			if (p[i] > 1) {
				result = "NONE";
				break;
			}
		}

		if (result == "") {
			for (int i = 0; i < l; i++)
				result += p[i];
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(decode("11")[1]);
	}

}
// Powered by [KawigiEdit] 2.0!