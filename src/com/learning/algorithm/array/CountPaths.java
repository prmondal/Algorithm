package com.learning.algorithm.array;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class CountPaths {
   static int MOD = 1000000007;
   
    static int numberOfPaths(int [][]a,int M,int N) {
       if(a[M - 1][N - 1] == 0) return 0;
    	
       int[][] T = new int[M][N];
       
       T[M - 1][N - 1] = 1;
       
       //last row
       for(int j = 0; j < N - 1; j++) {
           if(a[M - 1][j] == 0) continue;
           
           //if current node has 1 and down node has 1 update table entry
    	   if(a[M - 1][j + 1] == 1) {
               T[M - 1][j] = 1;
           }
       }
       
       //last column
       for(int i = 0; i < M - 1; i++) {
           if(a[i][N - 1] == 0) continue;
           
           //if current node has 1 and right node has 1 update table entry
    	   if(a[i + 1][N - 1] == 1) {
               T[i][N - 1] = 1;
           }
       }
       
        for(int i = M - 1; i >= 0; i--) {
           for(int j = N - 1; j >= 0; j--) {
              if(a[i][j] == 0) continue;
              
        	  if(i + 1 < M && j + 1 < N) {
                T[i][j] = (T[i][j + 1] + T[i + 1][j]) % MOD;
              }
           }
       }
       
       return T[0][0];
    }
    
    /*static int numberOfPathsUtil(int[][] a, int i, int j, int M, int N) {
        if(i >= M || j >= N || a[i][j] == 0) return 0;
        
        if(i == M - 1 && j == N - 1 && a[i][j] == 1) return 1;
        
        return (numberOfPathsUtil(a, i, j + 1, M, N) + numberOfPathsUtil(a, i + 1, j, M, N)) % MOD;
    }*/
    
    

public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		int _a_cnt = 0,_b_cnt = 0;
		int [][] _a = new int[1001][1001];
		try {
			_a_cnt = sc.nextInt();
			_b_cnt = sc.nextInt();
		}catch (Exception e) {
			 System.out.println("Here: " + e.getMessage()); 
		} 

		for(int i=0; i < _a_cnt; i++) {
			for( int j = 0;j < _b_cnt;j++ ){
				int _a_tmp = 0;
				try {
					_a_tmp = sc.nextInt();
				}catch (Exception e) { }
				_a[i][j] = _a_tmp;
			}			
		}
		System.out.println(numberOfPaths (_a ,_a_cnt,_b_cnt));

	}
}