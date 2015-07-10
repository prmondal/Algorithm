package com.learning.algorithm.linkedlist;

import java.util.HashMap;

public class LRU {
	private static final int MAX_CACHE_SIZE = 5;

	// doubly linked list stores pages in the nodes
	// least recently used page is located at the front of the queue and most
	// recently used page is located at the end of the queue
	private static DLL<String> pages = new DLL<String>();

	// LRU cache
	// map contains mapping from pages and corresponding node address in DLL
	// pages are represented as string for simplicity
	private static HashMap<String, DLL.Node<String>> cache = new HashMap<String, DLL.Node<String>>();

	private static void access(String key) {
		if (cache.containsKey(key)) {
			// remove the node from DLL and place it at the end of the queue
			DLL.Node<String> node = cache.get(key);

			// remove the node if it is not the end node
			if (node.next == null) {
				return;
			}

			pages.remove(node);

			// put at end
			pages.insertBack(key);

			// update cache
			cache.put(key, pages.peekLast());

			return;
		}

		// remove node at front and insert new node at the end of dll if the
		// size is full
		if (pages.getSize() >= MAX_CACHE_SIZE) {
			// remove from cache
			cache.remove(pages.peekFirst().key);

			// remove from dll
			pages.removeFront();
		}

		pages.insertBack(key);

		// update cache
		cache.put(key, pages.peekLast());
	}

	public static void main(String[] args) {
		// set max cache size
		pages.setMAX_SIZE(MAX_CACHE_SIZE);

		// access pages
		access("a");
		access("b");
		access("c");
		access("d");
		access("e");
		access("c");
		access("d");

		System.out.println("Most recently used page : " + pages.peekLast().key
				+ ", cache size : " + pages.getSize());

		System.out.println("\nCache : ");
		pages.print();
	}

}
