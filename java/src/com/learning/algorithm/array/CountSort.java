package com.learning.algorithm.array;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] array = new int[N];

		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		countSort(array, array.length);
	}

	private static void countSort(int[] array, int n) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); 
		
		for(int i = 0; i < n; i++) {
			int e = array[i];
			if(map.containsKey(e)) {
				int c = map.get(e);
				map.put(e, c + 1);
			} else {
				map.put(e, 1);
			}
		}
		
		Set<Entry<Integer, Integer>> set = map.entrySet();
		
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<Integer, Integer> next = it.next();
			
			int key = next.getKey();
			int c = next.getValue();
			
			while(c > 0) {
				System.out.println(key);
				c--;
			}
		}
	}
}
