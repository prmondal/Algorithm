package com.learning.algorithm.hash;

import java.util.HashSet;

public class RemoveWords {
	private static HashSet<String> dict;

	public static void main(String[] args) {
		dict = new HashSet<String>();
		
		// populate dictionary
		dict.add("a");
		dict.add("be");
		dict.add("to");
		dict.add("the");
		dict.add("that");
		dict.add("this");
		dict.add("or");

		String text = "To be or not to be - that is the question: Whether it is nobler in the mind to suffer, the slings and arrows of outrageous fortune. Or to take up arms against a sea of troubles, and by opposing end them";

		String modified = removeWords(text.toLowerCase());

		System.out.println(modified);
	}

	private static String removeWords(String text) {
		String[] wordList = text.split(" ");

		String finalText = "";

		for (String word : wordList) {
			if (!dict.contains(word)) {
				finalText += word + " ";
			}
		}

		return finalText;
	}

}
