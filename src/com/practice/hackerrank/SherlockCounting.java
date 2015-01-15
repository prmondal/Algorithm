package com.practice.hackerrank;

import java.util.Scanner;

public class SherlockCounting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		while(T > 0) {
			T--;
			
			long N = sc.nextLong();
			long K = sc.nextLong();
			
			long i = 1;
			int count = 0;
			
			System.out.println(N*K);
			
			/*while(N / 2 >= i && i * (N - i) <= N * K) {
				count++;
				i++;
			}
			
			System.out.println(2 * count);*/
			/*double nk = Math.sqrt(N * N - 4 * N * K);
			
			System.out.println((N - nk) / 2 + " " + (N + nk) / 2);
			
			while(N > i) {
				if(i <= (N - nk) / 2) {
					//i++;
					count++;
				} else if(i >= (N + nk) / 2) {
					count++;
				}
				
				i++;
			}
			
			System.out.println(count);*/
		}

	}

}
