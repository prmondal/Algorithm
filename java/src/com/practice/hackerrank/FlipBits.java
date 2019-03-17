package com.practice.hackerrank;

import java.util.Scanner;

public class FlipBits {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t > 0) {
            t--;
            
            System.out.println(~(sc.nextLong()) & 0xffffffffL); 
        }
    }
}
