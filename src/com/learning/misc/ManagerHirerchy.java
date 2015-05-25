package com.learning.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ManagerHirerchy {
	static Map<String, Integer> countMap = new HashMap<String, Integer>();
	static Map<String, ArrayList<String>> mgrEmp = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		Map<String, String> empMgr = new HashMap<String, String>();
		empMgr.put("A", "A");
		empMgr.put("B", "A");
		empMgr.put("C", "A");
		empMgr.put("D", "B");
		empMgr.put("E", "B");
		empMgr.put("F", "B");

		countEmplyoees(empMgr);
	}

	static void countEmplyoees(Map<String, String> empMgr) {
		for (Entry<String, String> e : empMgr.entrySet()) {
			if (e.getKey().equals(e.getValue()))
				continue;

			if (mgrEmp.containsKey(e.getValue())) {
				mgrEmp.get(e.getValue()).add(e.getKey());
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(e.getKey());

				mgrEmp.put(e.getValue(), list);
			}
		}

		for (Entry<String, String> e : empMgr.entrySet()) {
			if (!mgrEmp.containsKey(e.getKey()))
				countMap.put(e.getKey(), 0);
			else {
				countUtil(e.getKey());
			}
		}

		for(Entry<String, Integer> e : countMap.entrySet()) 
			System.out.println(e.getKey() + "-" + e.getValue());
	}

	private static int countUtil(String mng) {
		if (countMap.containsKey(mng))
			return countMap.get(mng);

		int count = 0;

		if (!mgrEmp.containsKey(mng)) {
			countMap.put(mng, count);
			return 0;
		}

		for (String emp : mgrEmp.get(mng)) {
			count += countUtil(emp) + 1;
		}

		countMap.put(mng, count);

		return count;
	}

}
