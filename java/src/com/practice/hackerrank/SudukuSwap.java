package com.practice.hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SudukuSwap {
	static int[][] grid = new int[9][9];
	static TreeSet<Point> p = null;

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);

		int t = r.nextInt();
		int c = 1;
		while (t-- > 0) {
			p = new TreeSet<Point>();

			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					grid[i][j] = r.nextInt();

			System.out.println("Case #" + c + ":");
			listSwaps();

			c++;
		}
	}

	static boolean isValidCol(int n, Point p) {
		for (int i = 0; i < 9; i++) {
			if (i == p.x)
				continue;

			if (grid[i][p.y] == n)
				return false;
		}

		return true;
	}

	static boolean isValidRow(int n, Point p) {
		for (int j = 0; j < 9; j++) {
			if (j == p.y)
				continue;

			if (grid[p.x][j] == n)
				return false;
		}

		return true;
	}

	static boolean isValidBox(int n, Point p) {
		int i = p.x;
		int j = p.y;
		int bx = 3 * (int) (i / 3);
		int by = 3 * (int) (j / 3);

		for (int m = bx; m <= bx + 2; m++) {
			for (int k = by; k <= by + 2; k++) {
				if (m == i && k == j)
					continue;

				if (grid[m][k] == n)
					return false;
			}
		}

		return true;
	}

	static void checkRow() {
		for (int i = 0; i < 9; i++) {
			HashMap<Integer, Point> map = new HashMap<Integer, Point>();
			Point[] d = new Point[2];

			for (int j = 0; j < 9; j++) {
				if (map.containsKey(grid[i][j])) {
					d[0] = map.get(grid[i][j]);
					d[1] = new Point(i, j);

					int n = grid[i][j];

					if (isValidCol(n, d[0])) {
						if (isValidBox(n, d[0])) {
							p.add(d[1]);
						} else {
							p.add(d[0]);
						}
					}

					if (isValidCol(n, d[1])) {
						if (isValidBox(n, d[1])) {
							p.add(d[0]);
						} else {
							p.add(d[1]);
						}
					}
				} else {
					map.put(grid[i][j], new Point(i, j));
				}
			}
		}
	}

	static void checkCol() {
		for (int j = 0; j < 9; j++) {
			HashMap<Integer, Point> map = new HashMap<Integer, Point>();
			Point[] d = new Point[2];

			for (int i = 0; i < 9; i++) {
				if (map.containsKey(grid[i][j])) {
					d[0] = map.get(grid[i][j]);
					d[1] = new Point(i, j);

					int n = grid[i][j];

					if (isValidRow(n, d[0])) {
						if (isValidBox(n, d[0])) {
							p.add(d[1]);
						} else {
							p.add(d[0]);
						}
					}

					if (isValidRow(n, d[1])) {
						if (isValidBox(n, d[1])) {
							p.add(d[0]);
						} else {
							p.add(d[1]);
						}
					}
				} else {
					map.put(grid[i][j], new Point(i, j));
				}
			}
		}
	}

	static boolean isRowValid(int[][] grid) {
		for (int i = 0; i < 9; i++) {
			boolean[] mem = new boolean[9];

			for (int j = 0; j < 9; j++) {
				if (mem[grid[i][j] - 1])
					return false;
				else
					mem[grid[i][j] - 1] = true;
			}
		}

		return true;
	}

	static boolean isColValid(int[][] grid) {
		for (int j = 0; j < 9; j++) {
			boolean[] mem = new boolean[9];

			for (int i = 0; i < 9; i++) {
				if (mem[grid[i][j] - 1])
					return false;
				else
					mem[grid[i][j] - 1] = true;
			}
		}

		return true;
	}

	static boolean isBoxValid(int[][] grid) {
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				boolean[] mem = new boolean[9];

				for (int m = i; m <= i + 2; m++) {
					for (int n = j; n <= j + 2; n++) {
						if (mem[grid[m][n] - 1])
							return false;
						else
							mem[grid[m][n] - 1] = true;
					}
				}
			}
		}

		return true;
	}

	private static void listSwaps() {
		checkRow();
		checkCol();

		if (p.size() == 0) {
			System.out.println("Serendipity");
		} else {
			int l = p.size();
			Point[] points = new Point[l];
			p.toArray(points);
			ArrayList<Container> result = new ArrayList<Container>();

			for (int i = 0; i < l; i++) {
				Point p1 = points[i];

				for (int j = i + 1; j < l; j++) {
					Point p2 = points[j];

					if (grid[p1.x][p1.y] == grid[p2.x][p2.y])
						continue;

					int[][] gridTest = new int[9][9];

					for (int m = 0; m < 9; m++) {
						for (int n = 0; n < 9; n++) {
							gridTest[m][n] = grid[m][n];
						}
					}

					int e = gridTest[p1.x][p1.y];
					gridTest[p1.x][p1.y] = gridTest[p2.x][p2.y];
					gridTest[p2.x][p2.y] = e;

					if (isRowValid(gridTest) && isColValid(gridTest)
							&& isBoxValid(gridTest)) {
						result.add(new Container(p1, p2));
					}
				}
			}

			Collections.sort(result);

			for (Container c : result) {
				System.out.println(c.p1 + " <-> " + c.p2);
			}
		}
	}

	static void printPoints() {
		for (Point point : p) {
			System.out.println(point);
		}
	}

	static class Container implements Comparable<Container> {
		Point p1;
		Point p2;

		Point p;

		Container(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
			this.p = new Point(grid[p1.x][p1.y], grid[p2.x][p2.y]);
		}

		@Override
		public int compareTo(Container o) {
			return this.p.compareTo(o.p);
		}

	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return String.format("(" + (x + 1) + "," + (y + 1) + ")");
		}

		@Override
		public int hashCode() {
			int hashCode = x;
			hashCode = 31 * hashCode + y;

			return hashCode;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null)
				return false;
			if (o == this)
				return true;
			if (!(o instanceof Point))
				return false;

			Point other = (Point) o;

			return (this.x == other.x && this.y == other.y);
		}

		@Override
		public int compareTo(Point o2) {
			if (this.x == o2.x)
				return this.y - o2.y;

			return this.x - o2.x;
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

}

