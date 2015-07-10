package com.learning.algorithm.hash;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRU<K extends Comparable<K>, V extends Comparable<V>> extends
		LinkedHashMap<K, V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static private int capacity;
	static final int MAX_ENTRY = 5;
	static int accessCount = 0;
	static int hitCount = 0;

	LinkedHashMapLRU(int size, float loadFactor, boolean accessOrdered) {
		super(size, loadFactor, accessOrdered);
		capacity = size;
	}

	static int getCapacity() {
		return capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return super.size() > MAX_ENTRY;
	}

	V getKey(K key) {
		accessCount++;

		if (this.containsKey(key)) {
			hitCount++;
			return this.get(key);
		}

		return null;
	}
	
	void print() {
		Iterator<K> it = this.keySet().iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
	}
	
	public static void main(String[] args) {
		LinkedHashMapLRU<String, String> lru = new LinkedHashMapLRU<String, String>(10, 0.75f, true);
		
		lru.put("a", "1");
		lru.put("b", "2");
		lru.put("c", "3");
		lru.put("d", "4");
		lru.put("e", "5");
		lru.put("f", "6");
		lru.put("g", "7");
		
		System.out.println("Original");
		lru.print();
		
		System.out.println("\nAccess \"c\"");
		lru.getKey("c");
		lru.print();
		
		System.out.println("\nAccess \"e\"");
		lru.getKey("e");
		lru.print();
	}
}
