package com.learning.algorithm.string;

public class RemoveWhitespace {

	public static void main(String[] args) {
		String s = "a  bb     ccc       ddddddddd           eeeeeeeeee";

		// s = removeSpaces(s);

		// System.out.println(s);
		remove(s);
	}

	// extra space
	static String removeSpaces(String s) {
		StringBuilder result = new StringBuilder();
		boolean found = false;

		for (int i = 0, l = s.length(); i < l; i++) {
			if (s.charAt(i) != ' ') {
				result.append(s.charAt(i));
				found = false;
			} else {
				if (result.length() > 0) {
					if (!found) {
						found = true;
						result.append(' ');
					}
				}
			}
		}

		return result.toString();
	}

	//need to check
	static void remove(String s) {
		StringBuilder result = new StringBuilder(s);
		int k = -1, i = 0, l = result.length();

		while (i < l) {
			if (result.charAt(i) == ' ') {
				if (i >= 1 && result.charAt(i - 1) != ' ') {
					if (k == -1)
						k = i;
					
					k++;
				}

				i++;
				continue;
			}

			result.setCharAt(k + 1, result.charAt(i));
			
			k++;
			i++;
		}
		
		System.out.println(result.substring(0, k));
	}

}
