package com.learning.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SuffixArray {
	static ArrayList<Suffix> suffixes = new ArrayList<Suffix>();
	static String test = "hellohello";
	static String pattern = "hellohello";

	public static void main(String[] args) {
		init();

		// printSuffArr();

		findAllMatches(pattern);
	}

	static void init() {
		// generate all the suffixes and store in the list
		genSuffixes(test);

		// lexicographically sort the suffix array
		Collections.sort(suffixes, new Comparator<Suffix>() {
			@Override
			public int compare(Suffix s1, Suffix s2) {
				return s1.str.compareTo(s2.str);
			}

		});
	}

	static void findAllMatches(String p) {
		int l = 0, h = suffixes.size() - 1, start = -1, end = -1;

		// do binary search to get the start of the interval
		while (l < h) {
			int mid = l + (h - l) / 2;
			Suffix suff = suffixes.get(mid);

			// check whether the suffix contains the pattern
			if (containsPattern(suff.str, p) || p.compareTo(suff.str) < 0) {
				h = mid;
			} else
				l = mid + 1;
		}

		start = l;
		h = suffixes.size() - 1;

		// do binary search to get the end of the interval
		while (l < h) {
			int mid = l + (h - l) / 2;
			Suffix suff = suffixes.get(mid);

			if (containsPattern(suff.str, p) || p.compareTo(suff.str) > 0) {
				l = mid + 1;
			} else
				h = mid;
		}

		if (containsPattern(suffixes.get(h).str, p))
			end = h;
		else
			end = h - 1;

		if (end < start) {
			System.out.println("Pattern not found!");
			return;
		}

		System.out
				.println("\n === Pattern is found at the following locations === ");

		for (int i = end; i >= start; i--)
			System.out.print(suffixes.get(i).index + " ");
	}

	// utility method to check for the pattern in the text
	// it prints the position of the pattern first found
	// it does not match all the patterns
	static void findPattern(String p) {
		int l = 0, h = suffixes.size() - 1;

		while (l <= h) {
			int mid = l + (h - l) / 2;
			Suffix suff = suffixes.get(mid);

			if (containsPattern(suff.str, p)) {
				System.out.println("Pattern \"" + pattern
						+ "\" found at position " + suff.index
						+ " in the text \"" + test + "\"");
				return;
			}

			if (p.compareTo(suff.str) < 0) {
				h = mid - 1;
			} else if (p.compareTo(suff.str) > 0)
				l = mid + 1;
		}

		System.out.println("Pattern does not exist!");
	}

	static void printSuffArr() {
		System.out.println(" ==== Suffix Array === ");

		for (Suffix sx : suffixes) {
			System.out.println(sx.str + " " + sx.index);
		}

		System.out.println();
	}

	static void genSuffixes(String str) {
		for (int i = 0, l = str.length(); i < l; i++)
			suffixes.add(new Suffix(str.substring(i), i));
	}

	// utility to check whether the test string contains pattern p
	static boolean containsPattern(String test, String p) {
		if (p.length() > test.length() || p.length() == 0)
			return false;

		for (int i = 0, l = p.length(); i < l; i++)
			if (p.charAt(i) != test.charAt(i))
				return false;

		return true;
	}

	static class Suffix {
		String str;
		int index;

		Suffix(String str, int i) {
			this.str = str;
			this.index = i;
		}
	}
}
