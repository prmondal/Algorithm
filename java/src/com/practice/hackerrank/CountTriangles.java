package com.practice.hackerrank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountTriangles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T > 0) {
			T--;

			int L = sc.nextInt();

			//Point[] points = new Point[L];

			/*for (int i = 0; i < L; i++) {
				points[i] = new Point((float) Math.cos(2 * Math.PI * i / L),
						(float) Math.sin(2 * Math.PI * i / L));
			}*/

			String pattern = "";

			pattern = sc.next();

			countTriangles(pattern, L);
		}
	}

	static void countTriangles(String pattern, int N) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// can be optimized
		for (int i = 0; i <= N - 3; i++) {
			for (int j = i + 1; j <= N - 2; j++) {
				for (int k = j + 1; k <= N - 1; k++) {
					// need to have at least one unblocked point
					if (((pattern.charAt(i) - '0') + (pattern.charAt(j) - '0')
							+ (pattern.charAt(k) - '0')) == 0)
						continue;
					
					int[] temp = {
							Math.abs(j - i), 
							Math.abs(k - j), 
							Math.abs(i + N - k)
						};
					
					Arrays.sort(temp);
					
					String key = "" + temp[0] + temp[1] + temp[2];
					
					if (map.containsKey(key)) {
						map.put(key, map.get(key) + 1);
					} else {
						map.put(key, 1);
					}
				}
			}
		}

		int count = 0;

		// count pairs
		for (int n : map.values()) {
			count += n * (n - 1) >> 1;
		}

		System.out.println(count);
	}

	// calculate area using cross product
	static float getArea(Point a, Point b, Point c) {
		DecimalFormat df = new DecimalFormat("###.####");

		return Float.valueOf(df.format(Math.abs((c.x - a.x) * (b.y - a.y)
				- (b.x - a.x) * (c.y - a.y))));
	}

	static class Point {
		float x;
		float y;

		Point(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
}
