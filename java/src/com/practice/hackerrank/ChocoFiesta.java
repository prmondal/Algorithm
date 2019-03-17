package com.practice.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class ChocoFiesta {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), evenCount = 0, oddCount = 0;
        
        for(int i = 0; i < N; i++) {
            int c = sc.nextInt();
            if((c & 1) != 0) oddCount++;
        }
        
        evenCount = N - oddCount;
        
        if(evenCount == 0) {
        	System.out.println((new BigInteger("2").pow(oddCount - 1).subtract(new BigInteger("1"))).mod(BigInteger.valueOf(1000000007)));
        } else if(oddCount == 0) {
        	System.out.println((new BigInteger("2").pow(evenCount).subtract(new BigInteger("1"))).mod(BigInteger.valueOf(1000000007)));
        } else 
        	System.out.println((new BigInteger("2").pow(evenCount + oddCount - 1).subtract(new BigInteger("1"))).mod(BigInteger.valueOf(1000000007)));
    }
}
