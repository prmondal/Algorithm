package com.learning.algorithm.string;

import java.util.Scanner;

public class IpAddressCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(isValidIp(sc.next()));

	}

	private static boolean isValidIp(String ip) {
		// if the ip address does not contain dot
		if (ip.indexOf(".") == -1) {
			return false;
		}

		String[] arr = ip.split("\\.");

		// if more than three dots
		if (arr.length < 4)
			return false;

		for (String str : arr) {
			int num;

			// if the section is not number return false
			try {
				num = Integer.valueOf(str);
			} catch (Exception e) {
				return false;
			}

			// number is out of range
			if (num < 0 || num > 255) {
				return false;
			}
		}

		return true;
	}

}
