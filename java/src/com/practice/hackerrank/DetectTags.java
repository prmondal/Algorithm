package com.practice.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectTags {

	public static void main(String[] args) {
		String input = "<p id=\"p-tag\"><a href=\"http://www.quackit.com/html/tutorial/html_links.cfm\">Example Link</a></p>";

		Pattern p = Pattern.compile("<([a-z]+\\s+)([a-z]+)"); // <([a-z]+)(\s*[a-z]+)*
																// //<([a-z]+\s*)([a-z]+)*
																// //(\S+)=
		Matcher m = p.matcher(input);

		while (m.find()) {
			System.out.println(m.group(1) + ":" + m.group(2));
		}
	}

}
