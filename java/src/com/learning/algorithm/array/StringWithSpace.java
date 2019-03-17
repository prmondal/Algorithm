package com.learning.algorithm.array;

import java.util.ArrayList;
import java.util.Scanner;

public class StringWithSpace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		ArrayList<String> list = insertSpaceAndPrint(in.nextLine());

		// System.out.println(list.size());

		for (String s : list) {
			System.out.println(s);
		}

	}

	private static ArrayList<String> insertSpaceAndPrint(String str) {
		if (str.length() == 1) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(str);

			return list;
		}

		ArrayList<String> temp = insertSpaceAndPrint(str.substring(0,
				str.length() - 1));

		ArrayList<String> _new = new ArrayList<String>();

		for (String s : temp) {
			_new.add(s + str.substring(str.length() - 1));
			_new.add(s + "-" + str.substring(str.length() - 1));
		}
		return _new;

	}

}
