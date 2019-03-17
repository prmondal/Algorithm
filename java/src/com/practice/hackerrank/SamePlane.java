package com.practice.hackerrank;

import java.util.Scanner;

public class SamePlane {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		while(T > 0) {
			int[] A = new int[3];
			int[] B = new int[3];
			int[] C = new int[3];
			int[] D = new int[3];
			
			for(int i = 0; i < 3; i++) {
				A[i] = sc.nextInt();
			}
			
			for(int i = 0; i < 3; i++) {
				B[i] = sc.nextInt();
			}
			
			for(int i = 0; i < 3; i++) {
				C[i] = sc.nextInt();
			}
			
			for(int i = 0; i < 3; i++) {
				D[i] = sc.nextInt();
			}
			
			if(isOnPlane(A, B, C, D)) {
				System.out.println("YES");
			} else 
				System.out.println("NO");
			
			T--;
		}
	}
	
	private static int[] vector(int[] A, int[] B) {
		return new int[] {A[0] - B[0], A[1] - B[1], A[2] - B[2]};
	}
	
	private static int[] crossProduct(int[] A, int[] B) {
		return new int[]{(A[1] * B[2] - B[1] * A[2]), -(A[0] * B[2] - B[0] * A[2]), (A[0] * B[1] - B[0] * A[1])};
	}
	
	private static boolean isOnPlane(int[] a, int[] b, int[] c, int[] d) {
		if(a[2] == b[2] && b[2] == c[2] && c[2] == d[2] && d[2] == a[2]) {
			return true;
		}
		
		/*int[] cross1 = crossProduct(vector(b, a), vector(d, a));
		int[] cross2 = crossProduct(vector(b, c), vector(d, c));
		
		if(dotProduct(normalize(cross1), normalize(cross2)) == 1) {
			return true;
		}*/
		//calculate plane equation with 3 points A, B, D
		int[] normal = crossProduct(vector(b, a), vector(d, a));
		
		int value = normal[0] * (c[0] - a[0]) + normal[1] * (c[1] - a[1]) + normal[2] * (c[2] - a[2]);
				
		if(value == 0) {
			return true;
		}
		
		return false;
	}
}
