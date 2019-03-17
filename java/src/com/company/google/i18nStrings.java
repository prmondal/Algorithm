package com.company.google;

import java.util.HashSet;

public class i18nStrings {
	static HashSet<String> set = new HashSet<String>();

	public static void main(String[] args) {

		String s = "careercup";

		generateAll18(s, 0, s.length() - 1);

		for (String e : set) {
			System.out.println(e);
		}
	}

	public static void generateAll18(String s, int i, int j) {
		if (i >= j)
			return;

		if (j - i - 1 > 0) {
			String s1 = s.substring(0, i + 1) + (j - i - 1 + "")
					+ s.substring(j);
			set.add(s1);
			generateAll18(s, i + 1, j);
		}

		if (j - 2 > 0) {
			String s2 = s.substring(0, 1) + (j - 2 + "") + s.substring(j - 1);
			set.add(s2);
			generateAll18(s, 1, j - 1);
		}
	}
}
