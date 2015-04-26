package com.learning.algorithm.numerical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> primeFactors = new ArrayList<Integer>();

		for (int i = 2; i * i <= N; i++) {
			int p = 1;

			while (N % i == 0) {
				p = i;
				N /= p;
				primeFactors.add(p);
			}
		}

		if (N > 1) {
			primeFactors.add(N);
		}

		for (int i = 0; i < primeFactors.size(); i++)
			System.out.print(primeFactors.get(i) + " ");
	}

}
