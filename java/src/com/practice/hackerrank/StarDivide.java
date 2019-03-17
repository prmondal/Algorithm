package com.practice.hackerrank;

import java.util.Scanner;

public class StarDivide {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		long[][] stars = new long[N][3];
		
		for(int i = 0; i < N; i++) {
			stars[i] = new long[]{sc.nextLong(), sc.nextLong(), sc.nextLong()};
		}
		
		getSmallerSubsetWeight(stars, N);
	}
	
	private static void getSmallerSubsetWeight(long[][] stars, int N) {
		long minDiff = Long.MAX_VALUE;
		long maxSmaller = 0;
		
		//loop through each star
		for(int i = 0; i < N; i++) {
			long[] a = stars[i];
			
			for(int j = 0; j < N; j++) {
				//do not consider the selected star again
				if(i == j)
					continue;
				
				long[] b = stars[j];
				
				//reset values
				long w1 = 0;
				long w2 = 0;
				
				//System.out.println("Line: "  + i + " ," + j + "|| w1, w2: " + w1 + " ," + w2) ;
				
				//check for rest of the n - 2 points
				for(int k = 0; k < N; k++) {
					//check the orientation of other stars relative to the line
					if(i == k || j == k)
						continue;
					
					//calculate for other points
					if(isLeftSided(a, b, stars[k])) {
						w2 += stars[k][2];
						//System.out.println("Point: "  + k + " left" + " w2: " + w2) ;
					} else {
						w1 += stars[k][2];
						//System.out.println("Point: "  + k + " right" + " w1: " + w1) ;
					}
				}
				
				//one subset is empty
				if(w1 == 0) {
					w1 += a[2] + b[2];
					//System.out.println("W1 is zero!");
				} else if(w2 == 0){
					w2 += a[2] + b[2];
					//System.out.println("W2 is zero!");
				} else {
					//both subset non-empty
					long tempdiff1;
					long tempdiff2;
					
					//line can be passed before 1-b line or after a-b line
					//consider two cases and get which one gives the minimum difference
					long temp1 = w1;
					temp1 += a[2] + b[2];
					
					if(temp1 < w2) {
						tempdiff1 = w2 - temp1;
					} else {
						tempdiff1 = temp1 - w2;
					}
					
					long temp2 = w2;
					temp2 += a[2] + b[2];
					
					if(temp2 < w1) {
						tempdiff2 = w1 - temp2;
					} else {
						tempdiff2 = temp2 - w1;
					}
					
					
					//add the weight to the smaller subset
					if(tempdiff1 < tempdiff2) {
						w1 = temp1;
					} else {
						w2 = temp2;
					}
				}
				
				//System.out.println("W1 : " + w1 + "| W2: " + w2 );
				
				//calculate minimum difference and maximum smaller subset sum weight
				if(w1 < w2) {
					if(w2 - w1 < minDiff) {
						minDiff = w2 - w1;
						
						if(w1 > maxSmaller) {
							maxSmaller = w1;
						}
					} 
				} else {
					if(w1 - w2 < minDiff) {
						minDiff = w1 - w2;
						
						if(w2 > maxSmaller) {
							maxSmaller = w2;
						}
					} 
				}
			}
		}
		
		System.out.println(maxSmaller);
	}

	//no three points are on the line
	private static boolean isLeftSided(long[] a, long[] b, long[] point) {
		long check = (b[0]  - a[0]) * (point[1] - a[1]) - (point[0] - a[0]) * (b[1] - a[1]);
		
		if(check > 0) {
			return true;
		} else {
			return false;
		}
	}
}
