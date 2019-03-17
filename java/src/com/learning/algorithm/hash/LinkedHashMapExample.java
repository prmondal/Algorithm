package com.learning.algorithm.hash;

import java.util.Iterator;
import java.util.LinkedHashMap;


public class LinkedHashMapExample {
	public static void main(String[]args) {
		LinkedHashMap<String, String> lmap = new LinkedHashMap<String, String>(100, 0.75f, true);
		
		lmap.put("abc", "123");
		lmap.put("pqr", "456");
		lmap.put("xyz", "789");
		
		print(lmap);
		
		lmap.get("abc");
		lmap.get("pqr");
		lmap.get("abc");
		
		System.out.println("\n ===== Access ===== ");
		print(lmap);
	}
	
	static void print(LinkedHashMap<String, String> lmap) {
		Iterator<String> it = lmap.keySet().iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
