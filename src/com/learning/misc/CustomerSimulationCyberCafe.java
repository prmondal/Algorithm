package com.learning.misc;

import java.util.HashSet;
import java.util.Scanner;

public class CustomerSimulationCyberCafe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		runCustomerSimulation(sc.nextInt(), sc.next());
	}

	private static void runCustomerSimulation(int n, String str) {
		if (str.isEmpty() || n == 0)
			return;

		HashSet<Character> customers = new HashSet<Character>();

		int l = str.length();

		int numberCurrentCustomers = 0;
		int result = 0;

		for (int i = 0; i < l; i++) {
			char c = str.charAt(i);

			if (customers.contains(c)) {
				numberCurrentCustomers--;
			} else {
				numberCurrentCustomers++;

				if (numberCurrentCustomers > n) {
					result++;
				}

				customers.add(c);
			}
		}

		System.out.println(result);
	}
}
