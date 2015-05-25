package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSimilarity {
	static ArrayList<Suffix> suffixes = new ArrayList<Suffix>();
	static String test;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		//BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream("test.txt"));
		
		while (t > 0) {
			test = sc.next();
			t--;
			
			// generate all the suffixes and store in the list
			genSuffixes(test);

			System.out.println(similarity());
			//bufferedOutput.write((similarity() + "\n").getBytes());
		}
		
		//bufferedOutput.close();
	}

	static int similarity() {
		int similarityCount = 0;

		for (Suffix suff : suffixes) {
			similarityCount += getSimilarity(suff.str);
		}

		return similarityCount;
	}

	static int getSimilarity(String str) {
		int count = 0;

		for (int i = 0, lt = test.length(), lp = str.length(); i < lt && i < lp; i++) {
			if (test.charAt(i) == str.charAt(i))
				count++;
			else
				return count;
		}

		return count;
	}

	static void printSuffArr() {
		for (Suffix sx : suffixes) {
			System.out.println(sx.str + " " + sx.index);
		}
	}

	static void genSuffixes(String str) {
		suffixes = new ArrayList<Suffix>();
		
		for (int i = 0, l = str.length(); i < l; i++)
			suffixes.add(new Suffix(str.substring(i), i));
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
