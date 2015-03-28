package com.learning.algorithm.hash;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMapValues {
	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<Integer, String>();

		hmap.put(1, "bac");
		hmap.put(2, "ab");
		hmap.put(3, "y");
		hmap.put(4, "w");

		printMap(hmap);

		// sort map
		Map<Integer, String> sortedMap = sortMap(hmap);

		System.out.println("Sort by values\n");
		printMap(sortedMap);
	}

	private static Map<Integer, String> sortMap(Map<Integer, String> map) {
		Map<Integer, String> linkedMap = new LinkedHashMap<Integer, String>();

		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(
				map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> e1,
					Entry<Integer, String> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}

		});

		for (Map.Entry<Integer, String> e : list) {
			linkedMap.put(e.getKey(), e.getValue());
		}

		return linkedMap;
	}

	static void printMap(Map<Integer, String> map) {
		Set<Map.Entry<Integer, String>> set = map.entrySet();

		Iterator<Map.Entry<Integer, String>> it = set.iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, String> e = it.next();

			System.out.println("Key: " + e.getKey() + " , value: "
					+ e.getValue());
		}
	}
}
