package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class HypercubeGeometry {

	public static void main(String[] args) {
		/*ArrayList<String> l = new ArrayList<String>();
		genCoordinates(9, 5, l, new StringBuilder(""));
		for(String s : l)
			System.out.println(s);*/
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T > 0) {
			T--;

			int N = sc.nextInt();
			int d = sc.nextInt();
			int K = sc.nextInt();

			ArrayList<String> cities = null;
			ArrayList<StringBuilder> marketLoc = new ArrayList<StringBuilder>();

			for (int i = 1; i <= K; i++) {
				StringBuilder m = new StringBuilder("");

				for (int j = 1; j <= d; j++) {
					m.append(sc.next());
				}

				marketLoc.add(m);
				cities = new ArrayList<String>();
				
				genCoordinates(N, d, cities, new StringBuilder(""));
				System.out.println(getSum(marketLoc, cities, d));
			}
		}
	}

	private static void genCoordinates(int n, int d, ArrayList<String> list,
			StringBuilder str) {
		if (d == 0) {
			list.add(str.toString());
			return;
		}

		for (int i = 1; i <= n; i++) {
			str.append(i);
			genCoordinates(n, d - 1, list, str);
			str.setLength(str.length() - 1);
		}
	}

	private static long getSum(ArrayList<StringBuilder> marketLoc,
			ArrayList<String> cities, int d) {
		long sum = 0;
		int C = cities.size();
		int K = marketLoc.size();

		for (int c = 0; c < C; c++) {
			long minSum = Integer.MAX_VALUE;

			for (int m = 0; m < K; m++) {
				long s = getManhattenDist(cities.get(c), marketLoc.get(m), d);
				
				if (s < minSum)
					minSum = s;
			}

			sum += minSum;
		}

		return sum;
	}

	private static int getManhattenDist(String city, StringBuilder market, int d) {
		int sum = 0;

		for (int i = 0; i < d; i++) {
			sum += Math.abs(city.charAt(i) - market.charAt(i));
		}

		return sum;
	}
}
