package com.learning.algorithm.array;

import java.util.Scanner;

public class SpeakNumbers {
	public static void main(String[] args) {
		speakNumber(new Scanner(System.in).nextInt());
	}
	
	static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;
	   System.out.println(Math.random());
	   return (int)(Math.random() * range) + min;
	}

	static void speakNumber(int number) {
		String[] ones = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		
		String[] tens = { "", "", "twenty", "thirty", "fourty", "fifty",
				"sixty", "seventy", "eighty", "ninty" };
		
		String[] others = { "hundred", "thousand" };

		if (number < 0)
			return;

		char[] nums = (number + "").toCharArray();
		int l = nums.length, i = l - 1;

		if (l > 4) {
			System.out.println("Do not support more than 5 digits number!");
			return;
		}

		// handle single digit number
		if (l == 1) {
			System.out.print(ones[number]);
			return;
		}

		while (i >= 0) {
			char digit = nums[l - i - 1];

			if (i == 0) {
				System.out.print((digit == '0') ? "" : ones[digit - '0']);
			}

			// handle last two digits number
			if (i == 1) {
				// handle numbers between 10 and 20
				if (digit == '1') {
					System.out.print(ones[(digit - '0') * 10 + nums[l - i]
							- '0']);
					return;
				}

				if (digit == '0') {
					i--;

					continue;
				}

				System.out.print(tens[digit - '0'] + " ");
			}

			if (i == 2) {
				if (digit != '0') {
					System.out.print(ones[digit - '0'] + " " + others[0] + " ");
				}
			}

			if (i == 3) {
				System.out.print(ones[digit - '0'] + " " + others[1] + " ");
			}

			i--;
		}
	}
}
