package com.practice.hackerrank.company;

import java.util.HashMap;
import java.util.Scanner;

public class MACLearning {
	static HashMap<String, Integer> map = new HashMap<String, Integer>(16);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			printOutPort(sc.nextInt(), sc.next(), sc.next());
		}
	}
	
	static void printOutPort(int iPort, String dest, String src) {
		if(isMulticast(src)) {
			System.out.println("drop");
			return;
		}
		
		if(map.containsKey(src)) {
			if(map.get(src) != iPort) {
				map.put(src, iPort);
			}
		} else {
			map.put(src, iPort);
		}
		
		if(isMulticast(dest)) {
			System.out.println("flood");
			return;
		}
		
		if(!map.containsKey(dest)) {
			System.out.println("flood");
		} else {
			int oPort = map.get(dest);
			
			if(oPort == iPort) {
				System.out.println("drop");
			} else {
				System.out.println(oPort);
			}
		}
	}
	
	static boolean isMulticast(String mac) {
		String firstByte = mac.split(":")[0];
		
		int bits = Integer.parseInt(firstByte, 16);
		
		return (bits & 1) != 0;
	}
}
