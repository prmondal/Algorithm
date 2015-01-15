package com.practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectTowns {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T > 0) {
            T--;
            
            int N = sc.nextInt();
            
            int[] L = new int[N - 1];
            
            long result = 1;
            
            for(int i = 0; i < N - 1; i++) L[i] = sc.nextInt();
            
            for(int i = 0; i < N - 1; i++) result = result * (long) L[i] % 1234567;
                
                
            
            System.out.println(result % 1234567);
        }
    }
}