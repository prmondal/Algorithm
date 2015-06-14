package com.learning.algorithm.array;

import java.util.HashMap;

public class LongestSubStringWithoutRepeat {

	public static void main(String[] args) {
		String str = "geekkforgeks";

		printLongestString(str, str.length());
	}

	private static void printLongestString(String str, int length) {
		// map contains previously seen character and its last location
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// put first character
		map.put(str.charAt(0), 0);

		// current length
		int currLength = 1;

		// store end position of max length
		int end = -1;

		// max length
		int maxLength = 1;

		// loop through all chars in string
		for (int i = 1; i < length; i++) {
			char c = str.charAt(i);

			// System.out.println("curr char : " + c);

			// if the char is not previously seen
			if (!map.containsKey(c)) {
				currLength++;

				// System.out.println("Not visited : " + c);

				// put the key in map
				map.put(c, i);

				// update max length
				if (currLength > maxLength) {
					maxLength = currLength;
					end = i;
					// System.out.println("Updated max length : " + maxLength);
				}

				continue;
			}

			// System.out.println("Visited : " + c);

			// if the char is seen already and inside current window
			int j = map.get(c);

			if (i - j <= currLength) {
				// System.out.println("In curr length : " + c);

				// update curr length
				currLength = i - j;

				// System.out.println("Updated curr length : " + currLength);
			} else {
				currLength++;
			}

			// update max length
			if (currLength > maxLength) {
				maxLength = currLength;
				end = i;
				// System.out.println("Updated max length : " + maxLength);
			}

			// update char location in map
			map.put(c, i);
		}
		
		// print the string
		System.out.println("Max string: "
				+ str.substring(end + 1 - maxLength, end + 1)
				+ " , Max Length : " + maxLength);
	}

}
