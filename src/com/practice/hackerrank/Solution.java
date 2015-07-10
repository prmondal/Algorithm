package com.practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static final int BIN_MAX = 1000;
	static long[][] binomial = new long[BIN_MAX + 1][BIN_MAX + 1];
	static long MOD = 1000000007;

	static long cacheBin(int N, int K) {
	      if (K < 0) {
	          return 0;
	      }
	      
	      if(K > N) {
	          binomial[N][K] = 0;
	          return 0;
	      }
	    
	      if (K == 0 || N == K) {
	          binomial[N][K] = 1;
	          return binomial[N][K];
	      }

	      if (binomial[N][K] != 0)
	          return binomial[N][K];

	      binomial[N][K] = bin(N - 1, K - 1) + bin(N - 1, K);
	      return binomial[N][K];
	 }
	
	//find C(N, K)
	static long bin(int N, int K) {
		if(N < K) return -1;
		long[][] table = new long[N + 1][N + 1];
		
		for(int n = 0; n <= N; n++) {
			table[n][0] = 1; 
		}
		
		for(int n = 0; n <= N; n++) {
			table[n][n] = 1; 
		}
		
		for(int n = 1; n <= N; n++) {
			for(int k = 1; k <= Math.min(n,  K); k++) {
				table[n][k] = table[n - 1][k - 1] + table[n - 1][k];
			}
		}
		
		return table[N][K];
	}
	
	// reverse a string from ith (0 index based) character to end
	static String reverse(int i, String s) {
		StringBuilder str = new StringBuilder(s);
		int L = str.length();

		for (int j = i; j < (L - i) / 2 + i; j++) {
			char t = str.charAt(j);
			char e = str.charAt(L + i - j - 1);

			str.setCharAt(j, e);
			str.setCharAt(L + i - j - 1, t);
		}

		return str.toString();
	}

	// reverse array between range
	static void reverseArray(int[] a, int l, int h) {
		for (int i = l; i < l + (h - l + 1) / 2; i++) {
			int t = a[i];
			a[i] = a[l + h - i];
			a[l + h - i] = t;
		}
	}

	// reverse array
	static void reverseArray(int[] a) {
		int l = a.length;

		for (int i = 0; i < l / 2; i++) {
			int t = a[i];
			a[i] = a[l - i - 1];
			a[l - i - 1] = t;
		}
	}

	// swap chrs in a string
	static String swap(int i, int j, String s) {
		StringBuilder str = new StringBuilder(s);

		char t = str.charAt(i);
		char cj = str.charAt(j);

		str.setCharAt(i, cj);
		str.setCharAt(j, t);

		return str.toString();
	}

	// find next higher permutation
	static String nextPermutation(String str) {
		int L = str.length(), idx1 = -1;

		// get largest index such that str[i] < str[i+1]
		for (int i = 0; i < L - 1; i++) {
			if (str.charAt(i) < str.charAt(i + 1)) {
				idx1 = i;
			}
		}

		// this is the last permutation
		if (idx1 == -1) {
			return str;
		}

		if (idx1 == L - 2) {
			return reverse(L - 2, str);
		}

		int idx2 = -1;

		// find largest index j > idx1 such that str[idx1] < str[j]
		for (int j = idx1 + 1; j < L; j++) {
			if (str.charAt(j) > str.charAt(idx1)) {
				idx2 = j;
			}
		}

		// swap
		str = swap(idx1, idx2, str);

		// reverse string after idx
		str = reverse(idx1 + 1, str);

		return str;
	}

	// gen all permutations
	static void genPerms(String str, int low, int high, ArrayList<String> list) {
		if (low == high) {
			list.add(str);
		} else {
			for (int j = low; j <= high; j++) {
				str = swap(low, j, str);
				genPerms(str, low + 1, high, list);
				str = swap(low, j, str);
			}
		}
	}
	
	//calculate phi given modulo
	static long phi(long n, int mod) {
		float result = n;
		
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				while(n % i == 0) {
					n /= i;
				}
				
				result *= (1.0 - (1 / (float) i));
				result %= mod;
			}
		}
		
		if(n > 1) {
			result *= (1.0 - (1 / (float) n));
			result %= mod;
		}
		
		return (long) result;
	}
	
	//calculate phi
	static long phi(long n) {
		float result = n;
		
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				while(n % i == 0) {
					n /= i;
				}
				
				result *= (1.0 - (1 / (float) i));
			}
		}
		
		if(n > 1) {
			result *= (1.0 - (1 / (float) n));
		}
		
		return (long) result;
	}

	// calculate fast power of base to the exponent
	// method - binary exponentiation
	static long power(long a, long b) {
		if (b == 0)
			return 1;

		if (a == 0)
			return 0;

		long result = 1;

		while (b > 0) {
			if ((b & 1) != 0)
				result *= a;

			a *= a;
			b >>= 1;
		}

		return result;
	}
	
	//modular binary exponentiation
	static long powerMod(long a, long b, int mod) {
		if (b == 0)
			return 1;

		if (a == 0)
			return 0;

		long result = 1;

		while (b > 0) {
			if ((b & 1) != 0) {
				result = (result * a) % mod;
			}

			a = (a * a) % mod;
			b >>= 1;
		}

		return result;
	}

	// Babylonian fast square root method
	private static float squareRoot(float n) {
		float x = n;
		float y = 1;

		float e = 0.000001f;

		while (x - y > e) {
			x = (x + y) / 2.0f;
			y = n / x;
		}

		return x;
	}

	// gen all prime factors
	static void genPrimeFacts(long n, List<Integer> primeFactors) {
		for (int i = 2; i * i <= n; i++) {
			int p = 1;

			while (n % i == 0) {
				p = i;
				n /= p;
				primeFactors.add(p);
			}
		}

		if (n > 1) {
			primeFactors.add((int) n);
		}
	}

	// populate primes using seives method
	static void seivePrimes(int n, ArrayList<Integer> list) {
		boolean[] isPrime = new boolean[n];

		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < n; j += i) {
					isPrime[j] = false;
				}

				list.add(i);
			}
		}
	}

	// check to see strings are anagram each other
	private static boolean anagramEachOther(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		HashMap<Character, Integer> set = new HashMap<Character, Integer>();

		int count = 0, l = str1.length();

		for (int i = 0; i < l; i++) {
			char c = str1.charAt(i);

			if (set.get(c) != null) {
				int n = set.get(c);

				// update existing key
				set.put(c, n + 1);
			} else {
				// put new key
				set.put(c, 1);
			}
		}

		for (int i = 0; i < l; i++) {
			char c = str2.charAt(i);

			if (set.containsKey(c)) {
				int n = set.get(c);

				// no match
				if (n == 0) {
					count++;

					continue;
				}

				// update count
				// decrement count for the match
				set.put(c, n - 1);

				continue;
			} else {
				count++;
			}
		}

		if (count > 0) {
			System.out.println(count);

			return false;
		}

		return true;
	}

	// count ones in binary
	static int countOnes(long n) {
		int count = 0;

		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}

	// palindrome check
	static boolean isPalindrom(String s) {
		StringBuilder str = new StringBuilder(s);
		int length = s.length();

		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) == str.charAt(length - 1 - i)) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	// Dijkstra's method
	static long gcd(long a, long b) {
		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);
		else
			return gcd(a, b - a);
	}
	
	// Euclid's method
	static long gcdAlt(long a, long b) {
		if(a % b == 0) return b;
		
		return gcdAlt(b, a % b);
	}

	static int binarySearch(int[] A, int x) {
		int l = 0, h = A.length - 1;

		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (A[mid] == x)
				return mid;

			if (A[mid] > x)
				h = mid - 1;
			else
				l = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		InputReader ip = new InputReader(System.in);
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

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public void readIntArray(int[] A, long N) {
			for (int i = 0; i < N; i++)
				A[i] = nextInt();
		}

		public void readLongArray(Long[] A, long N) {
			for (int i = 0; i < N; i++)
				A[i] = nextLong();
		}
	}
}
